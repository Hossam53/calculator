package uk.ac.rhul.cs2800;

import application.CalcModel;
import application.InvalidExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalcModelTest {

  private CalcModel calculator; // The CalcModel object to be tested
  private RevPolishCalc revPolishCalc; // The Reverse Polish Notation calculator for comparison

  @BeforeEach
  void setUp() {
    calculator = new CalcModel(); // Initialize CalcModel
    revPolishCalc = new RevPolishCalc(); // Initialize RevPolishCalc
  }

  // Test 1: Testing the evaluate method of CalcModel
  @Test
  void testEvaluate() throws InvalidExpression {
    // Define a simple expression to evaluate
    String expression = "5";
    // Assert that CalcModel's evaluate method returns the same result as RevPolishCalc's evaluate
    assertEquals(calculator.evaluate(expression), revPolishCalc.evaluate(expression),
        "CalcModel should evaluate the expression correctly");
  }
}
