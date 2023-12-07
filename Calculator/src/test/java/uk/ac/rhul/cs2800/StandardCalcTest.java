package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import application.InvalidExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StandardCalcTest {
  private StandardCalc calc;

  // Setup before each test, initializing the StandardCalc instance
  @BeforeEach
  void setUp() {
    calc = new StandardCalc();
  }

  // Test 1: Testing simple addition
  @Test
  void testSimpleAddition() throws InvalidExpression {
    assertEquals(4.0f, calc.evaluate("2 + 2"), "Adding two numbers should output the desired result");
  }

  // Test 2: Testing simple subtraction
  @Test
  void testSimpleSubtraction() throws InvalidExpression {
    assertEquals(2.0f, calc.evaluate("4 - 2"), "Subtracting two numbers should give the correct output");
  }

  // Test 3: Testing simple division
  @Test
  void testSimpleDivision() throws InvalidExpression {
    assertEquals(4.0f, calc.evaluate("8 / 2"), "Dividing a number should return the correct answer");
  }

  // Test 4: Testing simple multiplication
  @Test
  void testSimpleMultiplication() throws InvalidExpression {
    assertEquals(6.0f, calc.evaluate("3 * 2"), "Multiplying two numbers should output the correct answer");
  }

  // Test 5: Testing simple operation with brackets
  @Test
  void testSimpleBrackets() throws InvalidExpression {
    assertEquals(3.0f, calc.evaluate("( 3 + 3 ) / 2"), "Operations with brackets should be evaluated correctly");
  }

  // Test 6: Testing complex operation
  @Test
  void testComplexOperation() throws InvalidExpression {
    assertEquals(14.4f, calc.evaluate("( 4 * 3 ) + 4 / ( 3 + 2) * 3"), "Complex operation should return the corresponding value");
  }

  // Test 7: Testing reverse notation in a standard calculator
  @Test
  void testReverseInStandard() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("5 6+"), "Reverse Polish notation should be invalid in StandardCalc");
  }

  // Test 8: Testing mismatched parentheses
  @Test
  void testMismatchedParenthesis() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> calc.evaluate("5 + (6 - 3) )"));
    assertEquals("Mismatched parentheses", e.getMessage(), "Mismatched parentheses should throw an InvalidExpression exception");
  }
}
