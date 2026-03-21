/*
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 */
/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Lab -7
 */

/**
 * Interface for a key-value pair.
 */

public interface Entry<K,V> {
    
  /**
   * Returns the key stored in this entry.
   * @return the entry's key
   */
  K getKey();

  /**
   * Returns the value stored in this entry.
   * @return the entry's value
   */
  V getValue();
}
