class Solution {
    public int lengthOfLongestSubstring(String input) {
        if(input.isEmpty() || input.length() == 1) return input.length();
        int start = 0;
        int end = start+ 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(input.charAt(start), start);
        int longestSubstringLength = 0;

        while(end < input.length() ){
            while(end < input.length() && !map.containsKey(input.charAt(end))){
                map.put(input.charAt(end), end);
                end++;
            }
            int currentSubstring = end - start;
            if(currentSubstring > longestSubstringLength){
                longestSubstringLength = currentSubstring;
            }
            if(end >= input.length()) continue;

            int newStart = map.get(input.charAt(end))+1;
            for(int i = start; i < newStart && i< input.length(); i++){
                map.remove(input.charAt(i));
            }
            start = newStart;


        }
        return longestSubstringLength;
    }
}