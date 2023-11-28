package uk.ac.rhul.cs2800;


/**
 * The numStack class implements a stack specifically for storing float values.
 * It provides basic stack operations such as push, pop, and top,
 * and is designed to be used in the evaluation of Reverse Polish Notation expressions.
 *
 * @author zlac241
 */
public class NumStack {
  private final Stack numStack; // A stack of Entry objects to store float values

  /**
   * Constructor for numStack.
   * Initializes a new stack to hold the float values.
   */
  public NumStack() {
    this.numStack = new Stack();
  }

  /**
   * Returns the number of elements in the stack.
   *
   * @return The size of the stack.
   */
  public int size() {
    return numStack.size();
  }

  /**
   * Pushes a float value onto the stack.
   *
   * @param entry The float value to be pushed onto the stack.
   */
  public void push(float entry) {
    numStack.push(new Entry(entry));
  }

  /**
   * Pops and returns the top value from the stack.
   *
   * @return The float value at the top of the stack.
   * @throws EmptyStack If the stack is empty.
   */
  public float pop() throws EmptyStack {
    try {
      return numStack.pop().getValue();
    } catch (BadType e) {
      throw new RuntimeException("Incorrect type in stack", e);
    }
  }

  /**
   * Returns the top value from the stack without removing it.
   *
   * @return The float value at the top of the stack.
   * @throws EmptyStack If the stack is empty.
   */
  public float top() throws EmptyStack {

    try {
      return numStack.top().getValue();
    } catch (BadType e) {
      throw new RuntimeException(e);
    }


  }
}
