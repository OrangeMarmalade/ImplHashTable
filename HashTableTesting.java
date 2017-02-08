package Tests;

import static org.junit.Assert.*;
import source.ImplementedHashMap;

import org.junit.Test;

public class HashTableTesting {

	@Test
	public void test() {
		ImplementedHashMap<String, Integer> hashMap = new ImplementedHashMap<String, Integer>(32);
		hashMap.put("blah", 3);
		System.out.println(hashMap.get("blah"));
		System.out.println(hashMap.get("yay)"));
		hashMap.put("bro", 55);
		hashMap.remove("blah");
		System.out.println(hashMap.get("bro"));
		assertNull("it is null", hashMap.get("blah"));
		
	}

}
