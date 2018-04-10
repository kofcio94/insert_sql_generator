package generators.snowflake.product;

import generators.snowflake.productType.ProductTypeGenerator;
import utils.InsertBuilder;
import utils.TableNames;
import utils.RandomInt;
import utils.RandomString;

public class ProductGenerator {


    private final static int randomAmount = 20000;

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();

        int randomThreshold = RandomInt.generateRandomInt(1, 5000);
        int rnd =
                RandomInt.generateRandomInt(
                        randomAmount - randomThreshold,
                        randomAmount + randomThreshold
                );

        primaryKeys = new int[rnd];
        for (int i = 0; i < rnd; i++) {
            int id = i + 1;
            primaryKeys[i] = id;

            int randomStringLength = RandomInt.generateRandomInt(5, 40);
            String randomName = RandomString.generate(randomStringLength);

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_PRODUCT,
                            id,
                            randomName,
                            getRandomForeignKey()
                    );

            returnStatement.append(singleInsert);

        }

        return returnStatement.toString();

    }

    private static int getRandomForeignKey() {
        int randomFK = RandomInt.generateRandomInt(ProductTypeGenerator.primaryKeys.length - 1);
        return ProductTypeGenerator.primaryKeys[randomFK];
    }
}
