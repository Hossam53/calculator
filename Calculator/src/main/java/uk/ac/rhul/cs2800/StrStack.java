package uk.ac.rhul.cs2800;

public class StrStack {
  private final Stack numStack;

  public StrStack() {
    this.numStack = new Stack();
  }

  public int size() {
    return numStack.size();
  }

  public void push(String entry) {
    numStack.push(new Entry(entry));
  }

  public String pop() throws EmptyStack {
    try {
      return numStack.pop().getString();
    } catch (BadType e) {
      throw new RuntimeException(e);
    }
  }

  public String top() throws EmptyStack {
    try {
      return numStack.top().getString();
    } catch (BadType e) {
      throw new RuntimeException(e);
    }
  }


}
