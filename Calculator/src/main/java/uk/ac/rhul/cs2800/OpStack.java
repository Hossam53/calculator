package uk.ac.rhul.cs2800;

public class OpStack {
  private final Stack opStack;

  public OpStack() {
    this.opStack = new Stack();
  }

  public int size() {
    return opStack.size();
  }

  public void push(Symbol entry) {
    opStack.push(new Entry(entry));
  }

  public Symbol pop() throws EmptyStack {
    try {
      return opStack.pop().getSymbol();
    } catch (BadType e) {
      throw new RuntimeException("Incorrect type in stack", e);
    }
  }

  public Symbol top() throws EmptyStack {

    try {
      return opStack.top().getSymbol();
    } catch (BadType e) {
      throw new RuntimeException(e);
    }
  }
}
