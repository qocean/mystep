package newcoder.SwordToOffer;


public class Question61 {
    String Serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serializeby(root ,sb);
        int length = sb.length();
        return sb.toString().substring(0 , length-1);
    }

    void serializeby(TreeNode node , StringBuilder sb){
        if(node == null){
            sb.append("$,");
            return;
        }
        sb.append(node.val + ",");
        serializeby(node.left , sb);
        serializeby(node.right , sb);
    }
    TreeNode root = null;
    TreeNode Deserialize(String str) {
        String[] strs = str.split(",");
        root = deserializeBy(strs , root);
        return root;
    }

    int position = 0;
    TreeNode deserializeBy(String[] strs , TreeNode node){
        if(strs[position].equals("$")){
            position++;
            return null;
        }
        node = new TreeNode(Integer.parseInt(strs[position]));
        position++;
        node.left = deserializeBy(strs  , node.left);
        node.right = deserializeBy(strs , node.right);
        return node;
    }

    public static void main(String[] args){
        Question61 test = new Question61();
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;     node1.right = node3;
        node2.left = node4;     node2.right = node5;
        node3.left = node6;     node3.right = node7;

        String s = test.Serialize(node1);
        System.out.println(s);
        TreeNode root = test.Deserialize(s);
        System.out.println(test.Serialize(root));
    }
}
