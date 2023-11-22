package uk.ac.rhul.cs2800;

public class RevPolishCalc {

  public float evaluate(String expr) {
    String[] parts = expr.split(" ");
    float operand1 = Float.parseFloat(parts[0]);
    float operand2 = Float.parseFloat(parts[1]);
    char operator = parts[2].charAt(0);

    switch (operator) {
      case '+':
        return operand1 + operand2;
      default:
        return 0;
    }
  }
}




