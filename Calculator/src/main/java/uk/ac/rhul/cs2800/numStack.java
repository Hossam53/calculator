package uk.ac.rhul.cs2800;

public class numStack {
  private final Stack numStack;


  public numStack() {
    this.numStack = new Stack();
  }

  public int size() {
    // Return the number of entries in the stack
    return numStack.size();
  }

  public void push(float entry){
    numStack.push(new Entry(entry));

  }
  public float pop() throws EmptyStack {
    try {
      return numStack.pop().getValue();

    }catch (BadType e) {
      throw new RuntimeException(e);
    }

  }

  public float top() throws EmptyStack{

    try {
      return numStack.top().getValue();
    }catch (BadType e){
      throw new RuntimeException(e);
    }


  }

}
