package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import uk.ac.rhul.cs2800.Type;

class TypeTest {

  // Test 1: Ensure the string representations of each Type enum are correctly retrieved.
  @Test
  void testTypes() {
    // Check the string representation for Type.STRING
    assertEquals("string", Type.STRING.toString());

    // Check the string representation for Type.NUMBER
    assertEquals("number", Type.NUMBER.toString());

    // Check the string representation for Type.SYMBOL
    assertEquals("symbol", Type.SYMBOL.toString());

    // Check the string representation for Type.INVALID
    assertEquals("invalid", Type.INVALID.toString());
  }

}
