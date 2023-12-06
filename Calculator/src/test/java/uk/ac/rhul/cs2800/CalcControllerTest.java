package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import application.CalcController;
import application.CalcModel;
import application.InvalidExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcControllerTest {

  private CalcController controller;
  private MockView mockView;
  private CalcModel model;

  @BeforeEach
  void setUp() {
    model = new CalcModel();
    mockView = new MockView();
    controller = new CalcController(model, mockView);
  }

  @Test
  void testConstructor() {
    assertNotNull(mockView.calculateObserver);
    assertNotNull(mockView.typeObserver);
  }

  @Test
  void handleCalculation() throws InvalidExpression {
    mockView.simulateTypeChange(false);
    String testExpression = "2 2 +";
    mockView.simulateCalculation(testExpression);
    assertEquals("4.0", mockView.getAnswerDisplayed());
  }




  @Test
  void handleTypeChange() throws InvalidExpression {
    mockView.simulateTypeChange(false);
    String rpnExpression = "2 2 +";
    float rpnResult = model.evaluate(rpnExpression);
    assertEquals(4.0f, rpnResult);
  }









}
