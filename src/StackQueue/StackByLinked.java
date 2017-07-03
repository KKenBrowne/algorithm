package StackQueue;


import java.util.Iterator;

import com.sun.corba.se.impl.orbutil.graph.Node;


//链表实现下压栈
public class StackByLinked<Item> implements Iterable<Item>{
	private Node first;
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
	//向栈顶添加一个元素
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.next = oldFirst;
		first.item = item;
		N++;
	}
	public Item peek(){
		Item item = first.item;
		return item;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	//iterator
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
