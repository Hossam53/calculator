package uk.ac.rhul.cs2800;

public class StrStack {
  private final Stack numStack;

  public StrStack(){
    this.numStack = new Stack();
  }
  public int size(){
    return numStack.size();
  }
  public void push(String entry) {
    numStack.push(new Entry(entry));
  }
  public String pop() throws EmptyStack {
    return numStack.pop().toString();
  }


}
