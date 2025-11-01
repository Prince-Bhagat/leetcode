class Solution {
    public int minDistance(String word1, String word2) {
        int [][] table = new int[word1.length()+1][word2.length()+1];

        for (int column = 0; column <= word2.length(); column++) {
            table[0][column] = column;
        }
        for (int row = 0; row <= word1.length(); row++) {
            table[row][0] = row;
        }

        for (int row = 1; row <= word1.length(); row++) {
            for (int column = 1; column <= word2.length(); column++) {
                char ch1 = word1.charAt(row -1);
                char ch2 = word2.charAt(column -1);
                if( ch1 == ch2 ){
                   table[row][column] = table[row-1][column-1];
                }else{
                    table[row][column] = 1 + Math.min(table[row][column-1], table[row-1][column]);
                }


            }
        }
        return table[word1.length()][word2.length()];

    }
}