class Solution {
    public int maximumLength(String input) {
        Map<String, Integer> map = new HashMap<>();
        int start =0;
        int end = 0;
        while (end < input.length()){
            Character startCharacter = input.charAt(start);
            while(end < input.length() && input.charAt(end)== startCharacter){
                end++;
            }
            String substring = input.substring(start, end);
            if((end - start) > 1){
                // Generate Substring
                int size = end - start;
                int counter = size;
                for (int i = 1; i <= size; i++) {
                    Character ch = input.charAt(start);
                    String currentsubstring = String.valueOf(ch).repeat(i);
                    if(map.containsKey(currentsubstring)){
                        map.put(currentsubstring, map.get(currentsubstring)+counter);
                    }else{
                        map.put(currentsubstring, counter);
                    }
                    counter--;
                }

            }else{
                if(map.containsKey(substring)){
                    map.put(substring, map.get(substring)+1);
                }else{
                    map.put(substring, 1);
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