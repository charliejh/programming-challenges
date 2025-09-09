package leetcode.medium.lru_cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

class LRUCacheThreadSafe {

	static class Node {

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		private int key;
		private int value;
		private Node prev;
		private Node next;

	}

	private int capacity;
	private Node head;
	private Node tail;
	private Map<Integer, Node> keyToNode;
	private final ReentrantLock lock = new ReentrantLock(/* fair? */ false);

	public LRUCacheThreadSafe(int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		keyToNode = new HashMap<>();
	}

	/**
	 * - synchronized -
	 * Pros: tiny, safe, easy to reason about.
	 * Cons: only one thread inside get/put at a time (usually fine).
	 */
	public synchronized int get(int key) {
		lock.lock();
		Node nodeForKey = keyToNode.get(key);
		if(nodeForKey == null) {
			return -1;
		}
		moveToFront(nodeForKey);
		return nodeForKey.value;
	}

	public synchronized void put(int key, int value) {
		Node nodeForKey = keyToNode.get(key);
		if(nodeForKey != null) {
			nodeForKey.value = value;
			moveToFront(nodeForKey);
		} else {
			Node newNode = new Node(key, value);
			addNode(newNode);
			keyToNode.put(key, newNode);
			if(keyToNode.size() > capacity) {
				Node nodeToRemove = tail.prev;
				removeNode(nodeToRemove);
				keyToNode.remove(nodeToRemove.key);
			}
		}
	}

	private void removeNode (Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void addNode(Node node) {
		node.next = head.next;
		node.prev = head;
		node.next.prev = node;
		head.next = node;
	}

	private void moveToFront(Node node) {
		removeNode(node);
		addNode(node);
	}

}
