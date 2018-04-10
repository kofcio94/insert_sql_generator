package main;

import generators.star.sales.SalesGenerator;
import generators.star.salesType.SalesTypeGenerator;
import generators.star.employee.EmployeeGenerator;
import generators.star.product.ProductGenerator;
import generators.star.store.StoreGenerator;
import generators.star.time.TimeGenerator;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class StarInsertGenerator {
    public static void main(String... args) throws IOException {
        File outputFile = new File("star_insert.sql");
        if (outputFile.exists()) {
            outputFile.delete();
        }

        outputFile.createNewFile();
        createSampleData(outputFile);
    }

    private static void createSampleData(File outputFile) throws IOException {

        System.out.println("\nStarted generating star...");

        long startTime = System.currentTimeMillis();
        int recordsGenerated = 0;

        String storeInsert = StoreGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(storeInsert, "\n");
        Files.write(outputFile.toPath(), storeInsert.getBytes(), StandardOpenOption.APPEND);

        String timeInsert = TimeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(timeInsert, "\n");
        Files.write(outputFile.toPath(), timeInsert.getBytes(), StandardOpenOption.APPEND);

        String productInsert = ProductGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(productInsert, "\n");
        Files.write(outputFile.toPath(), productInsert.getBytes(), StandardOpenOption.APPEND);

        String employeeInsert = EmployeeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(employeeInsert, "\n");
        Files.write(outputFile.toPath(), employeeInsert.getBytes(), StandardOpenOption.APPEND);

        String salesTypeInsert = SalesTypeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(salesTypeInsert, "\n");
        Files.write(outputFile.toPath(), salesTypeInsert.getBytes(), StandardOpenOption.APPEND);

        String salesInsert = SalesGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(salesInsert, "\n");
        Files.write(outputFile.toPath(), salesInsert.getBytes(), StandardOpenOption.APPEND);

        System.out.println("records generated : " + recordsGenerated);
        long timePassed = System.currentTimeMillis() - startTime;
        System.out.println("Generation time : " + timePassed + "[ms]");
    }
}
