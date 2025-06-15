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
        int currentHash =0;
        for (int i = 0; i < text.length() && (text.length() >= pattern.length() + i); i++) {
            if(currentHash == 0){
                for (int j = 0; j < pattern.length(); j++) {
                    currentHash += text.charAt(j+i);
                }
            }else{
                currentHash = currentHash - text.charAt(i-1) + text.charAt(i+ pattern.length()-1);

            }

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