/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
     public  String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node != null){
                appendNumber(stringBuilder, String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }else{
                appendNumber(stringBuilder, "*");
            }

        }
        String str = stringBuilder.toString();
        str = formateStr(str);
        return str;
    }

    private  void appendNumber(StringBuilder stringBuilder, String element) {
        if(!stringBuilder.toString().isEmpty()){
            stringBuilder.append(",");
        }
        stringBuilder.append(element);

    }

     class Counter {
        public void inCrement(){
            this.value++;
        }
        public void deCrement(){
            this.value--;
        }
        public int getValue(){
            return this.value;
        }

        public Counter(int value) {
            this.value = value;
        }

        int value = 0;
    }
    private  String formateStr(String str) {

        Counter counter = new Counter(str.length() -1);
        String result ;
        if(counter.getValue() <= 0){
            return "";
        }

        while (str.charAt(counter.getValue()) == '*' || str.charAt(counter.getValue()) == ','){
            counter.deCrement();
        }
        return str.substring(0,counter.getValue()+1);
    }
    public  TreeNode deserialize(String data){
        List<Integer> array = decodeString(data);
        return addNodeForTree(array);
    }

    private  TreeNode addNodeForTree(List<Integer> values){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        int count = 0;

        try {
            while (count < values.size()){

                if(root == null){
                    int element = getValue(values, count);
                    root = new TreeNode(element);
                    count++;
                    queue.add(root);
                    continue;
                }
                TreeNode node = queue.remove();

                Integer leftValue = getValue(values, count);
                TreeNode left = (leftValue != null)?new TreeNode(leftValue):null;
                node.left = left;
                if(left != null){
                    queue.add(left);
                }

                count++;
                Integer rightValue = getValue(values, count);
                TreeNode right = (rightValue != null)?new TreeNode(rightValue):null;


                node.right = right;

                if(right != null){
                    queue.add(right);
                }
                count++;
            }
        } catch (Exception e) {
            //
        }
        return root;
    }

    private  List<Integer> decodeString(String data) {
        int counter = 0;
        int size = data.length();
        List<Integer> result = new ArrayList<>();


        while (counter< size){
            char ch = data.charAt(counter);
            switch (ch){
                case ',':{
                    counter++;
                    break;
                }
                case '*':{
                    result.add(null);
                    counter++;
                    break;
                }
                case '-':{
                    StringBuilder stringBuilder = new StringBuilder();
                     counter++;
                    while(counter < size && data.charAt(counter) != ',' ){
                        stringBuilder.append(data.charAt(counter));
                        counter++;
                    }
                    Integer number = Integer.parseInt(stringBuilder.toString());
                    result.add(-1 *number);
                    break;
                }
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    while( counter < size && data.charAt(counter) != ','){
                        stringBuilder.append(data.charAt(counter));
                        counter++;
                    }
                    Integer number = Integer.parseInt(stringBuilder.toString());
                    result.add(number);
            }
        }
        return result;
    }

    private  Integer getValue(List<Integer> values, int count) throws Exception {
        if(count >= values.size()){
            throw new Exception("Counter Out of size");
        }
        return values.get(count);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));