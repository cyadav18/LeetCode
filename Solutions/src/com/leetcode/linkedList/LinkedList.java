package com.leetcode.linkedList;

public class LinkedList<T> {
	private LinkedListNode<T> head;
	private LinkedListNode<T> last;
	private Integer size = 0;

	public Integer getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinkedListNode<T> temp = head;
		while (temp != null) {
			sb.append(temp + " ");
			temp = temp.getNext();
		}
		sb.append("\n");
		return sb.toString();
	}

	public void add(T data) {
		LinkedListNode<T> temp = new LinkedListNode<T>(data);
		if (head == null) {
			this.head = temp;
			this.last = temp;
		} else {
			this.last.setNext(temp);
			this.last = temp;
		}
		size++;
	}

	public void reveseKNodes(int k) {
		LinkedListNode<T> temp = reversek(this.head, k);
		this.head = temp;
	}

	private LinkedListNode<T> reversek(LinkedListNode<T> node, int k) {
		int count = 1;
		LinkedListNode<T> iterator = node;
		LinkedListNode<T> first = node;
		while (iterator != null && count < k) {
			iterator = iterator.getNext();
			count++;
		}
		LinkedListNode<T> nextHead = null;
		if (iterator != null) {
			nextHead = iterator.getNext();
			iterator.setNext(null);
		}
		if (count == k && iterator != null) {
			LinkedListNode<T> nextList = reversek(nextHead, k);
			LinkedListNode<T> prev = null;
			LinkedListNode<T> current = first;
			LinkedListNode<T> next = current.getNext();
			while (next != null) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
			first.setNext(nextList);
			if(prev!=null)
				return prev;
			else
				return current;
		} else {
			return first;
		}
	}
}

class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for (int i = 1; i <= 4; i++) {
			l.add(i);
		}
		System.out.println(l);
		l.reveseKNodes(1);
		System.out.println(l);
	}
}

class LinkedListNode<T> {
	private T data;
	private LinkedListNode<T> next;
	private LinkedListNode<T> prev;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(LinkedListNode<T> prev) {
		this.prev = prev;
	}

	public LinkedListNode(T data) {
		super();
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedListNode other = (LinkedListNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}

class TestLinkedListNode {
	public static void main(String[] args) {
		LinkedListNode<Integer> n1 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> n2 = new LinkedListNode<Integer>(2);
		n1.setNext(n2);
		n2.setPrev(n1);
		System.out.println(n2.getPrev());
		System.out.println(n1.getNext());
	}
}