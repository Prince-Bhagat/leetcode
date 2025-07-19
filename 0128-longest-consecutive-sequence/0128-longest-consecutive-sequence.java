class Solution {
    


public class LongestConsecutiveSequence {
    Map<Integer, Integer> map = new HashMap<>();
    public LongestConsecutiveSequence(int[] num) {
        this.num = num;
        this.dum = new int[this.num.length];
        for (int i = 0; i < this.dum.length; i++) {
            dum[i] = i;
            map.put(num[i], i);
        }
        this.rum = new int[num.length];
    }

    int [] num;
    int [] dum;
    int [] rum;

    void union(int i , int j){
        int sourceI = find(i,i);
        int sourceJ = find(j,j);
        if(sourceI != sourceJ) {
            if(this.rum[sourceI] < this.rum[sourceJ]){
                dum[sourceI] = sourceJ;
            }else if(this.rum[sourceJ] < this.rum[sourceI]){
                dum[sourceJ] = sourceI;
            }else {
                dum[sourceJ] = sourceI;
                rum[sourceI]++;
            }

        }

    }

    private int find(int index,int original) {
        if(dum[index] == index) {
            dum[original] = index;
            return index;
        }
        return find(dum[index], original);
    }

    public int solve(){
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if(num[i] - num[j] == 1 || num[j] - num[i] == 1 || num[j] - num[i] == 0){
                    union(i, j);
                }
            }
        }
        return calculateLongestSequenceFromDSU();
    }
    public int solve2(){
        for(Map.Entry<Integer, Integer> entry: this.map.entrySet()){
            int value = entry.getKey();
            int nextValue = value+ 1;
            if(map.containsKey(nextValue)){
                union(entry.getValue(),map.get(nextValue));
            }
        }
        return calculateLongestSequenceFromDSU();
    }

    private int calculateLongestSequenceFromDSU() {
        Map<Integer, Set> map = new HashMap<>();
        for (int i = 0; i < this.dum.length; i++) {
            int source = find(i,i);
            if(map.containsKey(source)){
                map.get(source).add(num[i]);
            }else{
                map.put(source,new HashSet<Integer>(List.of(num[i])));
            }
        }
        int max = 0;
        for(Map.Entry<Integer, Set> entry: map.entrySet()){
            if(entry.getValue().size() > max) max = entry.getValue().size();
        }
        return max;
    }


}



    public int longestConsecutive(int[] nums) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence(nums);
        int result = longestConsecutiveSequence.solve2();
        return result;
    }
}