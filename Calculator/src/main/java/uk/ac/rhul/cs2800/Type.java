
package uk.ac.rhul.cs2800;

/**
 * Represents various types of data or input.
 * This enum provides constants for different types of data or input.
 * It's mainly used to categorise and distinguish between the different data types
 * in the context of the calculator application.
 *
 * @author zlac241
 */
public enum Type {

  /** Represents a textual data type, typically strings. */
  STRING("string"),

  /** Represents a numerical data type. */
  NUMBER("number"),

  /** Represents symbolic data types, like operators or punctuation. */
  SYMBOL("symbol"),

  /**
   * Represents an invalid data type.
   * This is typically used for unrecognised or unsupported data types.
   */
  INVALID("invalid");

  // The string representation of the type
  private final String value;

  /**
   * Constructs a new {@code Type} with the provided string representation.
   * @param value The string representation of the type.
   */
  Type(String value) {
    this.value = value;
  }

  /**
   * Retrieves the string representation of the type.
   * @return The string representation of the type.
   */
  @Override
  public String toString() {
    return value;
  }
}
