package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import uk.ac.rhul.cs2800.Symbol;

class SymbolTest {

  // Test 1: Validate that the Symbol enum values correctly correspond to their string representations
  @Test
  void testSymbol() {
    // Test 1.1: Check if LEFT_BRACKET symbol is represented as "("
    assertEquals("(", Symbol.LEFT_BRACKET.toString());

    // Test 1.2: Check if RIGHT_BRACKET symbol is represented as ")"
    assertEquals(")", Symbol.RIGHT_BRACKET.toString());

    // Test 1.3: Check if TIME symbol is represented as "*"
    assertEquals("*", Symbol.TIME.toString());

    // Test 1.4: Check if DIVIDE symbol is represented as "/"
    assertEquals("/", Symbol.DIVIDE.toString());

    // Test 1.5: Check if PLUS symbol is represented as "+"
    assertEquals("+", Symbol.PLUS.toString());

    // Test 1.6: Check if MINUS symbol is represented as "-"
    assertEquals("-", Symbol.MINUS.toString());

    // Test 1.7: Check if INVALID symbol is represented as "?"
    assertEquals("?", Symbol.INVALID.toString());
  }
}
