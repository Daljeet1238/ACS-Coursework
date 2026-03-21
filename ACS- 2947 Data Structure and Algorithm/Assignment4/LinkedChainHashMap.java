/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

import java.util.Iterator;

public class LinkedChainHashMap<K,V> extends AbstractHashMap<K,V> {
    private DoublyLinkedList<MapEntry<K,V>>[] table;
    private int collisions = 0;

    public LinkedChainHashMap(){super();}

    public LinkedChainHashMap(int cap){super(cap);}
    public LinkedChainHashMap(int cap, int p){super (cap, p);}

    @Override
    protected void createTable(){
        table = (DoublyLinkedList<MapEntry<K,V>>[]) new DoublyLinkedList[capacity];
    }

    protected V bucketGet(int h, K k){
        DoublyLinkedList<MapEntry<K,V>> bucket = table[h];
        if(bucket == null) return null;
        
        for(MapEntry<K,V> entry : bucket){
            if(entry.getKey().equals(k)){
                return entry.getValue();
            }
        }
        return null;
    }

    protected V bucketPut(int h, K k, V v){
        DoublyLinkedList<MapEntry<K,V>> bucket = table[h];
        if(bucket == null){
            bucket = table[h] = new DoublyLinkedList<>();
        }else{
            for(MapEntry<K,V> entry : bucket){
                if(entry.getKey().equals(k)){
                    V oldValue = entry.getValue();
                    entry.setValue(v);
                    return oldValue;
                }
            }
            collisions++;
        }

        bucket.addLast(new MapEntry<>(k, v));
        n++;
        return null;
    }

    
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        DoublyLinkedList<Entry<K,V>> buffer = new DoublyLinkedList<>();

        for(int h = 0; h < capacity; h++){
            if(table[h] != null){
                for(Entry<K,V> entry : table[h]){
                    buffer.addLast(entry);
                }
            }
        }
        return buffer;
    }

    @Override
    protected V bucketRemove(int h, K k) {
        DoublyLinkedList<MapEntry<K,V>> bucket = table[h];

        if(bucket == null) return null;
        Iterator<MapEntry<K,V>> i = bucket.iterator();
        while(i.hasNext()){
            MapEntry<K,V> entry = i.next();
            if(entry.getKey().equals(k)){
                i.remove();
                n--;
                return entry.getValue();
            }
        }

        return null;
    }

    public int getCollisions(){
        return collisions;
    }

}
