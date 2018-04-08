package generators.employee;

import generators.store.StoreGenerator;
import utils.InsertBuilder;
import utils.TableNames;
import utils.RandomInt;
import utils.RandomString;

public class EmployeeGenerator {

    public static int[] primaryKeys;

    public static String generateInserts() {
        int randomAmount = StoreGenerator.primaryKeys.length * 2;

        StringBuilder returnStatement = new StringBuilder();
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


            returnStatement.append(singleInsert);
        }

        return returnStatement.toString();
    }

}
