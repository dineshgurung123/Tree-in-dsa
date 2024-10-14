import java.util.LinkedList;
import java.util.Queue;
import java.math.*;

public class BinaryTrees {


   static public class Node{

      int data;
      Node left, right;

      Node(int data){

        this.data = data;
        left=right=null;
      }

   }
 

   static class BinaryTree{

    static int idx = -1;

    public static Node treeBuilder(int nodes[]){
         
         idx++;

        if(nodes[idx] == -1)
           return null;

      

       Node newNode = new Node(nodes[idx]);
        newNode.left =  treeBuilder(nodes); 
        newNode.right = treeBuilder(nodes);
       return newNode;
         
    }
       
   }
      //preorder traversal 

    public static void preorder(Node root){
    
      if(root == null){
        return ;
      }
      System.out.print(root.data + " ");
      preorder(root.left);
      preorder(root.right);

    }

    public static void inorder(Node root){

      if(root == null){
        return ;
      }
        
     inorder(root.left);
      System.out.print(root.data + " ");
      inorder(root.right);

    }


    public static void postorder(Node root){

        if(root == null){
          return ;
        }
          
       postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
      }


      public static void levelOrder(Node root){
       
        if(root == null){
            return;
        }
       
     Queue <Node> q = new LinkedList<>();
     q.add(root);
  

     while (!q.isEmpty()) {
        
     int levelsize = q.size();


     for (int i = 0; i < levelsize; i++) {
        
        Node currNode = q.remove();
     

        System.out.println(currNode.data + " " );
        
   
        //Enqueue left child
   
        if (currNode.left !=null) {
           
           q.add(currNode.left);
        }
   
           if(currNode.right !=null){
               q.add(currNode.right);
           }
   
     }
   
 System.out.println();
     }
      }


      public static int countNodes(Node root){
           if (root == null) {
            return 0;
           }

           int leftNodes = countNodes(root.left);
           int rightNodes = countNodes(root.right);

           return leftNodes + rightNodes + 1;

      }



      public static int sumNodes(Node root){

           if (root == null) {
          return 0;
           }

           int leftsum = sumNodes(root.left);
           int rightsum = sumNodes(root.right);
  
          return leftsum + rightsum + root.data;
        
      }

      public static int nodeHeight(Node root){

       if(root == null){
        return 0;
       }

       int leftHeight = nodeHeight(root.left);
       int rightHeight = nodeHeight(root.right);

       return Math.max(leftHeight, rightHeight) + 1;

      }


    public static void main(String[] args) {
        
    
    int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

     BinaryTree tree = new BinaryTree();
       Node root  =  BinaryTree.treeBuilder(nodes);
      
    //    preorder(root);
    //    inorder(root);
    //   postorder(root);

    // levelOrder(root);

      int count= countNodes(root);
   System.out.println( "Count :" + count);


    int sum = sumNodes(root);

    System.out.println("sum :" + sum);

   int height = nodeHeight(root);
   System.out.println("height :"+ height);


    }
}