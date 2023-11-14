package uk.ac.rhul.cs2800;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.ac.rhul.cs2800.EmptyStack;
import uk.ac.rhul.cs2800.Entry;
import uk.ac.rhul.cs2800.Stack;
import uk.ac.rhul.cs2800.Symbol;

import static org.junit.jupiter.api.Assertions.*;


class StackTest {

  private Stack stack;

  // Test 1: Setup - Initialises the stack for each test
  @BeforeEach
  void setUp() {
    stack = new Stack();
  }

  // Test 2: Check if a newly created stack is empty
  @Test
  void testEmptyStack() {
    assertEquals(0, stack.size(), "The size of the stack should be 0");
  }

  // Test 3: Push a single entry and verify the stack size
  @Test
  void testPushSingleEntry() {
    Entry entry = new Entry(5.0f);
    stack.push(entry);
    assertEquals(1, stack.size(), "The size of the stack should be 1");
  }

  // Test 4: Push one entry, pop it, and verify stack behaviour
  @Test
  void testPushOnePopOne() throws EmptyStack {
    Entry entry = new Entry(5.0f);
    stack.push(entry);
    assertEquals(1, stack.size(), "The size of the stack should be 1 after pushing");
    Entry poppedEntry = stack.pop();
    assertEquals(entry, poppedEntry, "The popped entry should be the same as the original entry");
    assertEquals(0, stack.size(), "The size of the stack should be 0 after popping");
  }

  // Test 5: Push one entry and check the top without popping
  @Test
  void testTop() throws EmptyStack {
    Entry entry = new Entry(5.0f);
    stack.push(entry);
    Entry topEntry = stack.top();
    assertEquals(entry, topEntry, "The top entry should be the same as the pushed entry");
    assertEquals(1, stack.size(), "The size of the stack should remain 1");
  }

  // Test 6: Push two entries, pop the last one, and verify stack behaviour
  @Test
  void testPushTwoPopOne() throws EmptyStack {
    Entry entry1 = new Entry(3.0f);
    Entry entry2 = new Entry(Symbol.LEFT_BRACKET);
    stack.push(entry1);
    stack.push(entry2);
    assertEquals(2, stack.size(), "The size of the stack should be 2 after pushing two entries");
    Entry poppedEntry = stack.pop();
    assertEquals(entry2, poppedEntry, "The popped entry should be the same as the last pushed entry");
    assertEquals(1, stack.size(), "The size of the stack should be 1 after popping one entry");
  }

  // Test 7: Push two entries, pop both, and verify stack behaviour
  @Test
  void testPushTwoPopTwo() throws EmptyStack {
    Entry entry1 = new Entry(8.0f);
    Entry entry2 = new Entry(Symbol.RIGHT_BRACKET);
    stack.push(entry1);
    stack.push(entry2);
    assertEquals(2, stack.size(), "The size of the stack should be 2 after pushing two entries");
    Entry poppedEntry1 = stack.pop();
    assertEquals(entry2, poppedEntry1, "The first popped entry should be the same as the last pushed entry");
    Entry poppedEntry2 = stack.pop();
    assertEquals(entry1, poppedEntry2, "The second popped entry should be the same as the first pushed entry");
    assertEquals(0, stack.size(), "The size of the stack should be 0 after popping two entries");
  }

  // Test 8: Attempt to pop an entry from an empty stack and expect an exception
  @Test
  void testPopOnEmptyStack() {
    assertThrows(EmptyStack.class, () -> stack.pop());
  }

  // Test 9: Attempt to check the top of an empty stack and expect an exception
  @Test
  void testTopOnEmptyStack() {
    assertThrows(EmptyStack.class, () -> stack.top());
  }

  // Test 10: Push multiple entries and verify the stack size
  @Test
  void testPushMultipleEntries() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(Symbol.MINUS);
    stack.push(entry1);
    stack.push(entry2);
    assertEquals(2, stack.size(), "The size of the stack should be 2");
  }

}
