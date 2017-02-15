package cs240_hwk3;

import java.util.Vector;

public class VectorList<T> implements ListInterface<T> {
	private Vector list;
	
	
	public VectorList() {
		list = new Vector<>();
		
	}

	@Override
	public boolean add(T newEntry) {
		if(list.isEmpty())
			list.add(newEntry);
		else
			list.addElement(newEntry);
		return true;
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		boolean success = false;
		if ((newPosition >= 1) && (newPosition <= list.size())){
			if(list.isEmpty())
				list.add(newEntry);
			else
				list.add(newPosition, list);
			success = true;
		}
		else 
			throw new IndexOutOfBoundsException("Illegal position");
		
		return success;
	}

	@Override
	public T remove(int givenPosition) {
		if (list.isEmpty())
			return null;
		else{
			T removeElement = (T) list.get(givenPosition);
			list.removeElementAt(givenPosition);
			return removeElement;
		}
	}

	@Override
	public boolean removeAll() {
		list.removeAllElements();
		return true;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if (list.isEmpty())
			return null;
		else
			return (T) list.set(givenPosition, newEntry);
	}

	@Override
	public int look(T givenEntry) {
		return list.indexOf(givenEntry);
	}

	@Override
	public T look(int givenPosition) {
		if (list.isEmpty())
			return null;
		else 
			return (T) list.get(givenPosition);
	}

	@Override
	public T[] toArray() {
		if (list.isEmpty())
			return null;
		else{
			Object[] arr = new Object[list.size()];
			return (T[]) list.toArray((T[]) arr);
		}
	}

	@Override
	public int getLength() {
		if (list.isEmpty())
			return 0;
		else 
			return list.size();
		
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
