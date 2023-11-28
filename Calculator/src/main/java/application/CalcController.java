package application;

/**
 * The CalcController class acts as a controller in the MVC architecture.
 * It mediates interactions between the view (user interface) and the model (calculator logic).
 * This class handles user inputs, processes them, and updates the view accordingly.
 *
 * @author zlac241
 */
public class CalcController {
  private CalcModel myModel;        // Model component for calculator logic
  private ViewInterface myView;     // View component for user interface
  private boolean isInFix;          // Flag to determine the type of notation used

  /**
   * Processes a calculation request from the view.
   * Passes the expression to the model for evaluation and handles any invalid expressions.
   *
   * @param expression The mathematical expression to be evaluated.
   * @return The result of the calculation or NaN if an invalid expression is encountered.
   */
  public float handleCalculation(String expression) {
    try {
      return myModel.evaluate(expression);
    } catch (InvalidExpression e) {
      return Float.NaN; // Return NaN when the expression is invalid
    }
  }

  /**
   * Handles changes in the type of notation (e.g., infix to postfix) used for calculations.
   * This method can be expanded to update the model or view based on the notation type.
   */
  public void handleTypeChange() {
    // Implementation can be added to handle the type change
  }

  /**
   * Constructor for CalcController.
   * Initializes the controller with a model and a view, and sets up the necessary observers.
   *
   * @param model The CalcModel instance to be used for calculation logic.
   * @param view  The ViewInterface instance representing the user interface.
   */
  CalcController(CalcModel model, ViewInterface view) {
    myModel = model;
    myView = view;
    view.addCalculateObserver(
        this::handleCalculation); // Setting up observer for calculation requests
  }
}
