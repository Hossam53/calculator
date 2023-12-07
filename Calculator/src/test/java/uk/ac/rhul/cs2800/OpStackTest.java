package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for OpStack.
 * This class contains unit tests to verify the functionality of the OpStack.
 */
class OpStackTest {
  private OpStack opStack;

  // Setup before each test, initializing the OpStack instance
  @BeforeEach
  void setUp() {
    opStack = new OpStack();
  }

  // Test 1: Verifying that a new stack is empty
  @Test
  void testEmptyOpStack() {
    assertEquals(0, opStack.size(), "The size of the stack should be 0");
  }

  // Test 2: Verifying that pushing a symbol increases the stack size
  @Test
  void testPushOpStack() {
    opStack.push(Symbol.LEFT_BRACKET);
    assertEquals(1, opStack.size(), "The size of the stack should be 1");
  }

  // Test 3: Verifying that pushing and then popping a symbol leaves the stack empty
  @Test
  void testPushAndPopOpStack() throws EmptyStack {
    opStack.push(Symbol.DIVIDE);
    opStack.pop();
    assertEquals(0, opStack.size(), "The size of the stack should be zero");
  }

  // Test 4: Verifying the top method returns the correct item and doesn't remove it
  @Test
  void testTopOpStack() throws EmptyStack {
    opStack.push(Symbol.INVALID);
    assertEquals(Symbol.INVALID, opStack.top(), "The top entry should be the same as the pushed entry");
    assertEquals(1, opStack.size(), "The size of the stack should be 1");
  }
}
