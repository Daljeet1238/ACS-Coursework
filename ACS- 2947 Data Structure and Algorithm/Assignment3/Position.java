/**
 * Daljeet Singh
 * ACS-2947 Assignment-3
 */

/*
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 */
public interface Position<E> {
  /**
   * Returns the element stored at this position.
   *
   * @return the stored element
   * @throws IllegalStateException if position no longer valid
   */
  E getElement() throws IllegalStateException;
}
