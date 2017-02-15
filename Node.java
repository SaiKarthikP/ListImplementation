package cs240_hwk3;

	public class Node<T> {
		private T data;
		private Node next;
		
		public Node(T data) {
			this(data, null);
		}
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}

		public T getData(){
			return data;
		}
		public Node getNextNode(){
			return next;
			
		}
		public void setData(T data){
			this.data = data;
		}
		public void setNode(Node next){
			this.next = next;
		}
		
	}
