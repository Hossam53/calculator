package uk.ac.rhul.cs2800;

import application.CalcModel;
import application.InvalidExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class CalcModelTest {

  private CalcModel calculator;
  private RevPolishCalc revPolishCalc;
  @BeforeEach
  void setUp(){
    calculator = new CalcModel();
    revPolishCalc = new RevPolishCalc();
  }
  @Test
  void testEvaluate() throws InvalidExpression {
    String expression = "5";
    assertEquals(calculator.evaluate(expression),revPolishCalc.evaluate(expression));
  }
}
