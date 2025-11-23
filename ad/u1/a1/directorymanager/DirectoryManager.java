package directorymanager;

import java.io.File;
import java.io.Console;
import java.util.logging.Logger;

public class DirectoryManager {
    private static final Logger logger = Logger.getLogger(DirectoryManager.class.getName());

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            logger.severe("No console available");
            System.exit(1);
        }

        console.printf("%n=== PROJECT SETUP ===%n");
        console.printf("Creating directories...%n%n");

        // Array with directory names
        String[] directories = {
            "ProjectDocs",
            "ImageResources",
            "ConfigFiles"
        };

        int created = 0;
        int existing = 0;
        int errors = 0;

        // Create each directory
        for (String dirName : directories) {
            File dir = new File(dirName);

            if (dir.exists()) {
                console.printf("Directory exists: %s%n", dirName);
                existing++;
            } else {
                boolean success = dir.mkdir();

                if (success) {
                    console.printf("Created: %s%n", dirName);
                    created++;
                } else {
                    console.printf("Error creating directory: %s%n", dirName);
                    errors++;
                }
            }
        }

        // Summary
        console.printf("%n=== SUMMARY ===%n");
        console.printf("Created: %d%n", created);
        console.printf("Existing: %d%n", existing);
        console.printf("Errors: %d%n", errors);
        console.printf("Total: %d%n", directories.length);
    }
}