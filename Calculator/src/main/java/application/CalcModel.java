package application;

import uk.ac.rhul.cs2800.RevPolishCalc;

/**
 * The CalcModel class implements the Calculator interface and is responsible for evaluating
 * mathematical expressions. This class currently supports Reverse Polish Notation (RPN) evaluation.
 * It can be extended to support standard (infix) notation evaluation as well.
 *
 * @author zlac241
 */
public class CalcModel implements Calculator {

  private Calculator revPolish;
  private Calculator standard;

  /**
   * Constructor for CalcModel.
   * Initializes the model with a Reverse Polish Notation calculator.
   */
  public CalcModel() {
    revPolish = new RevPolishCalc();
    // standard calculator initialization can be added here if needed
  }

  /**
   * Evaluates a given mathematical expression using Reverse Polish Notation.
   *
   * @param expression The mathematical expression to be evaluated.
   * @return The result of the evaluated expression.
   * @throws InvalidExpression If the expression is invalid or an error occurs during evaluation.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    return revPolish.evaluate(expression);
  }

  // Standard calculator evaluation methods can be added here for future expansion
}
