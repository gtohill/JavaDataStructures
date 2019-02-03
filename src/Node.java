public class Node {
	//variables
	private int element;
	private Node left;
	private Node right;
	
	
	//constructor
	public Node(int elem){
		element = elem;
	}
	
	//empty constructor
	public Node(){
		element = -1;
	}
	
	//getters 
	
	public int getElement(){
		return element;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	//setters
	
	public void setElement(int elem){
		element = elem; 
	}
	
	public void setLeft(Node l){
		left = l;
	}
	
	public void setRight(Node r){
		right =r;
	}
	
	public boolean isEmpty(){
		
		if(element == -1){
			return false;
		}
		return true;
		}
	}
