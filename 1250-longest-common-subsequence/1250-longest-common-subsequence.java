class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] table = new int[text1.length() + 1][text2.length() +1];
        int row =1, column =1;

        while(row < table.length){
            column =1;
            while (column < table[0].length){
                if(text1.charAt(row-1) == text2.charAt(column-1)){
                    table[row][column] = 1  + table[row-1][column-1];

                }else{
                    table[row][column] = Math.max(table[row-1][column], table[row][column-1]);

                }
                column++;
            }
            row++;

        }
        return table[row-1][column-1];
    }
}