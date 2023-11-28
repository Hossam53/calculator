package application;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The CalcView class extends the JavaFX Application and implements the ViewInterface.
 * It provides a resizable JavaFX GUI for a calculator, supporting both standard and
 * Reverse Polish Notation (RPN) calculations as part of an MVC architecture.
 * It allows users to input expressions, select the type of calculator, and view results.
 * This class also includes a Singleton pattern for accessing the view instance.
 *
 * @author zlac241
 */
public class CalcView extends Application implements ViewInterface {
  @FXML
  private Button calcButton;

  @FXML
  private ToggleButton infixCalculatorButton;

  @FXML
  private TextField inputField;

  @FXML
  private ToggleButton revPolishCalculatorButton;

  @FXML
  private TextField totalField;

  /**
   * Registers a function as an observer for calculation requests.
   * When the calculate button is pressed, the entered expression is evaluated
   * and the result is displayed.
   *
   * @param f The function to be used for evaluating expressions.
   */
  @Override
  public void addCalculateObserver(Function<String, Float> f) {
    calcButton.setOnAction(event -> totalField.setText(
        String.valueOf(f.apply(inputField.getText()))));
  }

  /**
   * Registers a consumer as an observer for calculator type changes.
   * Allows switching between standard and Reverse Polish Notation modes.
   *
   * @param c The consumer to be notified when the calculator type changes.
   */
  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    infixCalculatorButton.setOnAction(event -> c.accept(OpType.STANDARD));
    revPolishCalculatorButton.setOnAction(event -> c.accept(OpType.REV_POLISH));
  }

  /**
   * Retrieves the mathematical expression entered by the user.
   *
   * @return The expression from the input field.
   */
  @Override
  public String getExpression() {
    return inputField.getText();
  }

  /**
   * Sets the answer in the total field.
   *
   * @param answer The answer to display in the total field.
   */
  @Override
  public void setAnswer(String answer) {
    totalField.setText(answer);
  }

  /**
   * Prepares the view for interaction by enabling the buttons.
   */
  @Override
  public void startView() {
    calcButton.setDisable(false);
    revPolishCalculatorButton.setDisable(false);
    infixCalculatorButton.setDisable(false);
  }

  /**
   * Initializes the JavaFX stage and loads the FXML layout.
   * Sets up the scene and shows the primary stage.
   *
   * @param primaryStage The primary stage for this application.
   * @throws IOException If the FXML file cannot be loaded.
   */

  @Override
  public void start(Stage primaryStage) throws IOException {
    GridPane page = (GridPane) FXMLLoader.load(CalcView.class.getResource("View.fxml"));
    Scene scene = new Scene(page);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("MVC/Observer/fxml");
    primaryStage.show();
  }

  // DO NOT CHANGE ANYTHING BELOW THIS COMMENT
  /////////////////////////////////////////////////////////////////////////////////
  // Block for creating an instance variable for others to use.
  //
  // Make it a JavaFX singleton. Instance is set by the javafx "initialize" method
  private static volatile CalcView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * This is a Singleton View constructed by the JavaaFX Thread and made available through this
   * method.
   *
   * @return the single object representing this view
   */
  public static synchronized CalcView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(CalcView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }
  // End of special block
  /////////////////////////////////////////////////////////////////////////////////

}
