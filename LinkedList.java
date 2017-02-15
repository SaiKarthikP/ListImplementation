package cs240_hwk3;

public class LinkedList<T> implements ListInterface<T> {

	private Node firstNode;
	private int numOfEntries;
	
	public void LinkedList(){
		firstNode = null;
		numOfEntries = 0;
	}
	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		if (isEmpty()){
			firstNode = newNode;
		}
		else{
			Node lastNode = getNodeAt(numOfEntries);
			lastNode.setNode(newNode);
		}
		numOfEntries++;
		return true;
	}
	public Node getNodeAt(int position){
		Node currentNode = firstNode;
		for(int i = 1; i < position; i++)
			currentNode = currentNode.getNextNode();
		return currentNode;
		
	}
	@Override
	public boolean add(int newPosition, T newEntry) {
		boolean success = false;

		if ((newPosition >= 1) && (newPosition <= numOfEntries + 1)){
			Node newNode = new Node(newEntry);
			if (newPosition == 1){
				newNode.setNode(firstNode);
				firstNode = newNode;
			}
			else{
				Node nodeBefore = getNodeAt(newPosition -1);
				Node nodeAfter = nodeBefore.getNextNode();
				newNode.setNode(nodeAfter);
				nodeBefore.setNode(newNode);
			}
			numOfEntries++;
			success = true;
		}
		else 
			throw new IndexOutOfBoundsException("Illegal position given to add operation.");
		
		
		return success;
	}

	@Override
	public T remove(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numOfEntries)){
			assert !isEmpty();
			if (givenPosition == 1){
				result = (T) firstNode.getData();
				firstNode = firstNode.getNextNode();
			}
			else{
				Node nodeBefore = getNodeAt(givenPosition -1);
				Node nodeToRemove = nodeBefore.getNextNode();
				result = (T) nodeToRemove.getData();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNode(nodeAfter);
			}
			numOfEntries++;
			return result;
		}
		else 
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		
	}

	@Override
	public boolean removeAll() {
		firstNode = null;
		numOfEntries = 0;
		return true;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numOfEntries)){
			assert !isEmpty();
			Node desiredNode = getNodeAt(givenPosition);
			T originalEntry = (T) desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
			
		}
		else 
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
		
	}

	@Override
	public int look(T givenEntry) {
		int position = 1;
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null)){
			if(givenEntry.equals(currentNode.getData()))
				found = true;
			else{
				position++;
				currentNode = currentNode.getNextNode();
			}
		}
			return position;
	}

	@Override
	public T look(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numOfEntries)){
			assert !isEmpty();
			return (T) getNodeAt(givenPosition).getData();
			
		}
		else 
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numOfEntries];
		int i = 0;
		Node currentNode = firstNode;
		while ((i < numOfEntries) && (currentNode != null)){
			result[i] = (T) currentNode.getData();
			currentNode = currentNode.getNextNode();
			i++;
		}
		return result;
	}

	@Override
	public int getLength() {
		return numOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if (numOfEntries == 0){
			assert firstNode == null;
			result = true;
		}
		else{
			assert firstNode != null;
			result = false;
		}
		return result;
	}
	
}
