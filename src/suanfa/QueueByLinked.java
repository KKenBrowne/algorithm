package suanfa;


import java.util.Iterator;


public class QueueByLinked<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	
	public void enqueue(Item item){
		//���β���Ԫ��
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}
		oldlast.next = last;
		N++;
	}
	public Item dequeue(){
		//�ӱ�ͷɾ��Ԫ��
		Item item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		N--;
		return item;
	}
	//iterator
	@Override
	public Iterator<Item> iterator() {
		
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		
		public boolean hasNext(){
			return current != null;
		}
		public void remove(){}
		
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
