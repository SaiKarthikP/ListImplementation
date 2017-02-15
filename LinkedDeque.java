
public class LinkedDeque<T> implements DequeInterface<T> {
	private DLNode firstNode;
	private DLNode lastNode;
	
	public LinkedDeque(){
		firstNode = null;
		lastNode = null;
	}
	
	@Override
	public void addToFront(T newEntry) {
		@SuppressWarnings("unchecked")
		DLNode newNode = new DLNode(null, newEntry, firstNode);
		if (isEmpty())
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		firstNode = newNode;
	}

	@Override
	public void addToBack(T newEntry) {
		@SuppressWarnings("unchecked")
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
	}

	@Override
	public T removeFront() {
		T front = getFront();
		firstNode = firstNode.getNextNode();
		if (firstNode == null)
			lastNode = null;
		else 
			firstNode.setPreviousNode(null);
		return front;
	}

	@Override
	public T removeBack() {
		T back = getBack();
		lastNode = lastNode.getPreviousNode();
		if (lastNode == null)
			firstNode = null;
		else 
			lastNode.setNextNode(null);
		return back;
	}

	@Override
	public T getFront() {
		if(!isEmpty())
			return (T) firstNode.getData();
		
		return null;
	}

	@Override
	public T getBack() {
		if(!isEmpty())
			return (T) lastNode.getData();
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		while(!isEmpty())
			removeFront();
		
	}
	
}
