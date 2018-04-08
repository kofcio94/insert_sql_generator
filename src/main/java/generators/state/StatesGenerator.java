package generators.state;

import generators.country.CountryGenerator;
import utils.InsertBuilder;
import utils.TableNames;
import utils.RandomInt;
import utils.RandomString;

public class StatesGenerator {

    private final static int randomAmount = 5459;

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();

        int randomThreshold = RandomInt.generateRandomInt(100, 1000);
        int rnd =
                RandomInt.generateRandomInt(
                        randomAmount - randomThreshold,
                        randomAmount + randomThreshold
                );

        primaryKeys = new int[rnd];
        for (int i = 0; i < rnd; i++) {
            int id = i + 1;
            primaryKeys[i] = id;

            int randomStringLength = RandomInt.generateRandomInt(5, 15);
            String randomName = RandomString.generate(randomStringLength);

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_STATE,
                            id,
                            randomName,
                            getRandomForeignKey()
                    );

            returnStatement.append(singleInsert);

        }

        return returnStatement.toString();

    }

    private static int getRandomForeignKey() {
        int randomFK = RandomInt.generateRandomInt(CountryGenerator.primaryKeys.length - 1);
        return CountryGenerator.primaryKeys[randomFK];
    }
}
