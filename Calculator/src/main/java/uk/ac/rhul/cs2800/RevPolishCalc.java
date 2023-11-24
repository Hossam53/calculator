package uk.ac.rhul.cs2800;

import application.InvalidExpression;

public class RevPolishCalc {

  private numStack numStack;

  public RevPolishCalc() {
    numStack = new numStack();
  }

  public float evaluate(String expr) throws InvalidExpression {
    try {
      String[] tokens = expr.split(" ");
      for (String token : tokens) {
          float result;

          switch (token) {
            case "+":
              float a = numStack.pop();
              float b = numStack.pop();
              result = a + b;
              numStack.push(result);
              break;
            case "-":
              float c = numStack.pop();
              float d = numStack.pop();
              result = d - c;
              numStack.push(result);
              break;
            case "*":
              float e = numStack.pop();
              float f = numStack.pop();
              result =e*f;
              numStack.push(result);
              break;


            // Implement other cases for different operations
            default:
              numStack.push(Float.parseFloat(token));
          }
        }

      if (numStack.size() != 1) {
        throw new InvalidExpression("Invalid RPN expression. Stack should have only one item left.");
      }



      return numStack.pop();
    } catch (EmptyStack | NumberFormatException e) {
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
  }
}
