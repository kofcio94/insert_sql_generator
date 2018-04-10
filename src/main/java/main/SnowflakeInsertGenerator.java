package main;

import generators.snowflake.city.CityGenerator;
import generators.snowflake.country.CountryGenerator;
import generators.snowflake.employee.EmployeeGenerator;
import generators.snowflake.month.MonthGenerator;
import generators.snowflake.product.ProductGenerator;
import generators.snowflake.productType.ProductTypeGenerator;
import generators.snowflake.region.RegionGenerator;
import generators.snowflake.sales.SalesGenerator;
import generators.snowflake.salesType.SalesTypeGenerator;
import generators.snowflake.state.StatesGenerator;
import generators.snowflake.store.StoreGenerator;
import generators.snowflake.time.TimeGenerator;
import generators.snowflake.week.WeekGenerator;
import generators.snowflake.weekDay.WeekDayGenerator;
import generators.snowflake.year.YearGenerator;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static utils.TableDeleter.insertDeleteClause;

public class SnowflakeInsertGenerator {

    public static void main(String... args) throws Exception {
        File outputFile = new File("snowflake_insert.sql");
        if (outputFile.exists()) {
            outputFile.delete();
        }

        outputFile.createNewFile();
        createSampleData(outputFile);
    }

    private static void createSampleData(File outputFile) throws IOException {

        System.out.println("\nStarted generating Snowflake...");

        long startTime = System.currentTimeMillis();
        int recordsGenerated = 0;

        insertDeleteClause(outputFile);

        String countriesInsert = CountryGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(countriesInsert, "\n");
        Files.write(outputFile.toPath(), countriesInsert.getBytes(), StandardOpenOption.APPEND);

        String statesInsert = StatesGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(statesInsert, "\n");
        Files.write(outputFile.toPath(), statesInsert.getBytes(), StandardOpenOption.APPEND);

        String regionInsert = RegionGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(regionInsert, "\n");
        Files.write(outputFile.toPath(), regionInsert.getBytes(), StandardOpenOption.APPEND);

        String cityInsert = CityGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(cityInsert, "\n");
        Files.write(outputFile.toPath(), cityInsert.getBytes(), StandardOpenOption.APPEND);

        String storeInsert = StoreGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(storeInsert, "\n");
        Files.write(outputFile.toPath(), storeInsert.getBytes(), StandardOpenOption.APPEND);

        String salesTypeInsert = SalesTypeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(salesTypeInsert, "\n");
        Files.write(outputFile.toPath(), salesTypeInsert.getBytes(), StandardOpenOption.APPEND);

        String employeeInsert = EmployeeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(employeeInsert, "\n");
        Files.write(outputFile.toPath(), employeeInsert.getBytes(), StandardOpenOption.APPEND);

        String productTypeInsert = ProductTypeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(productTypeInsert, "\n");
        Files.write(outputFile.toPath(), productTypeInsert.getBytes(), StandardOpenOption.APPEND);

        String productInsert = ProductGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(productInsert, "\n");
        Files.write(outputFile.toPath(), productInsert.getBytes(), StandardOpenOption.APPEND);

        String weekInsert = WeekGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(weekInsert, "\n");
        Files.write(outputFile.toPath(), weekInsert.getBytes(), StandardOpenOption.APPEND);

        String monthInsert = MonthGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(monthInsert, "\n");
        Files.write(outputFile.toPath(), monthInsert.getBytes(), StandardOpenOption.APPEND);

        String yearInsert = YearGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(yearInsert, "\n");
        Files.write(outputFile.toPath(), yearInsert.getBytes(), StandardOpenOption.APPEND);

        String weekdayInsert = WeekDayGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(weekdayInsert, "\n");
        Files.write(outputFile.toPath(), weekdayInsert.getBytes(), StandardOpenOption.APPEND);

        String timeInsert = TimeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(timeInsert, "\n");
        Files.write(outputFile.toPath(), timeInsert.getBytes(), StandardOpenOption.APPEND);

        String salesInsert = SalesGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(salesInsert, "\n");
        Files.write(outputFile.toPath(), salesInsert.getBytes(), StandardOpenOption.APPEND);

        System.out.println("records generated : " + recordsGenerated);
        long timePassed = System.currentTimeMillis() - startTime;
        System.out.println("Generation time : " + timePassed + "[ms]");


    }

}
