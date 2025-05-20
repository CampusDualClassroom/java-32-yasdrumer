package com.campusdual.classroom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise32Test {

    @Test
    @DisplayName("Check if the string passed by parameter is the same that the return string")
    void testReturnSameStringPassedByParameter() {
        String string = Exercise32.generateStringToSave("This is a\nmulti-line string.");
        assertEquals("This is a\nmulti-line string.", string, "Return string does not match.");
    }

    @Test
    @DisplayName("Check if the string passed by parameter is the same string saved in file")
    void testSavedFileContainsString() {
        String string = Exercise32.generateStringToSave("This is a\nmulti-line string\nto check\nmulti-line string\nsaved file.");
        Exercise32.printToFile(string);
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                assertTrue(string.contains(line), "Original string not contains saved line");
                string = string.substring(string.indexOf(line) + line.length(), string.length());
            }
            assertTrue(string.isBlank(), "Saved file not contains all data from original string.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}