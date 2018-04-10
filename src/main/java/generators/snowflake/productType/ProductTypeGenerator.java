package generators.snowflake.productType;

import utils.InsertBuilder;
import utils.TableNames;
import utils.RandomInt;
import utils.RandomString;

public class ProductTypeGenerator {
    private final static int randomAmount = 200;

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();

        int randomThreshold = RandomInt.generateRandomInt(20, 50);
        int rnd =
                RandomInt.generateRandomInt(
                        randomAmount - randomThreshold,
                        randomAmount + randomThreshold
                );

        primaryKeys = new int[rnd];
        for (int i = 0; i < rnd; i++) {
            int id = i + 1;
            primaryKeys[i] = id;

            int randomStringLength = RandomInt.generateRandomInt(5, 10);
            String randomName = RandomString.generate(randomStringLength);

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_PRODUCT_TYPE,
                            id,
                            randomName
                    );

            returnStatement.append(singleInsert);

        }

        return returnStatement.toString();

    }

}
