package leetcode.medium.lru_cache;

public class Main {

	public static void main(String[] args) {

		LRUCache lruCache =  new LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);

		int i = lruCache.get(1);
		System.out.println(i);

		lruCache.put(3, 3);

		int i1 = lruCache.get(2);
		System.out.println(i1);
	}

}
