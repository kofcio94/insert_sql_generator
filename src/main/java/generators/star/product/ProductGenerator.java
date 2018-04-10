package generators.star.product;

import utils.InsertBuilder;
import utils.RandomInt;
import utils.RandomString;
import utils.TableNames;

import java.util.ArrayList;
import java.util.List;

public class ProductGenerator {

    private final static int randomAmount = 20000;

    public static int[] primaryKeys;
    private static List<String> productTypes;

    public static String generateInserts() {
        initTypes();

        StringBuilder stringBuilder = new StringBuilder();

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

            String single = InsertBuilder.buildInsertStatement(
                    TableNames.TABLE_PRODUCT,
                    id,
                    randomName,
                    getRandomType()
            );

            stringBuilder.append(single);

        }

        return stringBuilder.toString();

    }

    private static void initTypes() {
        productTypes = new ArrayList<>();

        int rand = 200;
        int randomThreshold = RandomInt.generateRandomInt(20, 50);
        int rnd =
                RandomInt.generateRandomInt(
                        rand - randomThreshold,
                        rand + randomThreshold
                );

        for (int i = 0; i < rnd; i++) {
            int randomLength = RandomInt.generateRandomInt(5, 40);
            String s = RandomString.generate(randomLength);
            productTypes.add(s);
        }
    }

    private static String getRandomType() {
        int randomIndex = RandomInt.generateRandomInt(productTypes.size() - 1);
        return productTypes.get(randomIndex);
    }
}
