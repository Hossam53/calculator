package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stack data structure for storing Entry objects.
 */
public class Stack {

  // List to internally store the entries in the stack
  private final List<Entry> entries;

  /**
   * Initialises an empty stack.
   */
  public Stack() {
    // Initialise the entries list as an empty ArrayList
    entries = new ArrayList<>();
  }

  /**
   * Pushes an entry onto the top of the stack.
   * @param entry The entry to be pushed onto the stack.
   */
  public void push(Entry entry) {
    // Add the given entry to the end of the list, which represents the top of the stack
    entries.add(entry);
  }

  /**
   * Removes and returns the top entry from the stack.
   * @return The top entry from the stack.
   * @throws EmptyStack if the stack is empty.
   */
  public Entry pop() throws EmptyStack {
    // Check if the stack is empty before trying to remove an entry
    if (entries.isEmpty()) {
      throw new EmptyStack("The stack is empty.");
    }
    // Remove and return the last entry from the list, which represents the top of the stack
    return entries.remove(entries.size() - 1);
  }

  /**
   * Returns the top entry from the stack without removing it.
   * @return The top entry from the stack.
   * @throws EmptyStack if the stack is empty.
   */
  public Entry top() throws EmptyStack {
    // Check if the stack is empty before accessing an entry
    if (entries.isEmpty()) {
      throw new EmptyStack("The stack is empty.");
    }
    // Return the last entry from the list without removing it
    return entries.get(entries.size() - 1);
  }

  /**
   * Returns the number of entries in the stack.
   * @return The size of the stack.
   */
  public int size() {
    // Return the number of entries in the stack
    return entries.size();
  }
}

