// --== CS400 File Header Information ==--
// Name: Eric Chang
// Email: echang39@wisc.edu
// Team: Red
// Group: EB
// TA: Yelun Bao
// Lecturer: Gary Dahl
// Notes to Grader: 

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Pair node class that is set up like a linked list to store
 * key-value pairs. Includes getters for keys and values, and 
 * setters for changing references to the next and previous 
 * key-value pair.
 * 
 */
class PairNodeList<KeyType, ValueType> {
    private KeyType key;
    private ValueType value;
    private PairNodeList<KeyType, ValueType> next;
    private PairNodeList<KeyType, ValueType> prev;

    /*
    * Constructor for a PairNode object to store a key-value
    * pair. 
    * 
    * @param key The key to be hashed
    * @param value The value corresponding to key to be stored
    */
    public PairNodeList(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
        }

   /*
    * Constructor for a PairNode object to store a key-value
    * pair. Sets next and previous according to parameters.
    *
    * @param key The key to be hashed
    * @param value The value corresponding to key to be stored
    * @param next The reference of the next PairNode
    * @param previous The reference of the previous PairNode
    */
    public PairNodeList(KeyType key, ValueType value, PairNodeList<KeyType, ValueType> next,
        PairNodeList<KeyType, ValueType> prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
        }

      /*
      * Getter returning the key of the key-value pair.
      *
      * @return key of key-value pair
      */
      public KeyType getKey() {
          return this.key;
          }

     /*
      * Getter returning the value of the key-value pair.
      *
      * @return value of key-value pair
      */
      public ValueType getValue() {
          return this.value;
          }

     /*
      * Getter returning the reference of the next PairNode.
      *
      * @return reference of the next PairNode
      */
      public PairNodeList<KeyType, ValueType> getNext() {
          return this.next;
          }

     /*
      * Getter returning the reference of the previous PairNode.
      *
      * @return reference of the previous PairNode
      */
      public PairNodeList<KeyType, ValueType> getPrevious() {
          return this.prev;
          }

     /*
      * Setter setting the reference of the next PairNode.
      */
      public void setNext(PairNodeList<KeyType, ValueType> pair) {
          this.next = pair;
          }
    
