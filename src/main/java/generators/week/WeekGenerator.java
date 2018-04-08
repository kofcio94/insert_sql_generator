package generators.week;

import utils.InsertBuilder;
import utils.TableNames;

public class WeekGenerator {

    private final static int weeks = 53;

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();
        primaryKeys = new int[weeks];

        for (int i = 0; i < weeks; i++) {
            int id = i + 1;
            primaryKeys[i] = id;

            String singleInsert = InsertBuilder.buildInsertStatement(TableNames.TABLE_WEEK, id, id);
            returnStatement.append(singleInsert);
        }

        return returnStatement.toString();
    }
}
