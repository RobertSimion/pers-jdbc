package util;

public abstract class DatabaseContants {
    public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/pers-jdbc";
    public static final String MYSQL_USERNAME = "root";

    public static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    public static final String POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=pers-jdbc";
    public static final String POSTGRESQL_USERNAME = "postgres";

    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String ORACLE_URL = "jdbc:oracle:thin:@//localhost:1521/orcl.mshome.net";
    public static final String ORACLE_USERNAME = "root";

    public static final String MSSQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String MSSQL_URL = "jdbc:sqlserver://RSIMION\\SQLEXPRESS;databaseName=pers-jdbc;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
    public static final String MSSQL_USERNAME = "root";

    public static final String PASSWORD = "root";
    public static final String MAX_POOL = "250";

    private DatabaseContants() {
        //do nothing
    }
}
