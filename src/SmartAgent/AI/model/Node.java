/**
 * 
 */
package SmartAgent.AI.model;

/**
 * @author HERVE NG
 *
 */
public class Node<T extends Comparable<T>> {
	
	private T element;
	
	private Node<T> next;
	
	/**
	 * @param element
	 */
	public Node(T element) {
		super();
		this.element = element;
	}
	
	/**
	 * @return the element
	 */
	public T getElement() {
		return element;
	}
	/**
	 * @param element the element to set
	 */
	public void setElement(T element) {
		this.element = element;
	}
	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
