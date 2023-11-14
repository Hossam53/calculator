package uk.ac.rhul.cs2800;

/**
 * Represents an exception that is thrown when an unexpected type is encountered.
 */
public class BadType extends Exception {

  /**
   * Constructs a new BadType exception with the specified detail message.
   *
   * @param message the detail message, saved for later retrieval by the
   *                {@link #getMessage()} method.
   */
  public BadType(String message) {
    super(message);
  }
}