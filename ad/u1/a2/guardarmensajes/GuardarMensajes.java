package guardarmensajes;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Console;
import java.util.logging.Logger;

public class GuardarMensajes {
    private static final Logger logger = Logger.getLogger(GuardarMensajes.class.getName());

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            logger.severe("No hay consola disponible");
            System.exit(1);
        }

        console.printf("%n=== ESCRITURA DE ARCHIVOS ===%n");
        console.printf("Creando carpeta de recursos y escribiendo archivo de ejemplo...%n%n");

        // Crear carpeta
        File resourcesDir = new File("Recursos");

        if (!resourcesDir.exists()) {
            boolean dirCreated = resourcesDir.mkdir();
            if (dirCreated) {
                console.printf("Carpeta creada: %s%n", resourcesDir.getAbsolutePath());
            } else {
                console.printf("Error creando la carpeta%n");
                System.exit(1);
            }
        } else {
            console.printf("La carpeta ya existe%n");
        }

        // Escribir archivo
        File outputFile = new File(resourcesDir, "ejemplo.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("este es un ejemplo de escritura");
            writer.newLine();
            console.printf("Archivo escrito exitosamente: %s%n", outputFile.getAbsolutePath());
        } catch (IOException e) {
            console.printf("Error escribiendo el archivo: %s%n", e.getMessage());
        }

        console.printf("%n=== DEMOSTRACIÓN COMPLETADA ===%n");
    }
}