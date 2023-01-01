
	import java.io.*;
	import java.util.*;               
	////////////////////////////////////////////////////////////////
	//Everything needed, such as class node and class Tree, are already defined in AlgorithmTwoRecursive class.
	//Since they are under the same project, I have to comment the class about Node and Tree.
	//Please feel free to uncomment them if there is any problem compiling.
	
	
	
	public class AlgorithmOne{
		   
		
		
		   public static void main(String[] args) {
			   
			   //This is a BST
			   
			   Tree tree = new Tree();
		        tree.root = new Node(11);
		        tree.root.leftChild = new Node(7);
		        tree.root.rightChild = new Node(13);
		        tree.root.leftChild.leftChild = new Node(5);
		        tree.root.leftChild.rightChild =new Node(9);
		        tree.root.rightChild.leftChild = new Node(12);
		        tree.root.rightChild.rightChild =new Node(1000);
		        
		        System.out.println(); 
		       
		        System.out.println("Tree1:");
		        tree.isBST(tree.root);//isBST, works, because it returns one
		        
		       tree.isBSTTraverse(tree.root);
		       
		       
		       System.out.println(); 
		       System.out.println(); 
		       
		       
		       System.out.println("Tree2:");
		      //This is not a BST 
		       Tree tree2 = new Tree();
		        tree2.root = new Node(11);
		        tree2.root.leftChild = new Node(100);
		        tree2.root.rightChild = new Node(5);
		       
		        tree.isBST(tree2.root);
		        
			       tree.isBSTTraverse(tree2.root);
			   
		   }

	}//end of class
	
	
	