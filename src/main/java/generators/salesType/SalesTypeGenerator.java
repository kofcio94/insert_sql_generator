package generators.salesType;

import utils.InsertBuilder;
import utils.TableNames;
import utils.RandomInt;
import utils.RandomString;

public class SalesTypeGenerator {

    private final static int randomAmount = 20;

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();


        primaryKeys = new int[randomAmount];
        for (int i = 0; i < randomAmount; i++) {
            int id = i + 1;

            primaryKeys[i] = id;

            int randomStringLength = RandomInt.generateRandomInt(4, 10);
            String randomName = RandomString.generate(randomStringLength);

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_SALES_TYPE,
                            id,
                            randomName
                    );

            returnStatement.append(singleInsert);

        }

        return returnStatement.toString();
    }
}
