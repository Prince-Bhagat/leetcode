class Solution {
    public int numDistinct(String s, String t) {
     int table[][] = new int[s.length() +1][t.length() +1];
        //Init
        for (int i = 0; i < s.length(); i++) {
            table[i][0] = 1;
        }
        for (int i = 1; i <= t.length() ; i++) {
            for (int j = i; j <= s.length(); j++) {
                if(s.charAt(j -1) == t.charAt(i -1)){
                    table[j][i] = table[j-1][i-1] + table[j-1][i];
                }else {
                    table[j][i] = table[j-1][i];
                }

            }
        }
        return table[s.length()][t.length()];
   
    }
}