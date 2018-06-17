package customImplementation;

public class CustomLinkedHashMap<K,V> {
	
	int capacity = 4;
	Entry<K, V>[]  table;
	Entry<K,V> header, last;
	
	static class Entry<K,V>{
		K key;
		V value;
		Entry<K, V> next, after, before;
		
		public Entry(K key, V value, Entry<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public CustomLinkedHashMap(){
		table = new Entry[capacity];
	}
	
	public void put(K newKey, V newVal) {
		if(newKey == null) {
			return;
		}
		int hash = hash(newKey);
		Entry<K,V> newEntry = new Entry<K,V>(newKey, newVal, null);
		maintainOrderAfterInsert(newEntry);
		if(table[hash] == null) {
			table[hash] = newEntry;
		}else {
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];
			while(current!=null) {
				if(current.key.equals(newKey)) {
					if(previous==null) {
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					}else {
						newEntry.next = current.next;
						previous.next = newEntry;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	private void maintainOrderAfterInsert(Entry<K, V> newEntry) {
		if(header == null) {
			header = last = newEntry;
			return;
		}
		
		if(header.key.equals(newEntry.key)) {
			deleteFirst();
			insertFirst(newEntry);
			return;
		}
		
		if(last.key.equals(newEntry.key)) {
			deleteLast();
			insertLast(newEntry);
			return;
		}
		
		Entry<K,V> beforeDeleteEntry = deleteSpecificEntry(newEntry);
		if(beforeDeleteEntry == null) {
			insertLast(newEntry);
		}else {
			insertAfter(beforeDeleteEntry, newEntry);
		}
	}
	
	private void maintainOrderAfterDelete(Entry<K, V> deleteEntry) {
		if(header.key.equals(deleteEntry.key)) {
			deleteFirst();
			return;
		}
		
		if(last.key.equals(deleteEntry.key)) {
			deleteLast();
			return;
		}
		
		deleteSpecificEntry(deleteEntry);
		
	}

	private void insertAfter(Entry<K, V> beforeDeleteEntry, Entry<K, V> newEntry) {
		newEntry.after = beforeDeleteEntry.after;
		beforeDeleteEntry.after.before = newEntry;
		newEntry.before = beforeDeleteEntry;
		beforeDeleteEntry.after = newEntry;
	}

	private Entry<K, V> deleteSpecificEntry(Entry<K, V> newEntry) {
		Entry<K,V> current = header;
		while(!current.key.equals(newEntry.key)) {
			if(current.after == null) {
				return  null;
			}
			current = current.after;
		}
		Entry<K, V> beforeDeleteEntry = current.before;
		current.after.before = current.before;
		current.before.after = current.after;
		return beforeDeleteEntry;
	}

	private void insertLast(Entry<K, V> newEntry) {
		if(header == null) {
			header = last = newEntry;
			return;
		}
		newEntry.before = last;
		last.after = newEntry;
		last = newEntry;
	}

	private void deleteLast() {
		if(header == last) {
			header = last = null;
			return;
		}
		last = last.before;
		last.after = null;
	}

	private void insertFirst(Entry<K, V> newEntry) {
		if(header == null) {
			header = last = newEntry;
			return;
		}
		newEntry.after = header;
		header.before = newEntry;
		header = newEntry;
	}

	private void deleteFirst() {
		if(header == last) {
			header = last = null;
			return;
		}
		header = header.after;
		header.before = null;
	}

	public V get(K key) {
		int hash = hash(key);
		if(table[hash] == null) {
			return null;
		}else {
			Entry<K,V> entry = table[hash];
			while(entry!=null) {
				if(entry.key.equals(key)) {
					return entry.value;
				}
				entry = entry.next;
			}
			return null;
		}
	}
	
	public boolean remove(K delKey) {
		int hash = hash(delKey);
		if(table[hash] == null) {
			return false;
		}else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			while(current!=null) {
				if(current.key.equals(delKey)) {
					maintainOrderAfterDelete(current);
					if(previous==null) {
						table[hash] = table[hash].next;
						return true;
					}else{
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}
	
	public void display(){
	       Entry<K, V> currentEntry=header;
	       while(currentEntry!=null){
	           System.out.print("{"+currentEntry.key+"="+currentEntry.value+"}" +" ");
	           currentEntry=currentEntry.after;
	       }
	    
	    }
	
	private int hash(K newKey) {
		return Math.abs(newKey.hashCode())%capacity;
	}
}
