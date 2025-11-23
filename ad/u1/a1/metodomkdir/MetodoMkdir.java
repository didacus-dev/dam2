package metodomkdir;

import java.io.File;

public class MetodoMkdir {

    public static void main(String[] args) {
        System.out.println("\n=== CONFIGURACIÓN DEL PROYECTO ===");
        System.out.println("Creando directorios...\n");

        // Array con nombres de directorios
        String[] directorios = {
                "DocumentosProyecto",
                "RecursosImagen",
                "ArchivosConfiguracion"
        };

        int creados = 0;
        int existentes = 0;
        int errores = 0;

        // Crear cada directorio
        for (String nombreDir : directorios) {
            File directorio = new File(nombreDir);
            if (directorio.exists()) {
                System.out.println("El directorio ya existe: " + nombreDir);
                existentes++;
            } else {
                boolean exito = directorio.mkdir();
                if (exito) {
                    System.out.println("Creado: " + nombreDir);
                    creados++;
                } else {
                    System.out.println("Error creando el directorio: " + nombreDir);
                    errores++;
                }
            }
        }

        // Resumen
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Creados: " + creados);
        System.out.println("Existentes: " + existentes);
        System.out.println("Errores: " + errores);
        System.out.println("Total: " + directorios.length);
    }
}