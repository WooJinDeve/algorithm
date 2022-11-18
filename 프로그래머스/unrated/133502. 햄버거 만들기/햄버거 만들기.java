import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] ingredient) {
    List<Integer> ingredients = Arrays.stream(ingredient)
                                    .boxed()
                                    .collect(Collectors.toList());
        int[] check = new int[]{1,2,3,1};
        int answer = 0;

        for (int i = 3; i < ingredients.size(); i++) {
              if (i >= 3 && ingredients.get(i) == check[3]){
                  int count = 0;
                  for (int j = 0; j < 4; j++) {
                      if (check[j]  == ingredients.get(i - 3 + j)){
                          count++;
                      }
                  }
                  if (count == 4){
                      answer++;
                      i -= 3;
                      for (int j = 0; j < 4; j++) {
                          ingredients.remove(i);
                      }
                  }
              }
        }
        return answer;
    }
}