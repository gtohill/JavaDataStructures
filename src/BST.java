import java.util.LinkedList;
import java.util.Queue;


public class BST {
	
	//variables
	private Node root= null;
	
	//constructor1
	public BST(Node rt){
		root = rt;
	}
	public BST(){
		root = null;
	}
	
	
	//getters
	public Node getRoot(){
		return root;
	}
	
	//setters
	public void setRoot(Node rt){
		root = rt;
	}
	
	
	//insert
	public void insert(Node rt, int value){
		if(rt == null){
			Node n = new Node(value);
			this.setRoot(n);
			
		}else{

			if(rt.getElement() > value){

				if(rt.getLeft() != null){
					insert(rt.getLeft(), value);

				}else{
					Node n = new Node(value);
					rt.setLeft(n);
				}
				
			}else{
				
				if(rt.getRight() != null){
					insert(rt.getRight(), value);
					
				}else{
					Node n = new Node(value);
					rt.setRight(n);
				}				
			}
		}
	}
	
	
	//find
	public boolean find(Node rt, int value){
		boolean flag = false;
		Queue<Node> q = new LinkedList<Node>();
		q.add(rt);
		
		if(rt.getElement() == value){
			flag = true;
			
		}else{
			while(!q.isEmpty()){
				Node n = q.remove();
				if(n.getElement() == value){
					flag = true;
				}
				if(n.getLeft() != null){
					q.add(n.getLeft());
					
				}
				if(n.getRight() != null){
					q.add(n.getRight());
				}
				
			}			
		}
		return flag;
	}
	
	// inorder traversal
	public void inorder(Node root){
		
		if(root == null){
			return;			
		}
	
		inorder(root.getLeft());
		System.out.print(root.getElement());
		inorder(root.getRight());
	}
	
	// pre order 
	public void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.getElement());
		preorder(root.getLeft());
		preorder(root.getRight());
	}
	
	// post order
	public void postorder(Node root) {
		if(root == null) {
			return;
		}
		
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(root.getElement());
	}
	
	
	/* test harness */
	public static void main(String[] args){
		Node rt = new Node(4);
		BST tree = new BST();
		
		int[] nums = {5,7,3,1,2,6};
		
		for(int value:nums){
			tree.insert(tree.getRoot(), value);			
		}
		
		Node n = tree.getRoot();
		//tree.insert(n, 10);
		tree.inorder(n);
		System.out.println("");
		tree.preorder(n);
		System.out.println("");
		tree.postorder(n);
		
	}
}
