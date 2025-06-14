class Solution {
    int computeHash(int start, int end, String text){
        int num = 0;
        for (int i = start; i <= end; i++) {
            num += text.charAt(i);
        }
        return num;
    }
    public int strStr(String text, String pattern) {
        int patternHash = computeHash(0, pattern.length() -1, pattern);
        for (int i = 0; i < text.length()  &&  (text.length() >= pattern.length() + i); i++) {
            int currentHash = computeHash(i, i+ pattern.length()-1, text);
            if(currentHash == patternHash){
                boolean isFound = false;
                for (int j = 0; j < pattern.length(); j++) {
                    if(pattern.charAt(j) != text.charAt(i + j)){
                        isFound = false;
                        break;
                    }
                    isFound = true;
                }
                if(isFound) return i;

            }
        }
        return -1;
    }
}