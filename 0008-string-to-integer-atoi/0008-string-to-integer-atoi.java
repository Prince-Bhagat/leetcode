import java.math.BigInteger;
class Solution {
    public int myAtoi(String s) {
        int size = s.length();
        int counter = 0;
        while(counter < size){
            char ch = s.charAt(counter);
            switch(ch){
                case ' ':{
                    counter++;
                    break;
                }
                case '-':{

                    StringBuilder stringBuilder = new StringBuilder();
                    counter++;
                    while(counter < size){
                        char charDigit = s.charAt(counter);
                        if(!(charDigit >= '0' && charDigit <= '9')) {
                            try{
                               BigInteger bigInt = new BigInteger(stringBuilder.toString()).negate();
                                if(bigInt.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
                                    return Integer.MIN_VALUE;
                                }else{
                                    return bigInt.intValue();
                                }
                            } catch (Exception e) {
                                return 0;
                            }


                        }
                        stringBuilder.append(s.charAt(counter));
                        counter++;
                    }
                    try {
                        BigInteger bigInt = new BigInteger(stringBuilder.toString()).negate();
                        if(bigInt.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
                            return Integer.MIN_VALUE;
                        }else{
                            return bigInt.intValue();
                        }
                    } catch (Exception e) {
                        return 0;
                    }

                }
                case'+': counter++;
                default:{

                    StringBuilder stringBuilder = new StringBuilder();
                    while(counter < size){
                        char charDigit = s.charAt(counter);
                        if(!(charDigit >= '0' && charDigit <= '9')) {
                            try{
                                BigInteger bigInt = new BigInteger(stringBuilder.toString());
                                if(bigInt.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
                                    return Integer.MAX_VALUE;
                                }else{
                                    return bigInt.intValue();
                                }
                            }catch ( NumberFormatException e){
                                return 0;
                            }
                        }
                        stringBuilder.append(s.charAt(counter));
                        counter++;
                    }
                    try{
                        BigInteger bigInt = new BigInteger(stringBuilder.toString());
                        if(bigInt.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
                            return Integer.MAX_VALUE;
                        }else{
                            return bigInt.intValue();
                        }
                    } catch (Exception e) {
                        return 0;
                    }
                }

            }
        }
        return 0;
    }
}