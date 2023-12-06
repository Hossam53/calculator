package uk.ac.rhul.cs2800;

import application.ViewInterface;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Mock implementation of the ViewInterface for testing purposes.
 */
public class MockView implements ViewInterface {
  Function<String, Float> calculateObserver;
  Consumer<Boolean> typeObserver;

  private String currentExpression;
  private boolean isInfix = true;


  private String answerDisplayed;

  @Override
  public void addCalculateObserver(Function<String, Float> f) {
    this.calculateObserver = f;
  }

  @Override
  public void addTypeObserver(Consumer<Boolean> c) {
    this.typeObserver = c;
  }

  @Override
  public String getExpression() {
    return currentExpression;
  }

  public void setExpression(String expression) {
    this.currentExpression = expression;
  }

  @Override
  public void setAnswer(String a) {
    this.answerDisplayed = a;
  }

  public String getAnswerDisplayed() {
    return answerDisplayed;
  }

  @Override
  public void startView() {

  }


  public void simulateCalculation(String expression) {
    setExpression(expression);
    if (calculateObserver != null) {
      Float result = calculateObserver.apply(expression);
      setAnswer(result.toString());
    }
  }

  public void simulateTypeChange(boolean type) {
    if (typeObserver != null) {
      isInfix = type;
      typeObserver.accept(type);
    }
  }

}
