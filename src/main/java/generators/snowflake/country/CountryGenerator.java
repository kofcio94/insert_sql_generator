package generators.snowflake.country;

import utils.GsonUtils;
import utils.InsertBuilder;
import utils.TableNames;

import java.util.List;

public class CountryGenerator {

    public static int[] primaryKeys;

    public static String generateInserts() {
        StringBuilder returnStatement = new StringBuilder();
        List<Country> countryList = GsonUtils.<Country>toList(CountriesJson.getCountries(), Country[].class);
        primaryKeys = new int[countryList.size()];
        for (int i = 0; i < countryList.size(); i++) {
            int id = i + 1;
            primaryKeys[i] = id;
            Country country = countryList.get(i);
            String singleInsertStatement =
                    InsertBuilder
                            .buildInsertStatement(
                                    TableNames.TABLE_COUNTRY,
                                    id,
                                    "'" + country.getName() + "'"
                            );
            returnStatement.append(singleInsertStatement);
        }

        return returnStatement.toString();

    }
}
