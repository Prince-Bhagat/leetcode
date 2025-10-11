class Solution {
    public int lengthOfLongestSubstring(String input) {
         if(input.isEmpty() || input.length() == 1) return input.length();
        int start = 0;
        int end = start+ 1;
        Map<Character, Boolean> map = new HashMap<>();
        map.put(input.charAt(start), true);
        String substring = "";

        while(end < input.length() ){
            while(end < input.length() && !map.containsKey(input.charAt(end))){
                map.put(input.charAt(end), true);
                end++;
            }
            String currentSubstring = input.substring(start, end);
            if(currentSubstring.length() > substring.length()){
                substring = currentSubstring;
            }
            map = new HashMap<>();
            start++;
            end= start+ 1;
            map.put(input.charAt(start), true);
        }
        return substring.length();
    }
}