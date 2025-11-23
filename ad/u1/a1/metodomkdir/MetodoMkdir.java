package metodomkdir;

import java.io.File;
import java.io.Console;
import java.util.logging.Logger;

public class MetodoMkdir {
    private static final Logger logger = Logger.getLogger(MetodoMkdir.class.getName());

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            logger.severe("No hay consola disponible");
            System.exit(1);
        }

        console.printf("%n=== CONFIGURACIÓN DEL PROYECTO ===%n");
        console.printf("Creando directorios...%n%n");

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
                console.printf("El directorio ya existe: %s%n", nombreDir);
                existentes++;
            } else {
                boolean exito = directorio.mkdir();
                if (exito) {
                    console.printf("Creado: %s%n", nombreDir);
                    creados++;
                } else {
                    console.printf("Error creando el directorio: %s%n", nombreDir);
                    errores++;
                }
            }
        }

        // Resumen
        console.printf("%n=== RESUMEN ===%n");
        console.printf("Creados: %d%n", creados);
        console.printf("Existentes: %d%n", existentes);
        console.printf("Errores: %d%n", errores);
        console.printf("Total: %d%n", directorios.length);
    }
}