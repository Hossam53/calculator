package uk.ac.rhul.cs2800;

import org.junit.jupiter.api.Test;

import uk.ac.rhul.cs2800.BadType;
import uk.ac.rhul.cs2800.Entry;
import uk.ac.rhul.cs2800.Symbol;
import uk.ac.rhul.cs2800.Type;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {

  // Test 1: Ensure that getValue returns the correct number.
  @Test
  void testGetValueWithNumber() throws BadType {
    Entry entry = new Entry(5.0f);
    assertEquals(5.0f, entry.getValue(), "The value should be 5.0f");
  }

  // Test 2: Ensure that getSymbol returns the correct symbol.
  @Test
  void testGetSymbolWithSymbol() throws BadType {
    Entry entry = new Entry(Symbol.PLUS);
    assertEquals(Symbol.PLUS, entry.getSymbol(), "The symbol should be PLUS");
  }

  // Test 3: Ensure that getString returns the correct string.
  @Test
  void testGetStringWithString() throws BadType {
    Entry entry = new Entry("Test");
    assertEquals("Test", entry.getString(), "The string should be 'Test'");
  }

  // Test 4: Ensure that calling getValue on a symbol throws a BadType exception.
  @Test
  void testBadTypeExceptionForValue() {
    Entry entry = new Entry(Symbol.PLUS);
    assertThrows(BadType.class, entry::getValue, "Should throw BadType exception for wrong type");
  }

  // Test 5: Ensure that calling getSymbol on a number throws a BadType exception.
  @Test
  void testBadTypeExceptionForSymbol() {
    Entry entry = new Entry(5.0f);
    assertThrows(BadType.class, entry::getSymbol, "Should throw BadType exception for wrong type");
  }

  // Test 6: Ensure that calling getString on a number throws a BadType exception.
  @Test
  void testBadTypeExceptionForString() {
    Entry entry = new Entry(5.0f);
    assertThrows(BadType.class, entry::getString, "Should throw BadType exception for wrong type");
  }

  // Test 7: Ensure getType returns 'NUMBER' for numeric entries.
  @Test
  void testGetTypeWithNumber() {
    Entry entry = new Entry(5.0f);
    assertEquals(Type.NUMBER, entry.getType(), "The type should be NUMBER");
  }

  // Test 8: Ensure getType returns 'SYMBOL' for symbol entries.
  @Test
  void testGetTypeWithSymbol() {
    Entry entry = new Entry(Symbol.PLUS);
    assertEquals(Type.SYMBOL, entry.getType(), "The type should be SYMBOL");
  }

  // Test 9: Ensure getType returns 'STRING' for string entries.
  @Test
  void testGetTypeWithString() {
    Entry entry = new Entry("Test String");
    assertEquals(Type.STRING, entry.getType(), "The type should be STRING");
  }

  // Test 10: Validate that getSymbol returns the expected symbol for each possible symbol entry.
  @Test
  void testGetSymbolWithDifferentSymbols() throws BadType {
    for (Symbol symbol : Symbol.values()) {
      Entry entry = new Entry(symbol);
      assertEquals(symbol, entry.getSymbol(), "The symbol should be " + symbol);
    }
  }

  // Test 11: Check equality for two entries containing the same numeric value.
  @Test
  void testEqualsWithSameNumberValues() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(5.0f);
    assertEquals(entry1, entry2, "Entries with the same number values should be equal");
  }

  // Test 12: Check equality for two entries containing the same symbol.
  @Test
  void testEqualsWithSameSymbols() {
    Entry entry1 = new Entry(Symbol.PLUS);
    Entry entry2 = new Entry(Symbol.PLUS);
    assertEquals(entry1, entry2, "Entries with the same symbols should be equal");
  }

  // Test 13: Check equality for two entries containing the same string.
  @Test
  void testEqualsWithSameStrings() {
    Entry entry1 = new Entry("Same");
    Entry entry2 = new Entry("Same");
    assertEquals(entry1, entry2, "Entries with the same strings should be equal");
  }

  // Test 14: Validate that two entries with the same numeric value produce the same hash code.
  @Test
  void testHashCodeForSameNumberValues() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(5.0f);
    assertEquals(entry1.hashCode(), entry2.hashCode(), "Entries with the same number value should have the same hash codes");
  }

  // Test 15: Validate that two entries with the same symbol produce the same hash code.
  @Test
  void testHashCodeForSameSymbols() {
    Entry entry1 = new Entry(Symbol.MINUS);
    Entry entry2 = new Entry(Symbol.MINUS);
    assertEquals(entry1.hashCode(), entry2.hashCode(), "Entries with the same symbol should have the same hash codes");
  }

  // Test 16: Validate that the equals method returns false when compared with a null object.
  @Test
  void testEqualsWithNull() {
    Entry entry = new Entry(7.0f);
    assertNotEquals(entry, null, "Equals should return false when the provided object is null");
  }
  // Test 17: Check non-equality for two entries containing different numeric values.
  @Test
  void testNotEqualsWithDifferentNumberValues() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(6.0f);
    assertNotEquals(entry1, entry2, "Entries with different number values should not be equal");
  }

  // Test 18: Check non-equality for two entries containing different symbols.
  @Test
  void testNotEqualsWithDifferentSymbols() {
    Entry entry1 = new Entry(Symbol.PLUS);
    Entry entry2 = new Entry(Symbol.MINUS);
    assertNotEquals(entry1, entry2, "Entries with different symbols should not be equal");
  }

  // Test 19: Check non-equality for two entries containing different strings.
  @Test
  void testNotEqualsWithDifferentStrings() {
    Entry entry1 = new Entry("Stack");
    Entry entry2 = new Entry("Entry");
    assertNotEquals(entry1, entry2, "Entries with different strings should not be equal");
  }

  // Test 20: Validate that two entries with different numeric values produce different hash codes.
  @Test
  void testHashCodeForDifferentNumberValues() {
    Entry entry1 = new Entry(5.0f);
    Entry entry2 = new Entry(6.0f);
    assertNotEquals(entry1.hashCode(), entry2.hashCode(), "Entries with different number values should have different hash codes");
  }

  // Test 21: Validate that two entries with different symbols produce different hash codes.
  @Test
  void testHashCodeForDifferentSymbols() {
    Entry entry1 = new Entry(Symbol.PLUS);
    Entry entry2 = new Entry(Symbol.MINUS);
    assertNotEquals(entry1.hashCode(), entry2.hashCode(), "Entries with different symbols should have different hash codes");
  }
  // Test 22: Validate the toString method for an Entry constructed with a number.
  @Test
  void testToStringWithNumber() {
    Entry entry = new Entry(5.0f);
    String expectedOutput = "Entry [number=5.0, other=null, str=null, type=NUMBER]";
    assertEquals(expectedOutput, entry.toString(), "The toString representation should match the expected output for number");
  }
  // Test 23: Validate the toString method for an Entry constructed with a string.
  @Test
  void testToStringWithString() {
    Entry entry = new Entry("TestString");
    String expectedOutput = "Entry [number=0.0, other=null, str=TestString, type=STRING]";
    assertEquals(expectedOutput, entry.toString(), "The toString representation should match the expected output for string");
  }

  





}
