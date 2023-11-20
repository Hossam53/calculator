package uk.ac.rhul.cs2800;

public class numStack {
  private Stack numStack;


  public numStack() {
    this.numStack = new Stack();
  }

  public int size() {
    // Return the number of entries in the stack
    return numStack.size();
  }
}
