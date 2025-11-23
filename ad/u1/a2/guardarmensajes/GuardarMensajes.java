package guardarmensajes;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class GuardarMensajes {

    public static void main(String[] args) {
        System.out.println("\n=== ESCRITURA DE ARCHIVOS ===");
        System.out.println("Creando carpeta de recursos y escribiendo archivo de ejemplo...");

        // Crear carpeta
        File resourcesDir = new File("Recursos");

        if (!resourcesDir.exists()) {
            boolean dirCreated = resourcesDir.mkdir();
            if (dirCreated) {
                System.out.println("Carpeta creada: " + resourcesDir.getAbsolutePath());
            } else {
                System.out.println("Error creando la carpeta");
                System.exit(1);
            }
        } else {
            System.out.println("La carpeta ya existe");
        }

        // Escribir archivo
        File outputFile = new File(resourcesDir, "ejemplo.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("este es un ejemplo de escritura");
            writer.newLine();
            System.out.println("Archivo escrito exitosamente: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error escribiendo el archivo: " + e.getMessage());
        }

        System.out.println("\n=== DEMOSTRACIÓN COMPLETADA ===");
    }
}