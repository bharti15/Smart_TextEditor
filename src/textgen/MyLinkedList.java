package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		head = null;
		tail = null;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("null values can't be added to the list");
		}
		else if(this.head == null || this.tail == null || this.size == 0) {
			LLNode<E> n = new LLNode<E>(element);
//			n.next = this.head.next;
//			n.prev = this.head;
			this.head = n;
			this.tail = n;
			this.size++;
		}
		else {
			LLNode n = new LLNode(element);
			this.tail.next = n;
			n.prev = this.tail;
			this.tail = n;
			this.size++;
		}
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		if(index < 0 || index>=this.size) {
			throw new IndexOutOfBoundsException("index is either less than 0 or exceeding the size");
		}
		LLNode<E> temp = this.head;
		for (int i=0; i<index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("null values can't be added to the list");
		}
		else if(index < 0 || index>this.size) {
			throw new IndexOutOfBoundsException("index is either less than 0 or exceeding the size");
		}
		LLNode<E> n = new LLNode<E>(element);
		if(this.size == 0) {
			this.head = n;
			this.tail = n;
		}
		else if(index==this.size){
			n.prev = this.tail;
			this.tail.next = n;
			this.tail = n;
		}
		else if(index == 0) {
			n.next = this.head;
			this.head.prev = n;
			this.head = n;		
		}
		else {
			LLNode<E> temp = head;
			for(int i = 0; i< index; i++) {
				temp = temp.next;
			}
			n.next = temp;
			n.prev = temp.prev;
			n.prev.next = n;
			n.next.prev = n;
		}
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		E data;
		LLNode<E> temp = this.head;
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("index out of bound");
		}
		else if(this.size == 1 && index == 0) {
			data = this.head.data;
			this.head = null;
			this.tail = this.head;
		}
		else if(index == this.size-1) {
			data = this.tail.data;
			this.tail = this.tail.prev;
			this.tail.next.prev = null;
			this.tail.next = null;
		}
		else if(index == 0) {
			data = this.head.data;
			this.head = this.head.next;
			this.head.prev.next = null;
			this.head.prev = null;
		}
		else {
			for(int i=0; i<index; i++) {
				temp = temp.next;
			}
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			data = temp.data;
		}
		this.size--;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element==null) {
			throw new NullPointerException("null values can't be added");
		}
		if(index>=this.size || index<0) {
			throw new IndexOutOfBoundsException("index out of bound");
		}
		LLNode<E> temp = this.head;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		E data = temp.data;
		temp.data = element;
		return data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
