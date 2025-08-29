package d_datastructure.bst;

public class Run {
    public static void main(String[] args) {
        Integer[] nums = {8,3,10,1,6,14,4,7,13};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (Integer i : nums){
            bst.insert(i);
        }
        System.out.println(bst.bfs());
        System.out.println("----------------------");
        bst.delete(7);
        System.out.println(bst.bfs());
        
        // System.out.println("----------------------");
        // System.out.println(bst.preOrderRecursive());
        
        System.out.println("----------------------");
        System.out.println(bst.postOrderRecursive());

        System.out.println("----------------------");
        System.out.println(bst.inOrderRecursive());
        
        System.out.println("----------------------");
        System.out.println(bst.preOrder());
    }
}
