package utils;

public class InsertBuilder {

    public static String buildInsertStatement(String tableName, Object... values) {
        StringBuilder insert = new StringBuilder("INSERT INTO " + tableName + " VALUES (");

        for (Object value : values) {
            insert.append(value).append(",");
        }

        insert = new StringBuilder(insert.substring(0, insert.length() - 1));
        insert.append(");\n");

        return insert.toString();

    }
}
