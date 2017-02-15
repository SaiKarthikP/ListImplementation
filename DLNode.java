
public class DLNode<T> {
	private T data;
	private DLNode next;
	private DLNode previous;
	
	public DLNode(T dataPortion){
		this(null, dataPortion, null);
	}

	public DLNode(DLNode previousNode, T data, DLNode nextNode){
		this.data = data;
		next = nextNode;
		previous = previousNode;
	}

	public T getData(){
		return data;
	}

	public void setData(T newData){
		data = newData;
	}
	
	public DLNode getNextNode(){
		return next;
	}

	public DLNode getPreviousNode(){
		return previous;
	}
	
	public void setNextNode(DLNode node){
		next = node;
	}
	
	 public void setPreviousNode(DLNode node){
		 previous = node;
	 }
}
