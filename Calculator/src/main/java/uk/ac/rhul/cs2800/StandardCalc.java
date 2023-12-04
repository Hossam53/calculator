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
        if (c == '+' || c == '-' || c == '/'|| c =='*') {
          Symbol currentSymbol = symbolForChar(c);
          while (true) {
            try {
              if (!(opStack.size() != 0 && getPrecedence(currentSymbol) <= getPrecedence(opStack.top())))
                break;
            } catch (EmptyStack e) {
              throw new InvalidExpression(e.getMessage());
            }
            try {
              output.append(" ").append(opStack.pop().toString());
            } catch (EmptyStack e) {
              throw new InvalidExpression(e.getMessage());
            }
          }
          opStack.push(currentSymbol);
        }
      }
    }

    // Pop remaining operators
    while (opStack.size() != 0) {
      try {
        output.append(" ").append(opStack.pop().toString());
      } catch (EmptyStack e) {
        throw new InvalidExpression(e.getMessage());
      }
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
