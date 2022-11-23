class Solution {
    public String solution(String new_id) {
        return specialReplace(new_id.toLowerCase());
    }
    
     public String specialReplace(String new_id){
        StringBuilder sb = new StringBuilder();
        for (char ch : new_id.toCharArray()) {
            if(ch - '0' >= 0 && ch - '0' <= 9)
                sb.append(ch);
            if ((ch - 'a' >= 0 && ch - 'a' < 26) || ch == '-' || ch == '_' || ch == '.')
                sb.append(ch);
        }
        return dotReplace(sb.toString());
    }

    public String dotReplace(String new_id){
        for (int i = 0; i < new_id.length(); i++)
            new_id = new_id.replace("..", ".");
        return dotNotFirstAndLast(new_id);
    }

    public String dotNotFirstAndLast(String new_id){
        if (new_id.charAt(0) == '.')
            new_id = new_id.replaceFirst(".", "");
        if (!new_id.isEmpty() && new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.substring(0, new_id.length() - 1);
        return idIsEmpty(new_id);
    }

    public String idIsEmpty(String new_id){
        if (new_id.isEmpty())
            return dotNotLast("a");
        return idIsLengthRt15(new_id);
    }

    public String idIsLengthRt15(String new_id){
        if (new_id.length() >= 16)
            return dotNotLast(new_id.substring(0, 15));
        return dotNotLast(new_id);
    }

    public String dotNotLast(String new_id){
        if (new_id.charAt(new_id.length() - 1) == '.')
            return new_id.substring(0, new_id.length() - 1);
        return idIsLengthRtTwo(new_id);
    }

    public String idIsLengthRtTwo(String new_id){
        StringBuilder sb = new StringBuilder(new_id);
        if (new_id.length() <= 2){
            char lastCh = new_id.charAt(new_id.length() - 1);
            while (sb.length() != 3){
                sb.append(lastCh);
            }
        }
        return sb.toString();
    }
}