package uk.ac.rhul.cs2800;

/**
 * Represents a stack specifically for storing and manipulating mathematical symbols.
 * This stack is utilized in the process of converting infix expressions to postfix
 * and evaluating them.
 *
 * @author zlac241
 */
public class OpStack {
  private final Stack opStack; // Stack to hold the mathematical symbols

  /**
   * Constructor for OpStack.
   * Initializes a new stack to hold symbol entries.
   */
  public OpStack() {
    this.opStack = new Stack();
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return The number of symbols currently stored in the stack.
   */
  public int size() {
    return opStack.size();
  }

  /**
   * Pushes a symbol onto the stack.
   *
   * @param entry The symbol to be pushed onto the stack.
   */
  public void push(Symbol entry) {
    opStack.push(new Entry(entry));
  }

  /**
   * Pops the top symbol from the stack.
   *
   * @return The symbol at the top of the stack.
   * @throws EmptyStack If the stack is empty.
   */
  public Symbol pop() throws EmptyStack {
    try {
      return opStack.pop().getSymbol();
    } catch (BadType e) {
      // Throws a runtime exception if the stack contains an entry of the wrong type
      throw new RuntimeException("Incorrect type in stack", e);
    }
  }

  /**
   * Retrieves, but does not remove, the top symbol of the stack.
   *
   * @return The symbol at the top of the stack.
   * @throws EmptyStack If the stack is empty.
   */
  public Symbol top() throws EmptyStack {
    try {
      return opStack.top().getSymbol();
    } catch (BadType e) {
      // Throws a runtime exception if the stack contains an entry of the wrong type
      throw new RuntimeException(e);
    }
  }
}