     /*
      * Setter setting the reference of the previous PairNode.
      */
    public void setPrevious(PairNodeList<KeyType, ValueType> pair) {
        this.prev = pair;
        }
}
/**
 * Class implements the MapADT to create a working hash table.
 * PairNode class is incorporated, which helps to store key-value pairs.
 * 
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
      protected PairNodeList<KeyType, ValueType>[] pairs;
      int capacity;
      int size;

    /*
    * Constructor for creating a hashTableMap object to store
    * a key-value pair. Creates a PairNode array with the
    * default capacity.
    *
    * @param capacity capacity of table
    */
    public HashTableMap() {
        capacity = 10;
        pairs = new PairNodeList[capacity];
        size = 0;
        }

    /*
    * Constructor for creating a hashTableMap object to store
    * a key-value pair. Creates a PairNode array with the
    * given capacity.
    *
    * @param capacity capacity of table
    */
    public HashTableMap(int capacity) {
        this.capacity = capacity;
        pairs = new PairNodeList[capacity];
        size = 0;
        }

    /*
    * Private helper method that grows the array when load 
    * capacity is met or exceeded. Elements and key-value pairs
    * are copied over and rehashed/stored.
    *
    */
    private void grow() {
        PairNodeList<KeyType, ValueType>[] oldArray= new PairNodeList[capacity]; 
        for(int i = 0; i < capacity; i++) {
            if(pairs[i] != null) {
                oldArray[i] = pairs[i];
                }
            }
        capacity= capacity * 2;
        size = 0;
        PairNodeList<KeyType, ValueType>[] newArray = new PairNodeList[capacity];
        pairs = newArray;

        for(int i = 0; i < oldArray.length; i++) {
          if(oldArray[i] != null) {
            PairNodeList<KeyType, ValueType> temp = oldArray[i];
            while(temp != null) {
               put(temp.getKey(), temp.getValue());
               temp = temp.getNext();
               }
            }
          else {  
          }
          }
        }

    /*
    * This method adds a new key-value pair to the array.
    * Checks for collisions and does chaining if applicable.
    * If the load capacity is met or exceeded, calls grow() to grow
    * the array.
    *
    * @param key Key to be hashed
    * @param value Value to be stored with corresponding key
    * @return true if pair is successfully added
    *
    */
    @Override
    public boolean put(KeyType key, ValueType value) {
        if(containsKey(key)) {
            return false;
            }
        int hashed = Math.abs(key.hashCode()) % capacity;
        if(pairs[hashed] == null) {
            pairs[hashed] = new PairNodeList<KeyType, ValueType>(key, value);
            }
        else {
            PairNodeList<KeyType, ValueType> temp= pairs[hashed];
            while(temp.getNext()!=null) {
                temp= temp.getNext();
                }
            temp.setNext(new PairNodeList<KeyType, ValueType>(key, value, null, temp));
            }
        size++;
        if(size/(double)capacity >= 0.85) {
            grow();
        }
        return true;
    }

    /*
    * This method is used to look up the value of a key-value pair.
    *
    * @param key Key to be looked up
    * @throws NoSuchElement Exception if key is not found
    * @return the value corresponding with the key used for lookup
    *
    */
    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        if(!containsKey(key)) {
            throw new NoSuchElementException();      
        }
        else {
            int hashed= Math.abs(key.hashCode()) % capacity;
            if(pairs[hashed].getKey().equals(key)) {
                return pairs[hashed].getValue();
            }
            else{
                PairNodeList<KeyType, ValueType> temp = pairs[hashed].getNext();
                while(temp != null){
                    if(temp.getKey().equals(key)) {
                        return temp.getValue();
                        }
                    else {
                        temp=temp.getNext();
                        }
                    }
                }
            } 
        return null;   
        }

    /*
    * This method returns the number of 
    * key-value pairs stored in the array.
    *
    * @return number of pairs stored in array.
    *
    */
    @Override
    public int size() {
        return size;
    }

    /*
    * This method checks if the given key
    * is already stored in the array.
    *
    * @param key Key to be looked up 
    * @return true if key is found
    *
    */
    @Override
    public boolean containsKey(KeyType key) {
        for(int i = 0; i < capacity; i++) {
            if(pairs[i] != null) {
                PairNodeList<KeyType, ValueType> temp = pairs[i];
                while(temp!=null){
                    if(temp.getKey().equals(key))
                        return true;
                    else {
                        temp=temp.getNext();
                    }
                    }
                }
            }
        return false;
        }

    /*
    * This method is used to remove a key-value pair.
    * Checks if the given key-value pair is stored in the array
    * and returns null if it isn't.
    *
    * Restructures the chain if the key-value pair was chained.
    *
    * @param key Key to be removed
    * @return the value associate with key to be removed
    *
    */
    @Override
    public ValueType remove(KeyType key) {
        ValueType toRemove = null;
        
        if(!containsKey(key)) {
            return null;
            }
        else{
            int hashed= Math.abs(key.hashCode())%capacity;
            if(pairs[hashed].getKey().equals(key)&& pairs[hashed].getNext()==null) {
                toRemove= pairs[hashed].getValue(); 
                pairs[hashed]=null;
            }
            else if(pairs[hashed].getKey().equals(key) && pairs[hashed].getNext() != null) {
                toRemove= pairs[hashed].getValue();
                pairs[hashed]=(pairs[hashed].getNext());
            }
            else {
                PairNodeList<KeyType, ValueType> temp= pairs[hashed]; 
                while(temp!=null){
                    if(temp.getKey().equals(key)){
                        toRemove=temp.getValue();
                        temp=temp.getPrevious();
                        temp.setNext(temp.getNext().getNext());
                        }
                    else {
                    }
                    }

            }

        }
        size--;
        return toRemove;
    }
   
    /*
    * This method is used to clear all pairs from the table
    *
    */
    @Override
    public void clear() {
        PairNodeList<KeyType, ValueType>[] newPairs = new PairNodeList[capacity]; 
        pairs = newPairs;
        size = 0;
    }
    public PairNodeList<KeyType, ValueType>[] getPairs(){
        return this.pairs;
    }

}