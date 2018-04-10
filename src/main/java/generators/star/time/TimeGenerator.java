package generators.star.time;

import generators.snowflake.weekDay.WeekDayGenerator;
import utils.InsertBuilder;
import utils.RandomInt;
import utils.TableNames;

import static generators.snowflake.time.TimeGenerator.getRandomDate;

public class TimeGenerator {

    public static int[] primaryKeys;

    private final static int amount = 100000;

    public static String generateInserts() {
        StringBuilder builder = new StringBuilder();

        int randomThreshold = RandomInt.generateRandomInt(10000, 30000);
        int rnd =
                RandomInt.generateRandomInt(
                        amount - randomThreshold,
                        amount + randomThreshold
                );
        primaryKeys = new int[rnd];
        for (int i = 0; i < rnd; i++) {
            int id = i + 1;
            primaryKeys[i] = id;

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_TIME,
                            id,
                            getRandomDate(),
                            RandomInt.generateRandomInt(1, 53),
                            RandomInt.generateRandomInt(1, 12),
                            RandomInt.generateRandomInt(1968, 2018),
                            getRandomWeekDay()
                    );

            builder.append(singleInsert);
        }

        return builder.toString();
    }

    private static String getRandomWeekDay() {
        int randomIndex = RandomInt.generateRandomInt(4);
        return WeekDayGenerator.weekdays[randomIndex];
    }

}
