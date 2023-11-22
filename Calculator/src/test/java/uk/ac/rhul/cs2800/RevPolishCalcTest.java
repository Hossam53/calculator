package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RevPolishCalcTest {
  @Test
  void testSingleNumberEvaluation() {
    RevPolishCalc calc = new RevPolishCalc();
    assertEquals(5, calc.evaluate("5"), "A single number should return itself.");
  }


}