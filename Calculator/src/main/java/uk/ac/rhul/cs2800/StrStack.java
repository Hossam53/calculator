package uk.ac.rhul.cs2800;

/**
 * A stack specifically designed for handling strings.
 * This stack can be used for storing and manipulating strings, such as during the
 * process of expression evaluation or conversion between different notations.
 *
 * @author zlac241
 */
public class StrStack {
  private final Stack numStack; // Stack to hold string entries

  /**
   * Constructor for StrStack.
   * Initializes a new stack to hold string entries.
   */
  public StrStack() {
    this.numStack = new Stack();
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return The number of strings currently stored in the stack.
   */
  public int size() {
    return numStack.size();
  }

  /**
   * Pushes a string onto the stack.
   *
   * @param entry The string to be pushed onto the stack.
   */
  public void push(String entry) {
    numStack.push(new Entry(entry));
  }

  /**
   * Pops the top string from the stack.
   *
   * @return The string at the top of the stack.
   * @throws EmptyStack If the stack is empty.
   */
  public String pop() throws EmptyStack {
    try {
      return numStack.pop().getString();
    } catch (BadType e) {
      // Throws a runtime exception if the stack contains an entry of the wrong type
      throw new RuntimeException(e);
    }
  }

  /**
   * Retrieves, but does not remove, the top string of the stack.
   *
   * @return The string at the top of the stack.
   * @throws EmptyStack If the stack is empty.
   */
  public String top() throws EmptyStack {
    try {
      return numStack.top().getString();
    } catch (BadType e) {
      // Throws a runtime exception if the stack contains an entry of the wrong type
      throw new RuntimeException(e);
    }
  }
}
