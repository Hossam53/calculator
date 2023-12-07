package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
  private NumStack numstack;

  // Setup before each test, initializing the NumStack instance
  @BeforeEach
  void setUp() {
    numstack = new NumStack();
  }

  // Test 1: Verifying that a new stack is empty
  @Test
  void testEmptyNumStack() {
    assertEquals(0, numstack.size(), "The size of the stack should be 0");
  }

  // Test 2: Verifying that pushing a number increases the stack size
  @Test
  void testPushNumStack() {
    numstack.push(5.0f);
    assertEquals(1, numstack.size(), "The size of the stack should be 1");
  }

  // Test 3: Verifying that pushing and then popping a number leaves the stack empty
  @Test
  void testPushAndPopNumStack() throws EmptyStack {
    numstack.push(4.0f);
    numstack.pop();
    assertEquals(0, numstack.size(), "The size of the stack should be zero");
  }

  // Test 4: Verifying the top method returns the correct item and doesn't remove it
  @Test
  void testTopNumStack() throws EmptyStack {
    numstack.push(6.0f);
    assertEquals(6.0f, numstack.top(), "The top entry should be the same as the pushed entry");
    assertEquals(1, numstack.size(), "The size of the stack should be 1");
  }

  // Test 5: Verifying that popping from an empty stack throws an exception
  @Test
  void testPopOnEmptyNumStack() {
    assertThrows(EmptyStack.class, () -> numstack.pop());
  }

  // Test 6: Verifying that checking the top of an empty stack throws an exception
  @Test
  void testTopOnEmptyNumStack() {
    assertThrows(EmptyStack.class, () -> numstack.top());
  }
}
