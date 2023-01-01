
//The recursive version is in the below, called isBST Test.
//Please scroll down to see it
//You can see it's a function made by multiple recursive methods.

//The in-order traversal is another method to test BST.
//It's called isBSTTraverse.

	import java.io.*;
	import java.util.*;               // for Stack class if needed
	
	 
	    
	class Node {
		   public Node(int i) {
			   iData = i;
			// TODO Auto-generated constructor stub
		}
		public int iData; // data item (key)
		   //public double dData;           // data item
		   public Node leftChild;         // this node's left child
		   public Node rightChild;        // this node's right child

		   } 
	
	

 class Tree {

	
	   
	   public Node root;             // first node of tree
	   public Node rootgetter() {
		   return root;
	   }
	// -------------------------------------------------------------
	   public Tree()                  // constructor
	      { root = null; }            // no nodes in tree yet
	// -------------------------------------------------------------
	   public Node find(int key)      // find node with given key
	      {  Node cur = root;
	      
	      // (assumes non-empty tree)
	      	while (cur.iData!= key) {
	      		if(key<cur.iData) {
	      			cur=cur.leftChild;
	      		}//end of if
	      		else {
	      			cur= cur.rightChild;
	      			
	      		}//end of else
	      		
	      		if(cur==null) {
	      			return null;
	      		}
	      		
	      		
	      	}//end of while
	      	
	      	return cur;
	      
	      
	      


	                  // found it
	      }  // end find()
	// -------------------------------------------------------------
	    void insert(int id, double dd) //this method inserts a node of (id and dd) into the tree. (We are consider a BINARY SEARCH TREE by iData)
	      {
		   Node myNode = new Node(id);
		   myNode.iData = id;
		   //myNode.dData = dd;
		   
		   if (root == null) {
			   root = myNode;
		   }//end of if
		   
		   else {
			   Node cur = root;
			   Node temp;
			   
			   while(true) {
				   temp = cur;
				   if(id<cur.iData) {
					   cur = cur.leftChild;
					   if(cur == null) {
						   temp.leftChild = myNode;
						   return;
					   }
					   
				   }//end of if
				   
				   else {
					   cur = cur.rightChild;
					   if (cur == null) {
						   temp.rightChild = myNode;
						   return;
					   }
				   }
				   
				   
			   }//end of while true
				   
			   
		   }//end of else
	         





	      }  // end insert()
	//////////////////////////////////////////////////////

	   public void traverse(int traverseType) //this method is full implemented see below 
	      {
	       switch(traverseType)
	         {
	         case 1: System.out.print("\nPreorder traversal: ");
	                 preOrder(root);
	                 break;
	         case 2: System.out.print("\nInorder traversal:  ");
	                 inOrder(root);
	                 break;
	         case 3: System.out.print("\nPostorder traversal: ");
	                 postOrder(root);
	                 break;
	         }
	      System.out.println();
	      }
	// -------------------------------------------------------------
	   private void preOrder(Node localRoot) //implement preOrder traversal
	      {
		   if(localRoot != null){
	       
			   
	       System.out.print(localRoot.iData+" ");
	       //System.out.println();
	       
	       preOrder(localRoot.leftChild);
	       preOrder(localRoot.rightChild);
	       }
	     

	      }
	// -------------------------------------------------------------
	   private void inOrder(Node localRoot) //implement in Order traversal
	      {
		   if(localRoot != null){
	       
	       inOrder(localRoot.leftChild);
	       System.out.print(localRoot.iData+" ");
	       //System.out.println();
	       inOrder(localRoot.rightChild);
	       }
	     


	      }
	// -------------------------------------------------------------
	   private void postOrder(Node localRoot) //implement postOrder traversal
	      {
		   if(localRoot != null){
	       
	       postOrder(localRoot.leftChild);
	       postOrder(localRoot.rightChild);
	       
	       System.out.print(localRoot.iData+" ");
	       //System.out.println();
	       }
	  
	      }

///////////////////////////////////////////////////////////////  ///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	   //This is the recursive method
	   
	    public void isBST(Node localRoot) //this method will take a tree as an input and will PRINT to the screen if the tree is a BST or NOT.
	    {
	    	//I am going to use three help methods for this program
	    	int result = isBSTtest(localRoot);
	    	
	    	if (result == 1) {
	    		System.out.println("It's a BST");
	    	}
	    	
	    	else {
	    		System.out.println("It's not a BST");
	    	}
	    }//end of the method 
	    
	    public int isBSTtest(Node localRoot) {
	    	//1 means is BST
	    	//0 means not a bst
	    	
	    	if (localRoot == null) {
	    		return 1;
	    	}
	    	
	    	
	        if (localRoot.leftChild != null
	            && MaxValue(localRoot.leftChild) > localRoot.iData) {
	          return 0;
	        }
	         
	        
	        if (localRoot.rightChild != null
	            && MinValue(localRoot.rightChild) < localRoot.iData) {
	          return 0;
	        }
	         
	        
	        if (isBSTtest(localRoot.leftChild) != 1
	            || isBSTtest(localRoot.rightChild) != 1) {
	          return 0;
	        }
	        
	        //eventually
	        
	        return 1;
	    	
	    }
	    
	    public int MaxValue(Node localRoot) {
	    	
	    
	    	if (localRoot == null) {
	    	      return Integer.MIN_VALUE;
	    	    }
	    	    int value = localRoot.iData;
	    	    int leftMax = MaxValue(localRoot.leftChild);
	    	    int rightMax = MaxValue(localRoot.rightChild);
	    	 
	    	    return Math.max(value, Math.max(leftMax, rightMax));
	    }
	    
	    public int MinValue(Node localRoot) {
	    	if (localRoot == null) {
	    	      return Integer.MAX_VALUE;
	    	    }
	    	    int value = localRoot.iData;
	    	    int leftMax = MinValue(localRoot.leftChild);
	    	    int rightMax = MinValue(localRoot.rightChild);
	    	 
	    	    return Math.min(value, Math.min(leftMax, rightMax));
	    }
	    
	    
	    
	    
	    //This is the in-order method
	  //This is the in-order-traversal-way-of-detecting-BST that we cover in class and in recitation.
		//If we use an arraylist to store all the nodes in a binary tree with in-order-insertion
		//And if our arraylist is sorted
		//That basically means the tree is BST
	    
	    
public  ArrayList<Node> Inorderinsertion(Node localRoot, ArrayList<Node> myList) {
			if(localRoot!= null) {
			Inorderinsertion(localRoot.leftChild, myList);
			myList.add(localRoot);
			Inorderinsertion(localRoot.rightChild, myList);
			
		}
			
			return myList;
			}
		
		//That's basically how we do the in-order traverse of BST
		/*
		 private void inOrder(Node localRoot) //implement in Order traversal
	      {
		   if(localRoot != null){
	       
	       inOrder(localRoot.leftChild);
	       System.out.print(localRoot.iData+" ");
	       //System.out.println();
	       inOrder(localRoot.rightChild);
	       }
	  
	      }
	      */
		
		
		public void isBSTTraverse(Node localRoot) {
			
			ArrayList<Node> myList = new ArrayList<Node>();
			
			myList = Inorderinsertion(localRoot, myList);
			
			for(int i = 0; i<myList.size()-1; i++) {
				if(myList.get(i).iData>myList.get(i+1).iData) {
					System.out.println("This is not a BST");
					return;
				
			}
			
			
		}//end of for loop
			
	    
			System.out.println("This is a BST");
	
	    

	   }

 		
 
 
 
 
	
	     
public class AlgorithmTwoRecursive{
	  
	
	//The test is in the other program
	
	
	
	
	
	
}
 }
//end of class Tree
	
	

