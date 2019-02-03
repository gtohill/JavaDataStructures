import java.util.LinkedList;

public class HashTable {
	LinkedList<LinkedList<String>> hashlist;
	int tablesize = 0;
	// constructor
	public HashTable(String[] strarr) {
		
		tablesize = (int)(strarr.length * 2);		
		hashlist = new LinkedList<LinkedList<String>>();
		
		// initialize the linked list of linked lists
		for(int i = 0; i < tablesize; i++) {
			hashlist.add(new LinkedList<String>());
		}
		
	}
	
	public void add(String str) {
		int hashcode = hashCode(str);
		// get linked list
		LinkedList<String> link = hashlist.get(hashcode);		
		link.add(str);
		System.out.format("String: %s | added at %d" , str, hashcode);
		System.out.println("");
	}
	
	/*
	 * find method. hash to the location on the link list to find the item
	 */
	public String find(String str) {
		
		int hashcode = hashCode(str);
		LinkedList<String> link = hashlist.get(hashcode);
		for(String term : link) {
			if(term.equals(str)) {
				return term;
			}
		}
		return null;
	}
	
	public boolean delete(String str) {
		int hashcode = hashCode(str);
		boolean flag = false;
		LinkedList<String> link = hashlist.get(hashcode);
		for(String i : link) {
			if(i.equals(str)) {
				link.remove(str);
				flag = true;
			}
		}
		return flag;
	}
	
	public int hashCode(String str) {
		int hashcode = 7;
		for(int i = 0; i < str.length(); i++) {
			hashcode += (37 * (Math.pow(str.charAt(i), i))) % tablesize;								
		}
		//System.out.println(hashcode);
		return hashcode % tablesize;
	}

	// TEST HARNESS
    public static void main(String[] args) {
        String[] fruits = {"apple", "banana", "orange", "grape", "raisin"};

        HashTable hashit = new HashTable(fruits);
        for(int i = 0; i < fruits.length; i++) {
            hashit.add(fruits[i]);
        }

        for(int i = 0; i < fruits.length; i++) {
            String s = (String) hashit.find(fruits[i]);
            System.out.format("We found %s",s);
            System.out.println("");
        }

        //hashit.delete("apple");

        String f = (String)hashit.find("apple");
        if(f == null) {
            System.out.println("Target not found");
        }
        else {
            System.out.format("Found %s ", f);
        }

    }

}
