package util;

import static util.DatabaseContants.*;

public enum Database {
    MYSQL(MYSQL_DRIVER, MYSQL_URL),
    POSTGRESQL(POSTGRESQL_DRIVER, POSTGRESQL_URL),
    ORACLE(ORACLE_DRIVER, ORACLE_URL),
    MSSQL(MSSQL_DRIVER, MSSQL_URL);

    public final String databaseDriver;
    public final String databaseUrl;

    Database(String databaseDriver, String databaseUrl) {
        this.databaseDriver = databaseDriver;
        this.databaseUrl = databaseUrl;
    }
}
