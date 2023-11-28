// Entry.java

package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * The Entry class represents an entry that can hold a value of
 * different types: a number, a symbol, or a string. Depending on the
 * constructor used, the type of the entry is set, and this type must be
 * respected when accessing its value.
 *
 * @author zlac241
 */
public class Entry {

  // Attributes for different types of values an Entry can hold
  private float number;
  private Symbol other;
  private String str;

  // The type of this Entry, e.g., NUMBER, SYMBOL, or STRING.
  private final Type type;

  /**
   * Returns a string representation of the object.
   * This string representation includes the values of the 'number',
   * 'other', 'str', and 'type' attributes.
   * @return a string representation of the object.
   */


  @Override
  public String toString() {
    return "Entry [number=" + number + ", other=" + other + ", str=" + str + ", type="
        +
        type.name() + "]";
  }


  /**
   * Constructs a new Entry class with a number type.
   *
   * @param value the numeric value for this entry.
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Constructs a new Entry class with a symbol type.
   *
   * @param which the symbol value for this entry.
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Constructs a new Entry class with a string type.
   *
   * @param str the string value for this entry.
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Retrieves the number value of this entry.
   *
   * @return the number value.
   * @throws BadType if this entry does not represent a number.
   */
  public float getValue() throws BadType {
    checkType(Type.NUMBER);
    return number;
  }

  /**
   * Retrieves the symbol value of this entry.
   *
   * @return the symbol value.
   * @throws BadType if this entry does not represent a symbol.
   */
  public Symbol getSymbol() throws BadType {
    checkType(Type.SYMBOL);
    return other;
  }

  /**
   * Checks for equality between this entry and another object.
   *
   * @param o the object to compare with.
   * @return true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entry entry = (Entry) o;
    return Float.compare(entry.number, number) == 0 && other == entry.other
        &&
        Objects.equals(str, entry.str)
        && type == entry.type;
  }

  /**
   * Computes the hash code for this entry.
   *
   * @return the hash code value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  /**
   * Retrieves the string value of this entry.
   *
   * @return the string value.
   * @throws BadType if this entry does not represent a string.
   */
  public String getString() throws BadType {
    checkType(Type.STRING);
    return str;
  }

  /**
   * Retrieves the type of this entry.
   *
   * @return the type value.
   */
  public Type getType() {
    return type;
  }

  /**
   * Private utility method to check if the type of this entry matches the
   * expected type.
   *
   * @param expectedType the expected type.
   * @throws BadType if the types don't match.
   */
  private void checkType(Type expectedType) throws BadType {
    if (type != expectedType) {
      throw new BadType("Bad type: Expected " + expectedType + " but found " + type);
    }
  }
}
