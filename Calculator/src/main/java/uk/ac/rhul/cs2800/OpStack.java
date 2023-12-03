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
}
