package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {
  private StrStack numStack;

  // This setup runs before each test, initializing the stack
  @BeforeEach
  void setUp() {
    numStack = new StrStack();
  }

  // Test 1: Check if a new stack is empty
  @Test
  void testEmptyStrStack() {
    assertEquals(0, numStack.size(), "The size of the stack should be 0");
  }

  // Test 2: Check if pushing one item updates the size correctly
  @Test
  void testPushStrStack() {
    numStack.push("5");
    assertEquals(1, numStack.size(), "The size of the stack should be 1");
  }

  // Test 3: Push an item and then pop it, and check if the stack is empty again
  @Test
  void testPushAndPopStrStack() throws EmptyStack {
    numStack.push("5");
    numStack.pop();
    assertEquals(0, numStack.size(), "The size of the stack should be zero");
  }

  // Test 4: Push an item and check if the top item is the one that was pushed
  @Test
  void testTopStrStack() throws EmptyStack {
    numStack.push("7");
    assertEquals("7", numStack.top(), "The top entry should be the same as the pushed entry");
    assertEquals(1, numStack.size(), "The size of the stack should be 1");
  }

  // Test 5: Ensure popping from an empty stack throws an EmptyStack exception
  @Test
  void testPopOnEmptyStrStackThrowsEmptyStackException() {
    assertThrows(EmptyStack.class, () ->
        numStack.pop()
    );
  }

  // Test 6: Ensure querying the top of an empty stack throws an EmptyStack exception
  @Test
  void testTopOnEmptyStrStackThrowsEmptyStackException() {
    assertThrows(EmptyStack.class, () ->
        numStack.top()
    );
  }
}
