package uk.ac.rhul.cs2800;

import application.Calculator;
import application.InvalidExpression;

/**
 * The StandardCalc class is responsible for evaluating string expressions in infix notation.
 * It first converts the infix expression to postfix notation and then uses a
 * Reverse Polish Notation calculator to evaluate the result.
 *
 * @author zlac241
 */
public class StandardCalc implements Calculator {
  // Stack used to hold operators during the conversion process
  private OpStack value;
  // Calculator to evaluate expressions in Reverse Polish Notation
  private RevPolishCalc rpCalc;

  /**
   * Evaluates the given infix expression by first converting it to postfix notation and then
   * evaluating the postfix expression.
   *
   * @param expression The infix expression to evaluate.
   * @return The evaluated result as a float.
   * @throws InvalidExpression if the expression is not valid infix notation or cannot be evaluated.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    // Initialize operator stack and RPN calculator
    value = new OpStack();
    rpCalc = new RevPolishCalc();
    // Convert the infix expression to postfix notation
    String postfix = infixToPostfix(expression, value);
    // Evaluate the postfix expression using the RPN calculator
    return rpCalc.evaluate(postfix);
  }

  /**
   * Determines the precedence of operators, which is required to correctly convert
   * infix expressions to postfix.
   *
   * @param symbol The operator symbol.
   * @return An integer representing the operator's precedence.
   */
  public int getPrecedence(Symbol symbol) {
    // Define precedence for operators: + and - have lower precedence than * and /
    switch (symbol) {
      case PLUS:
      case MINUS:
        return 1; // Lower precedence
      case TIME:
      case DIVIDE:
        return 2; // Higher precedence
      default:
        return -1; // Invalid operator
    }
  }

  /**
   * Converts an infix expression into postfix notation using a stack to handle operator precedence.
   *
   * @param expression The infix expression to convert.
   * @param opStack The stack used to temporarily hold operators.
   * @return A string representing the expression in postfix notation.
   * @throws InvalidExpression if the expression contains unmatched parentheses or unknown symbols.
   */
  private String infixToPostfix(String expression, OpStack opStack) throws InvalidExpression {
    StringBuilder output = new StringBuilder(); // Stores the postfix expression
    boolean isLastCharDigit = false; // Tracks whether the last character was a digit

    // Iterate over each character in the expression
    for (int i = 0; i < expression.length(); ++i) {
      char c = expression.charAt(i);

      // Skip spaces in the expression
      if (Character.isSpaceChar(c)) {
        continue;
      }

      // If the character is a digit, append it to the output
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
        // For non-digit characters, handle operators and parentheses
        isLastCharDigit = false;
        if (c == '(') {
          opStack.push(Symbol.LEFT_BRACKET);
        } else if (c == ')') {
          // Pop operators until a left bracket is encountered
          try {
            while (opStack.top() != Symbol.LEFT_BRACKET) {
              output.append(" ").append(opStack.pop().toString());
            }
            opStack.pop(); // Pop the left bracket itself
          } catch (EmptyStack e) {
            throw new InvalidExpression("Mismatched parentheses");
          }
        } else if (c == '+' || c == '-' || c == '/' || c == '*') {
          // Handle operator precedence and stack operations
          Symbol currentSymbol = symbolForChar(c);
          try {
            while (opStack.size() != 0 &&
                getPrecedence(currentSymbol) <= getPrecedence(opStack.top())) {
              output.append(" ").append(opStack.pop().toString());
            }
          } catch (EmptyStack e) {
            throw new InvalidExpression("Unexpected error in processing operators");
          }
          opStack.push(currentSymbol);
        }
      }
    }

    // Pop any remaining operators from the stack and append to the output
    try {
      while (opStack.size() != 0) {
        output.append(" ").append(opStack.pop().toString());
      }
    } catch (EmptyStack e) {
      throw new InvalidExpression("Unexpected error in popping remaining operators");
    }

    // Return the completed postfix expression
    return output.toString().trim();
  }

  /**
   * Maps a character to the corresponding symbol in the Symbol enumeration.
   *
   * @param c The character to be mapped.
   * @return The corresponding symbol.
   */
  private Symbol symbolForChar(char c) {
    // Map the character to the appropriate Symbol
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
        return Symbol.INVALID; // Return INVALID for unrecognized characters
    }
  }
}
