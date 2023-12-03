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
}