class Solution {
    public int maximumLength(String input) {
        Map<String, Integer> map = new HashMap<>();
        int start =0;
        int end = 0;
        while (end < input.length()){
            Character startCharacter = input.charAt(start);
            Map<String, Integer> tempMap = new HashMap<>();
            while(end < input.length() && input.charAt(end)== startCharacter){
                end++;
                String tempString= input.substring(start, end);

                tempMap.put(tempString, 1);
            }
            for(Map.Entry<String , Integer> entry : tempMap.entrySet()){
                String str = entry.getKey();
                int tempSize = tempMap.size();
                if(map.containsKey(entry.getKey())){
                    map.put(entry.getKey(), map.get(entry.getKey()) + (tempSize - str.length() + 1));
                }else{
                    map.put(entry.getKey(),(tempSize - str.length() + 1));
                }

            }
            start = end;
        }

        String finalString = "";
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() >= 3 && entry.getKey().length() > finalString.length() ){
                finalString = entry.getKey();
            }
        }
        if(finalString.length() == 0){
            return  -1;
        }else{
            return finalString.length();
        }
    }
}