package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise32 {

    public static void main(String[] args) {
        Exercise32 exercise = new Exercise32();
        String textToSave = exercise.generateStringToSave(null);
        exercise.printToFile(textToSave);

    }

    public static String generateStringToSave(String string) {
        if (string != null) {
            return string;
        }
        return generateUserInputToSave();
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        String filePath = "src/main/resources/data.txt";
        try {
            Files.createDirectories(Paths.get("src/main/resources"));
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(string);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }


}
