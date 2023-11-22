package uk.ac.rhul.cs2800;

import application.InvalidExpression;

public class RevPolishCalc {

  private Stack numStack;

  public RevPolishCalc() {
    numStack = new Stack();
  }

  public float evaluate(String expr) throws InvalidExpression {
    try {
      String[] tokens = expr.split("\\s+");
      for (String token : tokens) {
        if (token.matches("-?\\d+(\\.\\d+)?")) { // If it's a number
          numStack.push(new Entry(Float.parseFloat(token)));
        } else { // It's an operator
          if (numStack.size() < 2) {
            throw new InvalidExpression("Not enough operands for '" + token + "' operation.");
          }
          Entry operand2 = numStack.pop();
          Entry operand1 = numStack.pop();

          // Ensure both operands are numbers before performing operations
          if (operand1.getType() != Type.NUMBER || operand2.getType() != Type.NUMBER) {
            throw new InvalidExpression("Both operands must be numbers for the operation.");
          }

          float a = operand1.getValue();
          float b = operand2.getValue();
          float result;

          switch (token) {
            case "+":
              result = a + b;
              numStack.push(new Entry(result));
              break;
            // Implement other cases for different operations
            default:
              throw new InvalidExpression("Unsupported operation: " + token);
          }
        }
      }
      if (numStack.size() != 1) {
        throw new InvalidExpression("Invalid RPN expression. Stack should have only one item left.");
      }

      // Ensure the result is a number before returning it
      Entry resultEntry = numStack.pop();
      if (resultEntry.getType() != Type.NUMBER) {
        throw new InvalidExpression("Result should be a number.");
      }

      return resultEntry.getValue();
    } catch (EmptyStack | BadType e) {
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
  }
}
