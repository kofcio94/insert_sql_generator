package generators.star.sales;

import generators.star.employee.EmployeeGenerator;
import generators.star.product.ProductGenerator;
import generators.star.salesType.SalesTypeGenerator;
import generators.star.store.StoreGenerator;
import generators.star.time.TimeGenerator;
import utils.InsertBuilder;
import utils.RandomInt;
import utils.TableNames;

public class SalesGenerator {

    public static String generateInserts() {
        StringBuilder stringBuilder = new StringBuilder();

        int amount = RandomInt.generateRandomInt(280000, 300000);

        int randomThreshold = RandomInt.generateRandomInt(10000, 30000);
        int rnd =
                RandomInt.generateRandomInt(
                        amount - randomThreshold,
                        amount + randomThreshold
                );

        for (int i = 0; i < rnd; i++) {
            int productId = getFKProductId();
            int timeId = getFKTimeId();
            int storeId = getFKStoreId();
            int employeeId = getFKEmployeeId();
            int salesTypeId = getFKSalesTypeId();
            int price = RandomInt.generateRandomInt(1, 1000000);
            int quantity = RandomInt.generateRandomInt(1, 1000);

            String singleInsert = InsertBuilder.buildInsertStatement(
                    TableNames.TABLE_SALES,
                    productId,
                    timeId,
                    storeId,
                    employeeId,
                    salesTypeId,
                    price,
                    quantity
            );

            stringBuilder.append(singleInsert);
        }

        return stringBuilder.toString();
    }

    private static int getFKSalesTypeId() {
        int randomFK = RandomInt.generateRandomInt(SalesTypeGenerator.primaryKeys.length - 1);
        return SalesTypeGenerator.primaryKeys[randomFK];
    }

    private static int getFKEmployeeId() {
        int randomFK = RandomInt.generateRandomInt(EmployeeGenerator.primaryKeys.length - 1);
        return EmployeeGenerator.primaryKeys[randomFK];
    }

    private static int getFKStoreId() {
        int randomFK = RandomInt.generateRandomInt(StoreGenerator.primaryKeys.length - 1);
        return StoreGenerator.primaryKeys[randomFK];
    }

    private static int getFKTimeId() {
        int randomFK = RandomInt.generateRandomInt(TimeGenerator.primaryKeys.length - 1);
        return TimeGenerator.primaryKeys[randomFK];
    }

    private static int getFKProductId() {
        int randomFK = RandomInt.generateRandomInt(ProductGenerator.primaryKeys.length - 1);
        return ProductGenerator.primaryKeys[randomFK];
    }

}
