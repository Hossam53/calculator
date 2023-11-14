package uk.ac.rhul.cs2800;

/**
 * Represents an exception thrown when trying to access an element from an empty stack.
 */
public class EmptyStack extends Exception {

  /**
   * Constructs a new EmptyStack with a provided error message.
   * @param message The specific error message for this exception.
   */
  public EmptyStack(String message) {
    super(message);
  }
}
