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

  public int getPrecedence(Symbol symbol) {
    switch (symbol) {
      case PLUS:
      case MINUS:
        return 1;
      case TIME:
      case DIVIDE:
        return 2;
      default:
        return -1;
    }
  }

  private String infixToPostfix(String expression, OpStack opStack) throws InvalidExpression {
    StringBuilder output = new StringBuilder();
    boolean isLastCharDigit = false;

    for (int i = 0; i < expression.length(); ++i) {
      char c = expression.charAt(i);
      if(Character.isSpaceChar(c)){
        continue;
      }

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
        if (c == '(') {
          opStack.push(Symbol.LEFT_BRACKET);
        } else if (c == ')') {
          try {
            while (opStack.top() != Symbol.LEFT_BRACKET) {
              output.append(" ").append(opStack.pop().toString());
            }
            opStack.pop();
          } catch (EmptyStack e) {
            throw new InvalidExpression("Mismatched parentheses");
          }
        } else if (c == '+' || c == '-' || c == '/' || c =='*') {
          Symbol currentSymbol = symbolForChar(c);
          try {
            while (opStack.size() != 0 && getPrecedence(currentSymbol) <= getPrecedence(opStack.top())) {
              output.append(" ").append(opStack.pop().toString());
            }
          } catch (EmptyStack e) {
            throw new InvalidExpression("Unexpected error in processing operators");
          }
          opStack.push(currentSymbol);
        }
      }
    }

    try {
      while (opStack.size() != 0) {
        output.append(" ").append(opStack.pop().toString());
      }
    } catch (EmptyStack e) {
      throw new InvalidExpression("Unexpected error in popping remaining operators");
    }

    return output.toString().trim();
  }


  private Symbol symbolForChar(char c) {
    switch (c) {
      case '+':
        return Symbol.PLUS;
      case '-':
        return Symbol.MINUS;
      case '/':
        return Symbol.DIVIDE;
      case '*':
        return Symbol.TIME;
      default:
        return Symbol.INVALID;
    }
  }
}
