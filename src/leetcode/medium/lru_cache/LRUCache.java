package leetcode.medium.lru_cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

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

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		keyToNode = new HashMap<>();
	}

	public int get(int key) {
		Node nodeForKey = keyToNode.get(key);
		if(nodeForKey == null) {
			return -1;
		}
		moveToFront(nodeForKey);
		return nodeForKey.value;
	}

	public void put(int key, int value) {
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
