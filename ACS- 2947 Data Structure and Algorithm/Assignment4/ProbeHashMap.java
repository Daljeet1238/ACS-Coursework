/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.ArrayList;

public class ProbeHashMap<K,V> extends AbstractHashMap<K,V> {
    private MapEntry<K,V>[] table;                  // a fixed array of entries 
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null,null);

    public ProbeHashMap(){
        super();
    }

    public ProbeHashMap(int cap){
        super(cap);
    }

    public ProbeHashMap(int cap, int p){
        super(cap,p);
    }

    //creates an empty table having length equal to current capacity
    protected void createTable(){
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }

    //returns true if location is either empty or the "defunct" sentinel
    private boolean isAvailable(int j){
        return (table[j] == null || table[j] == DEFUNCT);
    }

    //returns index with key k, or -(a+1) such that k could be added at the index a
    private int findSlot(int h, K k){
        int avail = -1;
        int j = h;
        do{
            if (isAvailable(j)){
                if(avail == -1){
                    avail = j;
                }
                if(table[j] == null)break;
            }else if(table[j].getKey().equals(k)){
                return j;
            }else{
                j = (j+1) % capacity;
            }
        }while(j != h);
        return -(avail + 1);
    }

    //returns value associated with key k in bucket with hash value h, or else null
    protected V bucketGet(int h,K k){
        int j = findSlot(h, k);
        if(j < 0) return null;
        return table[j].getValue();
    }

    //associates key k with value v in bucket with hash value h, return old valeu
    protected V bucketPut(int h, K k, V v){
        int j = findSlot(h, k);
        if(j >= 0){
            return table[j].setValue(v);
        }
        table[-(j+1)] = new MapEntry<>(k,v);
        n++;
        return null;
    }

    // removes entry having key k from bucket with hash value h
    protected V bucketRemove(int h, K k){
        int j = findSlot(h, k);
        if(j < 0) return null;
        V answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    }

    //returns an iterable collection of all key-value entries of the map
    public Iterable<Entry<K,V>> entrySet(){
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for(int h = 0; h < capacity; h++){
            if(!isAvailable(h)) buffer.add(table[h]);
        }
        return buffer;
    }
}
