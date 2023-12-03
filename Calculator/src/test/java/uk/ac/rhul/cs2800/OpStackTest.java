package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {
  private OpStack opStack;

  @BeforeEach
  void setUp(){
    opStack = new OpStack();
  }
  @Test
  void testEmptyOpStack() {
    assertEquals(0, opStack.size(), "The size of the stack should be 0");
  }
  @Test
  void testPushOpStack(){
    opStack.push(Symbol.LEFT_BRACKET);
    assertEquals(1, opStack.size(), "The size of the stack should be 1");
  }
  @Test
  void testPushAndPopOpStack() throws EmptyStack {
    opStack.push(Symbol.DIVIDE);
    opStack.pop();
    assertEquals(0,opStack.size(),"The size of the stack should be zero");


  }

}