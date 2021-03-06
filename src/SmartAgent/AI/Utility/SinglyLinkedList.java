/**
 * 
 */
package SmartAgent.AI.Utility;

import java.util.Iterator;

import SmartAgent.AI.UI.IList;
import SmartAgent.AI.model.Node;



/**
 * @author HERVE NG
 *
 * @param <T>
 */
public class SinglyLinkedList<T extends Comparable<T>> implements IList<T>, Iterable<T> {

	private Node<T> root;
	private int sizeOfList;
	

	/**
	 * @return the root
	 */
	public Node<T> getRoot() {
		return root;
	}

	@Override
	public int size() {
		return this.sizeOfList;
	}

	@Override
	public void insert(T data) {
		if(root == null) {
			this.root = new Node<T>(data);
		}else {
			insertDataAtBeginning(data);
		}
		++this.sizeOfList;		
	}

	/**
	 *  Insert data at the beginning of the list.
	 * @param data. data to insert in the list.
	 */
	private void insertDataAtBeginning(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNext(root);
		this.root = newNode;		
	}
	
	
	/**
	 * Insert data at the end of the list.
	 * @param data. Data to insert in the list.
	 * @param node. last node of the list.
	 */
	@SuppressWarnings("unused")
	private void insertDataAtEnd(T data, Node<T> node) {
		if(node.getNext() != null) { //Check if there is a next node in the list.
			insertDataAtEnd(data, node.getNext()); //recursive call of the function.
		}else { //We have reached the end of the list.
			Node<T> newNode = new Node<>(data); //Instantiate a new node.
			node.setNext(newNode); 
		}
	}

	/**
	 * Remove a node from the list.
	 * @param data. data to remove from the list.
	 */
	@Override
	public void remove(T data) {
		if(this.root == null) return;
		if(this.root.getElement().compareTo(data) == 0) {
			this.root = this.root.getNext();
		}else {
			removeBetween(data, root, root.getNext());
		}
		
		--this.sizeOfList;
	}
	
	/**
	 * Remove a node between two nodes.
	 * @param dataToRemove
	 * @param previousNode
	 * @param currentNode
	 */
	private void removeBetween(T dataToRemove, Node<T> previousNode, Node<T> currentNode) {

		while(currentNode != null) {
			if(currentNode.getElement().compareTo(dataToRemove) == 0) {
				previousNode.setNext(currentNode.getNext());
				currentNode = null;
				return;			
			}
			
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		
	}

	
	@Override
	public void traverseList() {
		if(this.root == null) return;
		Node<T> currentNode = root;
		while(currentNode != null) {
			System.out.println(currentNode.getElement().toString());
			currentNode = currentNode.getNext();
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(root);
	}

}
