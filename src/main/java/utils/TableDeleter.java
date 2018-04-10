package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class TableDeleter {

    public static void insertDeleteClause(File outputFile) throws IOException {
        for (String table : TableNames.TABLES) {
            String deleteClause = "DELETE FROM " + table + ";\n";

            Files.write(outputFile.toPath(), deleteClause.getBytes(), StandardOpenOption.APPEND);
        }

    }
}
