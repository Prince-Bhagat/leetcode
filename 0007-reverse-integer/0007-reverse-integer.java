class Solution {
     public Integer convertStringToInt(String str){
        boolean isNegative = str.charAt(0)== '-';
        try {
            Integer intValueOfString;
            if(isNegative){
                intValueOfString = Integer.parseInt(str);
            }else{
               intValueOfString = Integer.parseInt(str);
            }
            return intValueOfString;
        } catch (NumberFormatException e) {
            return 0;
        }

    }
    public int reverse(int value) {
        
         String str = String.valueOf(value);

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : str.toCharArray()){
            if(ch == '-'){
                continue;
            }
            stringBuilder.insert(0, ch);
        }
        String stringValue;
        if(str.charAt(0) == '-'){
            stringBuilder.insert(0,'-');
            stringValue = stringBuilder.toString();
        }else{
            stringValue = stringBuilder.toString();
        }
        return convertStringToInt(stringValue);
    }
}