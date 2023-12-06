package uk.ac.rhul.cs2800;

import application.ViewInterface;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A mock implementation of the ViewInterface used for testing purposes.
 * This mock class simulates the behavior of a user interface in the MVC architecture
 * without the need for a real graphical interface, facilitating unit testing of controller logic.
 *
 * @author zlac241
 */
public class MockView implements ViewInterface {
  // Function to observe calculation requests
  Function<String, Float> calculateObserver;
  // Consumer to observe type changes (infix or RPN)
  Consumer<Boolean> typeObserver;

  // Current expression input by the user
  private String currentExpression;
  // Field to store the calculation mode (true for infix, false for RPN)
  private boolean isInfix = true;
  // The answer displayed to the user
  private String answerDisplayed;

  /**
   * Adds a method (observer) for handling calculation requests.
   *
   * @param f The function to handle calculation requests.
   */
  @Override
  public void addCalculateObserver(Function<String, Float> f) {
    this.calculateObserver = f;
  }

  /**
   * Adds a method (observer) for handling type changes (infix/RPN).
   *
   * @param c The consumer to handle type change requests.
   */
  @Override
  public void addTypeObserver(Consumer<Boolean> c) {
    this.typeObserver = c;
  }

  /**
   * Retrieves the current expression.
   *
   * @return The current expression input by the user.
   */
  @Override
  public String getExpression() {
    return currentExpression;
  }

  /**
   * Sets the current expression.
   *
   * @param expression The expression to set.
   */
  public void setExpression(String expression) {
    this.currentExpression = expression;
  }

  /**
   * Sets the answer to be displayed.
   *
   * @param a The answer to display.
   */
  @Override
  public void setAnswer(String a) {
    this.answerDisplayed = a;
  }

  /**
   * Retrieves the answer displayed.
   *
   * @return The answer displayed to the user.
   */
  public String getAnswerDisplayed() {
    return answerDisplayed;
  }

  /**
   * Simulates the start of the view. Typically used to prepare the view for interaction.
   */
  @Override
  public void startView() {
    // No operation for mock.
  }

  /**
   * Simulates a calculation request.
   *
   * @param expression The expression to calculate.
   */
  public void simulateCalculation(String expression) {
    setExpression(expression);
    if (calculateObserver != null) {
      Float result = calculateObserver.apply(expression);
      setAnswer(result.toString());
    }
  }

  /**
   * Simulates a type change (infix/RPN).
   *
   * @param type The type to set (true for infix, false for RPN).
   */
  public void simulateTypeChange(boolean type) {
    if (typeObserver != null) {
      isInfix = type;
      typeObserver.accept(type);
    }
  }
}
