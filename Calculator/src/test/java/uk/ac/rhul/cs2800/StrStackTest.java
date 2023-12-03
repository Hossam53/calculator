package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {
  private StrStack numStack;

  @BeforeEach
  void setUp(){
    numStack = new StrStack();
  }

  @Test
  void testEmptyStrStack() {
    assertEquals(0, numStack.size(), "The size of the stack should be 0");
  }
  @Test
  void testPushStrStack(){
    numStack.push("5");
    assertEquals(1, numStack.size(), "The size of the stack should be 1");
  }
  @Test
  void testPushAndPopStrStack() throws EmptyStack {
    numStack.push("5");
    numStack.pop();
    assertEquals(0,numStack.size(),"The size of the stack should be zero");
  }
  @Test
  void testTopStrStack() throws EmptyStack{
    numStack.push("7");
    assertEquals("7", numStack.top(), "The top entry should be the same as the pushed entry");
    assertEquals(1, numStack.size(), "The size of the stack should be 1");

  }

}