/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Lab -7
 */

import java.util.Iterator;

public abstract class AbstractMap<K,V> implements Map<K,V> {
    public boolean isEmpty(){
        return size() == 0;
    }

    // ------------------------- Nested MapEntry class ---------------------------
    protected static class MapEntry<K,V> implements  Entry<K,V>{
        private K k;
        private V v;

        public MapEntry(K key, V value){
            k = key;
            v = value;
        }

        //public methods of the Entry interface
        public K getKey(){
            return k;
        }

        public V getValue(){
            return v;
        }

        //utilities not exposed as part of the entry interface
        protected void setKey(K key){
            k = key;
        }

        protected V setValue(V value){
            V old = v;
            v = value;
            return old;
        }
    }
    // ---------------------- End of the nested MapEntry class --------------------

    // support for public keySet method
    private class KeyIterator implements Iterator<K>{
        private Iterator<Entry<K,V>> entries = entrySet().iterator();               // reuse entrySet
        public boolean hasNext(){
            return entries.hasNext();
        }

        public K next(){
            return entries.next().getKey();                                         // return key
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator(){
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet(){
        return new KeyIterable();
    }

    // support for public values method
    private class ValueIterator implements Iterator<V>{
        private Iterator<Entry<K,V>> entries = entrySet().iterator();
        public boolean hasNext(){
            return entries.hasNext();
        }

        public V next(){
            return entries.next().getValue();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator(){
            return new ValueIterator();
        }
    }

    public Iterable<V> values(){
        return new ValueIterable();
    }
}
