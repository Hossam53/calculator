package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import application.InvalidExpression;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {
  private RevPolishCalc calc;

  // Setup before each test, initializing the RevPolishCalc instance
  @BeforeEach
  void setUp() {
    calc = new RevPolishCalc();
  }

  // Test 1: Testing single number evaluation
  @Test
  void testSingleNumberEvaluation() throws InvalidExpression {
    assertEquals(5, calc.evaluate("5"), "A single number should return itself.");
  }

  // Test 2: Testing addition with zero
  @Test
  void testPlusZero() throws InvalidExpression {
    assertEquals(5, calc.evaluate("5 0 +"), "Adding zero to a number should return the number itself.");
  }

  // Test 3: Testing addition with one
  @Test
  void testPlusOne() throws InvalidExpression {
    assertEquals(6, calc.evaluate("5 1 +"), "Adding one to a number should increment the number.");
  }

  // Test 4: Testing addition with a decimal
  @Test
  void testPlusDecimal() throws InvalidExpression {
    assertEquals(6.1, calc.evaluate("5 1.1 +"), 0.001, "Adding a decimal to a number should result in correct sum.");
  }

  // Test 5: Testing subtraction
  @Test
  void testMinusOne() throws InvalidExpression {
    assertEquals(4, calc.evaluate("5 1 -"), "Subtracting one from a number should decrement the number.");
  }

  // Test 6: Testing multiple operations
  @Test
  void testMinusMultiple() throws InvalidExpression {
    assertEquals(calc.evaluate("5 1 - 4 +"), 8, "Multiple operations should give the correct result.");
  }

  // Test 7: Testing multiplication
  @Test
  void testMultiplication() throws InvalidExpression {
    assertEquals(calc.evaluate("5 4 *"), 20, "Multiplying numbers should give the correct result.");
  }

  // Test 8: Testing division
  @Test
  void testDivision() throws InvalidExpression {
    assertEquals(calc.evaluate("8 4 /"), 2, "Dividing numbers should give the correct result.");
  }

  // Test 9: Testing division with a negative number
  @Test
  void testNegativeDivision() throws InvalidExpression {
    assertEquals(calc.evaluate("-5 1 /"), -5, "Dividing a negative number should work correctly.");
  }

  // Test 10: Testing complex operations
  @Test
  void testTwoOperations() throws InvalidExpression {
    assertEquals(calc.evaluate("5 1 4 - +"), 2, "Complex operations should give the correct result.");
  }

  // Test 11: Testing with random values
  @Test
  void TestRandom() throws InvalidExpression {
    Random random = new Random();
    for (int i = 0; i < 100; i++) {
      int num1 = random.nextInt(100);
      int num2 = random.nextInt(100);
      String expression = num1 + " " + num2 + " +";
      int expectedResult = num1 + num2;
      assertEquals(calc.evaluate(expression), expectedResult, "Random addition should return the correct result.");
    }
  }

  // Test 12: Testing invalid standard notation
  @Test
  void TestStandard() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("5+5"));
  }

  // Test 13: Testing invalid input with missing operator
  @Test
  void TestOneInput() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("5+"));
  }

  // Test 14: Testing invalid input with too many numbers
  @Test
  void TestThreeInputs() {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("5 6 4 +"));
  }

  // Test 15: Testing invalid expression resulting in incorrect stack size
  @Test
  void testInvalidStackSize() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> calc.evaluate("3 5 + 2"));
    assertEquals("Invalid RPN expression. Stack should have only one item left.", e.getMessage());
  }
}
