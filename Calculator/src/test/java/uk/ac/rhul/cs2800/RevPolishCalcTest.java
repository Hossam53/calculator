package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {
  private  RevPolishCalc calc;
  @BeforeEach
  void setUp(){
     calc = new RevPolishCalc();
  }
  @Test
  void testSingleNumberEvaluation() {
    assertEquals(5, calc.evaluate("5"), "A single number should return itself.");
  }
  @Test
  public void testPlusZero() {
    assertEquals(5, calc.evaluate("5 0 +"), "Adding zero to a number should return the number itself.");
  }


}