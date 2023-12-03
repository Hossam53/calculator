package uk.ac.rhul.cs2800;

import application.Calculator;
import application.InvalidExpression;

public class StandardCalc implements Calculator {
  private OpStack value;
  private RevPolishCalc rpCalc;


  @Override
  public float evaluate(String expression) throws InvalidExpression {
    value = new OpStack();
    rpCalc = new RevPolishCalc();
    String postfix = infixToPostfix(expression, value);
    return rpCalc.evaluate(postfix);
  }

  private String infixToPostfix(String expression, OpStack opStack) {
    StringBuilder output = new StringBuilder();
    boolean isLastCharDigit = false;

    for (int i = 0; i < expression.length(); ++i) {
      char c = expression.charAt(i);

      if (Character.isDigit(c)) {
        if (isLastCharDigit) {
          output.append(c);
        } else {
          if (output.length() > 0) {
            output.append(" ");
          }
          output.append(c);
          isLastCharDigit = true;
        }
      } else {
        isLastCharDigit = false;
        if (c == '+') {
          opStack.push(Symbol.PLUS);
        }
      }
    }

    while (opStack.size() != 0) {
      try {
        output.append(" ").append(opStack.pop());
      } catch (EmptyStack e) {
        throw new RuntimeException(e);
      }
    }

    return output.toString().trim();
  }

}
