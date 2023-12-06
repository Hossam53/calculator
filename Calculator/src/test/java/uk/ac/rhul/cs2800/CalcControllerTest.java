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
    model = new CalcModel(); // Initialize the model
    mockView = new MockView(); // Initialize the mock view
    controller = new CalcController(model, mockView); // Create a controller with the model and view
  }

  // Test 1: Testing the constructor of the CalcController
  @Test
  void testConstructor() {
    // Verify that the calculateObserver and typeObserver in mockView are not null
    assertNotNull(mockView.calculateObserver, "Calculate observer should be initialized");
    assertNotNull(mockView.typeObserver, "Type observer should be initialized");
  }

  // Test 2: Testing the handleCalculation functionality
  @Test
  void handleCalculation() throws InvalidExpression {
    // Simulate changing the calculation type to RPN (Reverse Polish Notation)
    mockView.simulateTypeChange(false);
    // Test expression in RPN format
    String testExpression = "2 2 +";
    // Simulate the calculation
    mockView.simulateCalculation(testExpression);
    // Verify that the answer displayed by the mock view is as expected
    assertEquals("4.0", mockView.getAnswerDisplayed(), "Result of RPN expression should be 4.0");
  }

  // Test 3: Testing the handleTypeChange functionality
  @Test
  void handleTypeChange() throws InvalidExpression {
    // Simulate changing the calculation type to RPN
    mockView.simulateTypeChange(false);
    // RPN expression for testing
    String rpnExpression = "2 2 +";
    // Evaluate the RPN expression using the model
    float rpnResult = model.evaluate(rpnExpression);
    // Verify that the result of evaluation is as expected
    assertEquals(4.0f, rpnResult, "Result of RPN expression should be 4.0");
  }
}
