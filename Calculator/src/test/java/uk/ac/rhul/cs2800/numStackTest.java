package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class numStackTest {
  private numStack numstack;
  @BeforeEach
  void setUp(){
    numstack = new numStack();
  }
  //test1
  @Test
  void testEmptyNumStack() {
    assertEquals(0, numstack.size(), "The size of the stack should be 0");
  }


  //test2
  @Test
  void testPushNumStack(){
    numstack.push(5.0f);
    assertEquals(1, numstack.size(), "The size of the stack should be 1");
  }





}