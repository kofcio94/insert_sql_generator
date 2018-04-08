package generators.time;

import generators.month.MonthGenerator;
import generators.week.WeekGenerator;
import generators.weekDay.WeekDayGenerator;
import generators.year.YearGenerator;
import utils.InsertBuilder;
import utils.TableNames;
import utils.RandomInt;

public class TimeGenerator {

    public static int[] primaryKeys;

    private final static int amount = 100000;

    public static String generateInserts() {
        StringBuilder stringBuilder = new StringBuilder();

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

            String randomDate = getRandomDate();
            int randomWeek = getRandomFKWeek();
            int randomMonth = getRandomFKMonth();
            int randomYear = getRandomFKYear();
            int randomWeekday = getRandomFKWeekDay();

            String single = InsertBuilder.buildInsertStatement(
                    TableNames.TABLE_TIME,
                    id,
                    randomDate,
                    randomWeek,
                    randomMonth,
                    randomYear,
                    randomWeekday
            );

            stringBuilder.append(single);
        }

        return stringBuilder.toString();
    }

    private static String getRandomDate() {
        String randomYear = String.valueOf(RandomInt.generateRandomInt(1968, 2018));
        String randomMonth = String.valueOf(RandomInt.generateRandomInt(1, 12));
        String randomDay = String.valueOf(RandomInt.generateRandomInt(1, 28));

        return "'" + randomYear + "_" + randomMonth + "_" + randomDay + "'";
    }

    private static int getRandomFKWeek() {
        int randomFK = RandomInt.generateRandomInt(WeekGenerator.primaryKeys.length - 1);
        return WeekGenerator.primaryKeys[randomFK];
    }

    private static int getRandomFKMonth() {
        int randomFK = RandomInt.generateRandomInt(MonthGenerator.primaryKeys.length - 1);
        return MonthGenerator.primaryKeys[randomFK];
    }

    private static int getRandomFKYear() {
        int randomFK = RandomInt.generateRandomInt(YearGenerator.primaryKeys.length - 1);
        return YearGenerator.primaryKeys[randomFK];
    }

    private static int getRandomFKWeekDay() {
        int randomFK = RandomInt.generateRandomInt(WeekDayGenerator.primaryKeys.length - 1);
        return WeekDayGenerator.primaryKeys[randomFK];
    }
}
