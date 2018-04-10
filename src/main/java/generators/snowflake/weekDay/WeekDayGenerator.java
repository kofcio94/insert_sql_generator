package generators.snowflake.weekDay;

import utils.InsertBuilder;
import utils.TableNames;

public class WeekDayGenerator {
    public final static String[] weekdays = {
            "'Monday'",
            "'Tuesdays'",
            "'Wednesday'",
            "'Thursday'",
            "'Friday'"
    };

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder stringBuilder = new StringBuilder();

        int id = 1;
        primaryKeys = new int[weekdays.length];
        for (String weekday : weekdays) {
            primaryKeys[id - 1] = id;
            String singleInsert = InsertBuilder.buildInsertStatement(TableNames.TABLE_WEEKDAY, id, weekday);
            stringBuilder.append(singleInsert);
            id++;
        }

        return stringBuilder.toString();
    }

}
