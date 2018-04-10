package generators.star.employee;

import generators.star.store.StoreGenerator;
import utils.InsertBuilder;
import utils.RandomInt;
import utils.RandomString;
import utils.TableNames;

public class EmployeeGenerator {

    public static int[] primaryKeys;

    public static String generateInserts() {
        int randomAmount = StoreGenerator.primaryKeys.length * 2;

        StringBuilder stringBuilder = new StringBuilder();
        primaryKeys = new int[randomAmount];

        for (int i = 0; i < randomAmount; i++) {
            int id = i + 1;

            primaryKeys[i] = id;

            int randomStringLength = RandomInt.generateRandomInt(4, 10);
            String randomName = RandomString.generate(randomStringLength);
            String randomSurname = RandomString.generate(randomStringLength + 2);

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_EMPLOYEE,
                            id,
                            randomName,
                            randomSurname,
                            RandomInt.generateRandomInt(1950, 2000)
                    );

            stringBuilder.append(singleInsert);
        }

        return stringBuilder.toString();
    }
}
