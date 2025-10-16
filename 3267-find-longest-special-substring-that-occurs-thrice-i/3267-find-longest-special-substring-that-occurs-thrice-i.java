class Solution {
    public int maximumLength(String input) {
        Map<String, Integer> map =  new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            int counter = i;
            while(counter < input.length() && ch == input.charAt(counter)){
                counter++;
                String substring = input.substring(i, counter);
                if(map.containsKey(substring)){
                    map.put(substring, map.get(substring) + 1);
                }else{
                    map.put(substring, 1);
                }

            }

        }

        int max = 3;
        String finalString ="";
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() >= max &&  entry.getKey().length() >  finalString.length()){
                finalString = entry.getKey();
            }
        }
        if(finalString.length() == 0){
            return -1;
        }else{
            return finalString.length();
        }
    }
}