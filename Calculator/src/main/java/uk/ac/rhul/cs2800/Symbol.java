package uk.ac.rhul.cs2800;

/**
 * Represents various arithmetic and grouping symbols.
 * This enum provides constants for different symbols used in arithmetic operations
 * and expressions. Each symbol also has a string representation which can be retrieved.
 *
 * @author zlac241
 */
public enum Symbol {

  // Arithmetic and grouping symbols
  /** Represents the left bracket symbol "(". */
  LEFT_BRACKET("("),

  /** Represents the right bracket symbol ")". */
  RIGHT_BRACKET(")"),

  /** Represents the multiplication symbol "*". */
  TIME("*"),

  /** Represents the division symbol "/". */
  DIVIDE("/"),

  /** Represents the addition symbol "+". */
  PLUS("+"),

  /** Represents the subtraction symbol "-". */
  MINUS("-"),

  /**
   * Represents an invalid symbol "?".
   * Typically used to indicate symbols that are not recognised or supported.
   */
  INVALID("?");

  // The string representation of the symbol
  private final String symbol;

  /**
   * Constructs a new {@code Symbol} with the provided string representation.
   * @param symbol The string representation of the symbol.
   */
  Symbol(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Retrieves the string representation of the symbol.
   * @return The string representation of the symbol.
   */
  @Override
  public String toString() {
    return symbol;
  }
}
