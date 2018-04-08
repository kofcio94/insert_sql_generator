package generators.store;

import generators.city.CityGenerator;
import utils.InsertBuilder;
import utils.TableNames;
import utils.RandomInt;
import utils.RandomString;

public class StoreGenerator {

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();
        primaryKeys = new int[CityGenerator.primaryKeys.length];
        for (int i = 0; i < CityGenerator.primaryKeys.length; i++) {
            int id = i + 1;
            primaryKeys[i] = id;

            int randomStringLength = RandomInt.generateRandomInt(20, 45);
            String randomName = RandomString.generate(randomStringLength);

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_STORE,
                            id,
                            randomName,
                            getRandomForeignKey()
                    );

            returnStatement.append(singleInsert);
        }

        return returnStatement.toString();

    }

    private static int getRandomForeignKey() {
        int randomFK = RandomInt.generateRandomInt(CityGenerator.primaryKeys.length - 1);
        return CityGenerator.primaryKeys[randomFK];
    }
}
