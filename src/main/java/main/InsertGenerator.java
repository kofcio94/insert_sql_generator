package main;

import generators.city.CityGenerator;
import generators.country.CountryGenerator;
import generators.employee.EmployeeGenerator;
import generators.month.MonthGenerator;
import generators.product.ProductGenerator;
import generators.productType.ProductTypeGenerator;
import generators.region.RegionGenerator;
import generators.sales.SalesGenerator;
import generators.salesType.SalesTypeGenerator;
import generators.state.StatesGenerator;
import generators.store.StoreGenerator;
import generators.time.TimeGenerator;
import generators.week.WeekGenerator;
import generators.weekDay.WeekDayGenerator;
import generators.year.YearGenerator;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class InsertGenerator {

    public static void main(String... args) throws Exception {
        File outputFile = new File("insert.sql");
        if (outputFile.exists()) {
            outputFile.delete();
        }

        outputFile.createNewFile();
        createSampleData(outputFile);

    }

    private static void createSampleData(File outputFile) throws IOException {
        long startTime = System.currentTimeMillis();
        int recordsGenerated = 0;

        String countriesInsert = CountryGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(countriesInsert, "\n");
        System.out.println(countriesInsert);
        Files.write(outputFile.toPath(), countriesInsert.getBytes(), StandardOpenOption.APPEND);

        String statesInsert = StatesGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(statesInsert, "\n");
        System.out.println(statesInsert);
        Files.write(outputFile.toPath(), statesInsert.getBytes(), StandardOpenOption.APPEND);

        String regionInsert = RegionGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(regionInsert, "\n");
        System.out.println(regionInsert);
        Files.write(outputFile.toPath(), regionInsert.getBytes(), StandardOpenOption.APPEND);

        String cityInsert = CityGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(cityInsert, "\n");
        System.out.println(cityInsert);
        Files.write(outputFile.toPath(), cityInsert.getBytes(), StandardOpenOption.APPEND);

        String storeInsert = StoreGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(storeInsert, "\n");
        System.out.println(storeInsert);
        Files.write(outputFile.toPath(), storeInsert.getBytes(), StandardOpenOption.APPEND);

        String salesTypeInsert = SalesTypeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(salesTypeInsert, "\n");
        System.out.println(salesTypeInsert);
        Files.write(outputFile.toPath(), salesTypeInsert.getBytes(), StandardOpenOption.APPEND);

        String employeeInsert = EmployeeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(employeeInsert, "\n");
        System.out.println(employeeInsert);
        Files.write(outputFile.toPath(), employeeInsert.getBytes(), StandardOpenOption.APPEND);

        String productTypeInsert = ProductTypeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(productTypeInsert, "\n");
        System.out.println(productTypeInsert);
        Files.write(outputFile.toPath(), productTypeInsert.getBytes(), StandardOpenOption.APPEND);

        String productInsert = ProductGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(productInsert, "\n");
        System.out.println(productInsert);
        Files.write(outputFile.toPath(), productInsert.getBytes(), StandardOpenOption.APPEND);

        String weekInsert = WeekGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(weekInsert, "\n");
        System.out.println(weekInsert);
        Files.write(outputFile.toPath(), weekInsert.getBytes(), StandardOpenOption.APPEND);

        String monthInsert = MonthGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(monthInsert, "\n");
        System.out.println(monthInsert);
        Files.write(outputFile.toPath(), monthInsert.getBytes(), StandardOpenOption.APPEND);

        String yearInsert = YearGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(yearInsert, "\n");
        System.out.println(yearInsert);
        Files.write(outputFile.toPath(), yearInsert.getBytes(), StandardOpenOption.APPEND);

        String weekdayInsert = WeekDayGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(weekdayInsert, "\n");
        System.out.println(weekdayInsert);
        Files.write(outputFile.toPath(), weekdayInsert.getBytes(), StandardOpenOption.APPEND);

        String timeInsert = TimeGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(timeInsert, "\n");
        System.out.println(timeInsert);
        Files.write(outputFile.toPath(), timeInsert.getBytes(), StandardOpenOption.APPEND);

        String salesInsert = SalesGenerator.generateInserts();
        recordsGenerated += StringUtils.countMatches(salesInsert, "\n");
        System.out.println(salesInsert);
        Files.write(outputFile.toPath(), salesInsert.getBytes(), StandardOpenOption.APPEND);

        System.out.println("records generated : " + recordsGenerated);
        long timePassed = System.currentTimeMillis() - startTime;
        System.out.println("Generation time : " + timePassed + "[ms]");


    }

}
