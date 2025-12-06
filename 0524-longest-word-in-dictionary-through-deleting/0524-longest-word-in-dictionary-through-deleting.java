class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int mainPointer = 0;
        int [] pointer = new int[dictionary.size()];
        int [] length = new int[dictionary.size()];

        while (mainPointer < s.length()){
            for (int i = 0; i < dictionary.size(); i++) {
                char ch = s.charAt(mainPointer);
                if(pointer[i] < dictionary.get(i).length()  && ch == dictionary.get(i).charAt(pointer[i])){
                    length[i] = length[i] + 1;
                    pointer[i] = pointer[i]+1;
                }

            }
            mainPointer++;
        }
        int maxLength = 0;
        
        String maxString ="";
        for (int i = 0; i < length.length ; i++) {
            if (length[i] >= maxString.length() && length[i] == dictionary.get(i).length()){
                if(length[i] == maxString.length()){
                    if(dictionary.get(i).compareTo(maxString) < 0){
                        maxString = dictionary.get(i);
                    }

                }else {
                    maxString = dictionary.get(i);
                }

            }
        }
        return maxString;
    }
}