import java.util.*;
import java.util.stream.Collectors;

class Twitter {

    private static Integer timeStamp = 0;
    private Map<Integer, List<Tweet>> tweetStore;
    private Map<Integer, List<Tweet>> newsFeedStore;
    private Map<Integer, Set<Integer>> followerStore;
    private Map<Integer, Set<Integer>> followeeStore;

    public Twitter() {
        tweetStore = new HashMap<>();
        followerStore = new HashMap<>();
        followeeStore = new HashMap<>();
        newsFeedStore = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        //insert posts
        Tweet tweet = new Tweet(userId, tweetId);
        List<Tweet> posts = tweetStore.getOrDefault(userId, new LinkedList<>());
        posts.add(tweet);

        //save posts list
        tweetStore.put(userId, posts);
        insertMyNewFeed(userId, tweet);
        insertFolloweeNewsFeed(userId, tweet);
    }

    private void insertFolloweeNewsFeed(int userId, Tweet tweet){
        followeeStore.getOrDefault(userId, new HashSet<>())
                .forEach(id -> {
                    List<Tweet> newsFeeds = newsFeedStore.getOrDefault(id, new LinkedList<>());
                    newsFeeds.add(0, tweet);
                    newsFeedStore.put(id, newsFeeds);
                });
    }

    private void insertMyNewFeed(int userId, Tweet tweet){
        List<Tweet> newsFeeds = newsFeedStore.getOrDefault(userId, new LinkedList<>());
        newsFeeds.add(tweet);

        newsFeedStore.put(userId, newsFeeds);
    }

    private void removeUnfollowIdNewsFeed(int followerId, int followeeId){
        tweetStore.getOrDefault(followeeId, new LinkedList<>())
                .forEach(tweetId -> newsFeedStore.getOrDefault(followerId, new LinkedList<>()).remove(tweetId));
    }

    private void insertFollowIdNewsFeed(int followerId, int followeeId){
        tweetStore.getOrDefault(followeeId, new LinkedList<>())
                .forEach(tweet -> {
                    List<Tweet> newsFeeds = newsFeedStore.getOrDefault(followerId, new LinkedList<>());
                    newsFeeds.add(tweet);
                    newsFeedStore.put(followerId, newsFeeds);
                });
    }

    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> newsFeeds = newsFeedStore.getOrDefault(userId, new LinkedList<>());
        newsFeeds.sort((o1, o2) -> o2.time - o1.time);
        return newsFeeds.stream()
                .map(feed -> feed.postId)
                .limit(10)
                .collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> follower = followerStore.getOrDefault(followerId, new HashSet<>());
        Set<Integer> followee = followeeStore.getOrDefault(followeeId, new HashSet<>());

        boolean followerState = follower.add(followeeId);
        boolean followeeState = followee.add(followerId);

        followerStore.put(followerId, follower);
        followeeStore.put(followeeId, followee);
        if (followeeState && followerState) insertFollowIdNewsFeed(followerId, followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerStore.containsKey(followerId)) followerStore.get(followerId).remove(followeeId);
        if (followeeStore.containsKey(followeeId)) followeeStore.get(followeeId).remove(followerId);
        removeUnfollowIdNewsFeed(followerId, followeeId);
    }

    private static class Tweet{
        private final Integer userId;
        private final Integer postId;
        private final Integer time;

        public Tweet(Integer userId, Integer postId) {
            this.userId = userId;
            this.postId = postId;
            this.time = timeStamp++;
        }
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */