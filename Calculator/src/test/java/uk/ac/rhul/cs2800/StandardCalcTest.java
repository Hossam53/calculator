package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import application.InvalidExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {
  private StandardCalc calc;

  @BeforeEach
  void setUp(){
    calc = new StandardCalc();
  }
  @Test
  void testSimpleAddition() throws InvalidExpression {
    assertEquals(4.0f,calc.evaluate("2+2"),"Adding two to the number should output the desired result");
  }
  @Test
  void testSimpleSubtraction() throws InvalidExpression{
    assertEquals(2.0f,calc.evaluate("4-2"),"Substracting two from the number should give the correct output");
  }

}