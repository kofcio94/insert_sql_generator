package generators.star.store;

import generators.snowflake.country.CountriesJson;
import generators.snowflake.country.Country;
import utils.*;

import java.util.List;

public class StoreGenerator {
    public static int[] primaryKeys;

    private final static int randomAmount = 54590;

    public static String generateInserts() {
        StringBuilder builder = new StringBuilder();

        int randomThreshold = RandomInt.generateRandomInt(1000, 25000);
        int rnd =
                RandomInt.generateRandomInt(
                        randomAmount - randomThreshold,
                        randomAmount + randomThreshold
                );

        primaryKeys = new int[rnd];
        for (int i = 0; i < rnd; i++) {
            int id = i + 1;
            primaryKeys[i] = id;

            String singleInsert = InsertBuilder
                    .buildInsertStatement(
                            TableNames.TABLE_STORE,
                            id,
                            generateRandomString(),
                            generateRandomString(),
                            generateRandomString(),
                            generateRandomString(),
                            getRandomCountry()
                    );

            builder.append(singleInsert);
        }

        return builder.toString();
    }

    private static String generateRandomString() {
        int randomStringLength = RandomInt.generateRandomInt(20, 45);
        return RandomString.generate(randomStringLength);
    }

    public static String getRandomCountry() {
        List<Country> countryList = GsonUtils.<Country>toList(CountriesJson.getCountries(), Country[].class);
        int randomIndex = RandomInt.generateRandomInt(countryList.size() - 1);
        return "'" + countryList.get(randomIndex).getName() + "'";
    }
}
