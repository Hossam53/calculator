package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NumStackTest {
  private NumStack numstack;
  @BeforeEach
  void setUp(){
    numstack = new NumStack();
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

  //test 3
  @Test
  void testPushAndPopNumStack() throws EmptyStack {
    numstack.push(4.0f);
    numstack.pop();
    assertEquals(0,numstack.size(),"The size of the stack should be zero");

  }

  //test 4
  @Test
  void testTopNumStack() throws EmptyStack{
    numstack.push(6.0f);
    assertEquals(  6.0f , numstack.top(), "The top entry should be the same as the pushed entry");
    assertEquals(1, numstack.size(), "The size of the stack should be 1");

  }







}