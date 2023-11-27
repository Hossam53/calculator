package uk.ac.rhul.cs2800;

import application.Calculator;
import application.InvalidExpression;

/**
 * The RevPolishCalc class implements a Reverse Polish Notation calculator.
 * It evaluates expressions written in Reverse Polish Notation (RPN),
 * a postfix notation wherein every operator follows all of its operands.
 *
 * @author zlac241
 */
public class RevPolishCalc implements Calculator {

  private numStack numStack;

  /**
   * Evaluates a given RPN expression.
   *
   * @param expr The RPN expression to be evaluated.
   * @return The result of the evaluated expression.
   * @throws InvalidExpression If the expression is invalid or an error occurs during evaluation.
   */
  public float evaluate(String expr) throws InvalidExpression {
    numStack = new numStack();
    try {
      // Split the expression into tokens
      String[] tokens = expr.split(" ");

      for (String token : tokens) {
        float result;

        switch (token) {
          case "+":
            // Addition operation
            float a = numStack.pop();
            float b = numStack.pop();
            result = a + b;
            numStack.push(result);
            break;
          case "-":
            // Subtraction operation
            float c = numStack.pop();
            float d = numStack.pop();
            result = d - c;
            numStack.push(result);
            break;
          case "*":
            // Multiplication operation
            float e = numStack.pop();
            float f = numStack.pop();
            result = e * f;
            numStack.push(result);
            break;
          case "/":
            // Division operation
            float g = numStack.pop();
            float h = numStack.pop();
            result = h / g;
            numStack.push(result);
            break;
          default:
            // Push number onto the stack
            numStack.push(Float.parseFloat(token));
        }
      }

      // Check if the final stack size is 1, indicating a valid expression
      if (numStack.size() != 1) {
        throw new InvalidExpression("Invalid RPN expression. Stack should have only one item left.");
      }

      // Return the final result
      return numStack.pop();
    } catch (EmptyStack | NumberFormatException e) {
      // Handle exceptions and throw InvalidExpression
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
  }
}
