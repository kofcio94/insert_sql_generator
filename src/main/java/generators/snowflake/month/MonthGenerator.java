package generators.snowflake.month;

import utils.InsertBuilder;
import utils.TableNames;

public class MonthGenerator {

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnString = new StringBuilder();
        primaryKeys = new int[12];
        for (int i = 1; i <= 12; i++) {
            String singleInsert = InsertBuilder.buildInsertStatement(TableNames.TABLE_MONTH, i, i);
            returnString.append(singleInsert);
            primaryKeys[i - 1] = i;
        }

        return returnString.toString();
    }
}
