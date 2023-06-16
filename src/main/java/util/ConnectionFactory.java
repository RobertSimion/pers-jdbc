package util;

import conn.DbConnection;

import static util.Database.*;
import static util.DatabaseContants.*;

public class ConnectionFactory {

    public static DbConnection createMySqlConnection() {
        return DbConnection.builder()
                .databaseDriver(MYSQL.databaseDriver)
                .databaseUrl(MYSQL.databaseUrl)
                .username(MYSQL_USERNAME)
                .password(PASSWORD)
                .maxPool(MAX_POOL)
                .build();
    }

    public static DbConnection createMsSQLConnection() {
        return DbConnection.builder()
                .databaseDriver(MSSQL.databaseDriver)
                .databaseUrl(MSSQL.databaseUrl)
                .username(MSSQL_USERNAME)
                .password(PASSWORD)
                .maxPool(MAX_POOL)
                .build();
    }

    public static DbConnection createOracleConnection() {
        return DbConnection.builder()
                .databaseDriver(ORACLE.databaseDriver)
                .databaseUrl(ORACLE.databaseUrl)
                .username(ORACLE_USERNAME)
                .password(PASSWORD)
                .maxPool(MAX_POOL)
                .build();
    }

    public static DbConnection createPostgresqlConnection() {
        return DbConnection.builder()
                .databaseDriver(POSTGRESQL.databaseDriver)
                .databaseUrl(POSTGRESQL.databaseUrl)
                .username(POSTGRESQL_USERNAME)
                .password(PASSWORD)
                .maxPool(MAX_POOL)
                .build();
    }
}
