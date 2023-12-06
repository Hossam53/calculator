package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import application.InvalidExpression;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {
  private  RevPolishCalc calc;
  @BeforeEach
  void setUp(){
     calc = new RevPolishCalc();
  }
  @Test
  void testSingleNumberEvaluation() throws  InvalidExpression {
    assertEquals(5, calc.evaluate("5"), "A single number should return itself.");
  }
  @Test
   void testPlusZero() throws  InvalidExpression {
    assertEquals(5, calc.evaluate("5 0 +"), "Adding zero to a number should return the number itself.");
  }
  @Test
   void testPlusOne() throws  InvalidExpression {
    assertEquals(6, calc.evaluate("5 1 +"), "Adding one to a number should increment the number.");
  }
  @Test
   void testPlusDecimal() throws  InvalidExpression {
    assertEquals(6.1, calc.evaluate("5 1.1 +"),0.001, "Adding one to a number should increment the number.");
  }
  @Test
   void testMinusOne() throws  InvalidExpression {
    assertEquals(4, calc.evaluate("5 1 -"), "Adding one to a number should increment the number.");

  }
  @Test
   void testMinusMultiple() throws InvalidExpression{
    assertEquals(calc.evaluate("5 1 - 4 +"),8,"Multiple number operations should work");
  }
  @Test
   void testMultiplication() throws InvalidExpression{
    assertEquals(calc.evaluate("5 4 *"),20,"Multiplying the number should give the desired output");
  }
  @Test
   void testDivision() throws InvalidExpression{
    assertEquals(calc.evaluate("8 4 /"),2,"Dividing the output should return the corresponding output");

  }

  @Test
   void testNegativeDivision() throws InvalidExpression{
    assertEquals(calc.evaluate("-5 1 /"),-5,"Dividing the output should return the corresponding output");
  }
  @Test
   void testTwoOperations() throws InvalidExpression{
    assertEquals(calc.evaluate("5 1 4 - +"),2,"The corresponding operations should return the desired output");
  }
  @Test
   void TestRandom() throws InvalidExpression {
    Random random = new Random();
    for (int i = 0; i < 100; i++) {
      int num1 = random.nextInt(100);
      int num2 = random.nextInt(100);
      String expression = num1 + " " + num2 + " +";
      int expectedResult = num1 + num2;
      assertEquals(calc.evaluate(expression), expectedResult, "Random addition should return the correct output");
    }
  }
  @Test
   void TestStandard() {
    assertThrows(InvalidExpression.class, ()->calc.evaluate("5+5"));
  }

  @Test
   void TestOneInput(){
    assertThrows(InvalidExpression.class, ()->calc.evaluate("5+"));
  }

  @Test
   void TestThreeInputs(){
    assertThrows(InvalidExpression.class,()->calc.evaluate("5 6 4 +"));
  }
  @Test
   void testInvalidStackSize() {

    InvalidExpression e = assertThrows(InvalidExpression.class, ()-> calc.evaluate("3 5 + 2"));
    assertEquals("Invalid RPN expression. Stack should have only one item left.",e.getMessage());

  }




}