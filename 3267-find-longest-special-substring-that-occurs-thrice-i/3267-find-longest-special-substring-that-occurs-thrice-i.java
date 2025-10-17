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
                for(Map.Entry<String , Integer> entry : tempMap.entrySet()){
                    tempMap.put(entry.getKey(), entry.getValue() + 1);
                }
                tempMap.put(tempString, 1);
            }
            for(Map.Entry<String , Integer> entry : tempMap.entrySet()){
                if(map.containsKey(entry.getKey())){
                    map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());
                }else{
                    map.put(entry.getKey(), entry.getValue());
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