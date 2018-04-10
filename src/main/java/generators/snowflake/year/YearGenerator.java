package generators.snowflake.year;

import utils.InsertBuilder;
import utils.TableNames;

public class YearGenerator {
    public static int primaryKeys[];

    private static final int numbersOfYears = 50;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();
        primaryKeys = new int[numbersOfYears];

        int id = 1;
        for (int i = 1968; i < numbersOfYears + 1968; i++) {
            primaryKeys[id -1] = id;

            String singleInsert = InsertBuilder.buildInsertStatement(TableNames.TABLE_YEAR, id, i);
            returnStatement.append(singleInsert);

            id++;
        }

        return returnStatement.toString();
    }
}
