import runner.AdapterRunner;
import util.ConnectionFactory;
import util.Scripts;
import util.TruncateUtil;

import java.sql.SQLException;
import java.util.List;

import static util.ConnectionFactory.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        mysqlBench();

//        oracleBench();

//        msmsqlBench();

//        postgresqlBench();
    }

    private static void postgresqlBench() {

//        AdapterRunner postgresqlAdapterRunner = new AdapterRunner(1000, createPostgresqlConnection());
//        System.out.println(postgresqlAdapterRunner.getDbconnection().getDatabaseUrl());

//        TruncateUtil.truncate(postgresqlAdapterRunner.getDbconnection());
//        postgresqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
//        postgresqlAdapterRunner.batchInsert(Scripts.MYSQL.INSERT_BATCH.get(0), Scripts.MYSQL.INSERT_BATCH.get(1), Scripts.MYSQL.INSERT_BATCH.get(2));
//        postgresqlAdapterRunner.linkInsert(Scripts.MYSQL.INSERT_LINK.get(0), Scripts.MYSQL.INSERT_LINK.get(1), Scripts.MYSQL.INSERT_LINK.get(2));
//        postgresqlAdapterRunner.batchAndPerfGeneratedKeys(Scripts.MYSQL.BATCH_GEN_KEYS.get(0), Scripts.MYSQL.BATCH_GEN_KEYS.get(1), Scripts.MYSQL.BATCH_GEN_KEYS.get(2));
//        postgresqlAdapterRunner.select(Scripts.MYSQL.SELECT.get(0), Scripts.MYSQL.SELECT.get(1), Scripts.MYSQL.SELECT.get(2));
//        postgresqlAdapterRunner.selectJoin(Scripts.MYSQL.SELECT_JOIN);
//        postgresqlAdapterRunner.update(Scripts.MYSQL.UPDATE.get(0), Scripts.MYSQL.UPDATE.get(1), Scripts.MYSQL.UPDATE.get(2));
        //TODO no available
//        postgresqlAdapterRunner.updateJoin(Scripts.POSTGRESQL.UPDATE_JOIN);
//        postgresqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0),Scripts.MYSQL.DELETE.get(1),Scripts.MYSQL.DELETE.get(2));
//        postgresqlAdapterRunner.deleteJoin(Scripts.POSTGRESQL.DELETE_JOIN.get(0), Scripts.POSTGRESQL.DELETE_JOIN.get(1), Scripts.POSTGRESQL.DELETE_JOIN.get(2));
//        postgresqlAdapterRunner.deleteBatch(Scripts.MYSQL.DELETE_BATCH.get(0), Scripts.MYSQL.DELETE_BATCH.get(1), Scripts.MYSQL.DELETE_BATCH.get(2));

        System.out.println("POSTGREQS SERVER");
//        final List<Integer> its = List.of(500, 1000, 2000, 5000, 10000, 20000, 50000);
//        for (Integer it : its) {
//            System.out.println("START OUTPUT FOR " + it);
            AdapterRunner postgresqlAdapterRunner = new AdapterRunner(500000, createPostgresqlConnection());
            System.out.println(postgresqlAdapterRunner.getDbconnection().getDatabaseUrl());
            TruncateUtil.truncate(postgresqlAdapterRunner.getDbconnection());


            TruncateUtil.truncate(postgresqlAdapterRunner.getDbconnection());
            postgresqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
            postgresqlAdapterRunner.select(Scripts.MYSQL.SELECT.get(0), Scripts.MYSQL.SELECT.get(1), Scripts.MYSQL.SELECT.get(2));
            postgresqlAdapterRunner.update(Scripts.MYSQL.UPDATE.get(0), Scripts.MYSQL.UPDATE.get(1), Scripts.MYSQL.UPDATE.get(2));
            postgresqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));


            postgresqlAdapterRunner.batchInsert(Scripts.MYSQL.INSERT_BATCH.get(0), Scripts.MYSQL.INSERT_BATCH.get(1), Scripts.MYSQL.INSERT_BATCH.get(2));
            postgresqlAdapterRunner.selectJoin(Scripts.MYSQL.SELECT_JOIN);
            postgresqlAdapterRunner.deleteBatch(Scripts.MYSQL.DELETE_BATCH.get(0), Scripts.MYSQL.DELETE_BATCH.get(1), Scripts.MYSQL.DELETE_BATCH.get(2));

            postgresqlAdapterRunner.linkInsert(Scripts.MYSQL.INSERT_LINK.get(0), Scripts.MYSQL.INSERT_LINK.get(1), Scripts.MYSQL.INSERT_LINK.get(2));
            postgresqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));


            postgresqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
            postgresqlAdapterRunner.deleteJoin(Scripts.POSTGRESQL.DELETE_JOIN.get(0), Scripts.POSTGRESQL.DELETE_JOIN.get(1), Scripts.POSTGRESQL.DELETE_JOIN.get(2));

//            System.out.println("END OUTPUT FOR " + it);
//        }
    }

    private static void msmsqlBench() {
//        AdapterRunner msSqlAdapterRunner = new AdapterRunner(10000, createMsSQLConnection());
//        System.out.println(msSqlAdapterRunner.getDbconnection().getDatabaseUrl());
//        TruncateUtil.truncate(msSqlAdapterRunner.getDbconnection());
//        msSqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
//        msSqlAdapterRunner.batchInsert(Scripts.MYSQL.INSERT_BATCH.get(0), Scripts.MYSQL.INSERT_BATCH.get(1), Scripts.MYSQL.INSERT_BATCH.get(2));
//        msSqlAdapterRunner.linkInsert(Scripts.MYSQL.INSERT_LINK.get(0), Scripts.MYSQL.INSERT_LINK.get(1), Scripts.MYSQL.INSERT_LINK.get(2));
//        msSqlAdapterRunner.batchAndPerfGeneratedKeys(Scripts.MYSQL.BATCH_GEN_KEYS.get(0), Scripts.MYSQL.BATCH_GEN_KEYS.get(1), Scripts.MYSQL.BATCH_GEN_KEYS.get(2));

//        msSqlAdapterRunner.select(Scripts.MYSQL.SELECT.get(0), Scripts.MYSQL.SELECT.get(1), Scripts.MYSQL.SELECT.get(2));
//        msSqlAdapterRunner.selectJoin(Scripts.MYSQL.SELECT_JOIN);
//        msSqlAdapterRunner.update(Scripts.MYSQL.UPDATE.get(0), Scripts.MYSQL.UPDATE.get(1), Scripts.MYSQL.UPDATE.get(2));
        //TODO refresg update, join is faster
//        msSqlAdapterRunner.updateJoin(Scripts.MSSQL.UPDATE_JOIN);
//        msSqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0),Scripts.MYSQL.DELETE.get(1),Scripts.MYSQL.DELETE.get(2));
//        msSqlAdapterRunner.deleteJoin(Scripts.MYSQL.DELETE_JOIN.get(0), Scripts.MYSQL.DELETE_JOIN.get(1), Scripts.MYSQL.DELETE_JOIN.get(2));
//        msSqlAdapterRunner.deleteBatch(Scripts.MYSQL.DELETE_BATCH.get(0), Scripts.MYSQL.DELETE_BATCH.get(1), Scripts.MYSQL.DELETE_BATCH.get(2));

//
        System.out.println("MS SQL SERVER");
        final List<Integer> its = List.of(500, 1000, 2000, 5000, 10000, 20000, 50000);
//        for (Integer it : its) {
//            System.out.println("START OUTPUT FOR " + it);
            AdapterRunner msSqlAdapterRunner = new AdapterRunner(100, createMsSQLConnection());
            System.out.println(msSqlAdapterRunner.getDbconnection().getDatabaseUrl());
            TruncateUtil.truncate(msSqlAdapterRunner.getDbconnection());


            TruncateUtil.truncate(msSqlAdapterRunner.getDbconnection());
            msSqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
            msSqlAdapterRunner.select(Scripts.MYSQL.SELECT.get(0), Scripts.MYSQL.SELECT.get(1), Scripts.MYSQL.SELECT.get(2));
            msSqlAdapterRunner.update(Scripts.MYSQL.UPDATE.get(0), Scripts.MYSQL.UPDATE.get(1), Scripts.MYSQL.UPDATE.get(2));
            msSqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));


            msSqlAdapterRunner.batchInsert(Scripts.MYSQL.INSERT_BATCH.get(0), Scripts.MYSQL.INSERT_BATCH.get(1), Scripts.MYSQL.INSERT_BATCH.get(2));
            msSqlAdapterRunner.selectJoin(Scripts.MYSQL.SELECT_JOIN);
            msSqlAdapterRunner.deleteBatch(Scripts.MYSQL.DELETE_BATCH.get(0), Scripts.MYSQL.DELETE_BATCH.get(1), Scripts.MYSQL.DELETE_BATCH.get(2));

            msSqlAdapterRunner.linkInsert(Scripts.MYSQL.INSERT_LINK.get(0), Scripts.MYSQL.INSERT_LINK.get(1), Scripts.MYSQL.INSERT_LINK.get(2));
            msSqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));

//            msSqlAdapterRunner.batchAndPerfGeneratedKeys(Scripts.MYSQL.BATCH_GEN_KEYS.get(0), Scripts.MYSQL.BATCH_GEN_KEYS.get(1), Scripts.MYSQL.BATCH_GEN_KEYS.get(2));
            msSqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));

            msSqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
            msSqlAdapterRunner.deleteJoin(Scripts.MYSQL.DELETE_JOIN.get(0), Scripts.MYSQL.DELETE_JOIN.get(1), Scripts.MYSQL.DELETE_JOIN.get(2));

//            System.out.println("END OUTPUT FOR " + it);
//        }
    }

    private static void oracleBench() {
//        final List<Integer> its = List.of(500, 1000, 2000, 5000, 10000, 20000, 50000);
//        for (Integer it : its) {
//            System.out.println("START OUTPUT FOR " + it);
        AdapterRunner oracleAdapterRunner = new AdapterRunner(100, ConnectionFactory.createOracleConnection());
        System.out.println(oracleAdapterRunner.getDbconnection().getDatabaseUrl());
        TruncateUtil.truncate(oracleAdapterRunner.getDbconnection());

//        oracleAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
//        oracleAdapterRunner.batchInsert(Scripts.MYSQL.INSERT_BATCH.get(0), Scripts.MYSQL.INSERT_BATCH.get(1), Scripts.MYSQL.INSERT_BATCH.get(2));
//        oracleAdapterRunner.linkInsert(Scripts.MYSQL.INSERT_LINK.get(0), Scripts.MYSQL.INSERT_LINK.get(1), Scripts.MYSQL.INSERT_LINK.get(2));
//        oracleAdapterRunner.batchAndPerfGeneratedKeysFOR_ORACLE(Scripts.MYSQL.BATCH_GEN_KEYS.get(0), Scripts.MYSQL.BATCH_GEN_KEYS.get(1), Scripts.MYSQL.BATCH_GEN_KEYS.get(2));
//        oracleAdapterRunner.select(Scripts.MYSQL.SELECT.get(0), Scripts.MYSQL.SELECT.get(1), Scripts.MYSQL.SELECT.get(2));
//        oracleAdapterRunner.selectJoin(Scripts.MYSQL.SELECT_JOIN);

//        oracleAdapterRunner.update(Scripts.MYSQL.UPDATE.get(0), Scripts.MYSQL.UPDATE.get(1), Scripts.MYSQL.UPDATE.get(2));
        //TODO "ORA-01776: cannot modify more than one base table through a join view"
//        oracleAdapterRunner.updateJoin(Scripts.ORACLE.UPDATE_JOIN);

//        oracleAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0),Scripts.MYSQL.DELETE.get(1),Scripts.MYSQL.DELETE.get(2));
//        oracleAdapterRunner.deleteJoin(Scripts.ORACLE.DELETE_JOIN.get(0), Scripts.ORACLE.DELETE_JOIN.get(1), Scripts.ORACLE.DELETE_JOIN.get(2));
//        oracleAdapterRunner.deleteBatch(Scripts.MYSQL.DELETE_BATCH.get(0), Scripts.MYSQL.DELETE_BATCH.get(1), Scripts.MYSQL.DELETE_BATCH.get(2));


        TruncateUtil.truncate(oracleAdapterRunner.getDbconnection());
        oracleAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
        oracleAdapterRunner.select(Scripts.MYSQL.SELECT.get(0), Scripts.MYSQL.SELECT.get(1), Scripts.MYSQL.SELECT.get(2));
        oracleAdapterRunner.update(Scripts.MYSQL.UPDATE.get(0), Scripts.MYSQL.UPDATE.get(1), Scripts.MYSQL.UPDATE.get(2));
        oracleAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));


        oracleAdapterRunner.batchInsert(Scripts.MYSQL.INSERT_BATCH.get(0), Scripts.MYSQL.INSERT_BATCH.get(1), Scripts.MYSQL.INSERT_BATCH.get(2));
        oracleAdapterRunner.selectJoin(Scripts.MYSQL.SELECT_JOIN);
//        oracleAdapterRunner.updateJoin(Scripts.MYSQL.UPDATE_JOIN);
        oracleAdapterRunner.deleteBatch(Scripts.MYSQL.DELETE_BATCH.get(0), Scripts.MYSQL.DELETE_BATCH.get(1), Scripts.MYSQL.DELETE_BATCH.get(2));

        oracleAdapterRunner.linkInsert(Scripts.MYSQL.INSERT_LINK.get(0), Scripts.MYSQL.INSERT_LINK.get(1), Scripts.MYSQL.INSERT_LINK.get(2));
        oracleAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));

        oracleAdapterRunner.batchAndPerfGeneratedKeysFOR_ORACLE(Scripts.MYSQL.BATCH_GEN_KEYS.get(0), Scripts.MYSQL.BATCH_GEN_KEYS.get(1), Scripts.MYSQL.BATCH_GEN_KEYS.get(2));
        oracleAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));

        oracleAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
        oracleAdapterRunner.deleteJoin(Scripts.ORACLE.DELETE_JOIN.get(0), Scripts.ORACLE.DELETE_JOIN.get(1), Scripts.ORACLE.DELETE_JOIN.get(2));

//            System.out.println("END OUTPUT FOR " + it);
//        }
    }

    private static void mysqlBench() {
        AdapterRunner mySqlAdapterRunner = new AdapterRunner(5000, createMySqlConnection());
        System.out.println(mySqlAdapterRunner.getDbconnection().getDatabaseUrl());

        TruncateUtil.truncate(mySqlAdapterRunner.getDbconnection());
        mySqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
        mySqlAdapterRunner.select(Scripts.MYSQL.SELECT.get(0), Scripts.MYSQL.SELECT.get(1), Scripts.MYSQL.SELECT.get(2));
        mySqlAdapterRunner.update(Scripts.MYSQL.UPDATE.get(0), Scripts.MYSQL.UPDATE.get(1), Scripts.MYSQL.UPDATE.get(2));
        mySqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));


        mySqlAdapterRunner.batchInsert(Scripts.MYSQL.INSERT_BATCH.get(0), Scripts.MYSQL.INSERT_BATCH.get(1), Scripts.MYSQL.INSERT_BATCH.get(2));
        mySqlAdapterRunner.selectJoin(Scripts.MYSQL.SELECT_JOIN);
        mySqlAdapterRunner.updateJoin(Scripts.MYSQL.UPDATE_JOIN);
        mySqlAdapterRunner.deleteBatch(Scripts.MYSQL.DELETE_BATCH.get(0), Scripts.MYSQL.DELETE_BATCH.get(1), Scripts.MYSQL.DELETE_BATCH.get(2));

        mySqlAdapterRunner.linkInsert(Scripts.MYSQL.INSERT_LINK.get(0), Scripts.MYSQL.INSERT_LINK.get(1), Scripts.MYSQL.INSERT_LINK.get(2));
        mySqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));

        mySqlAdapterRunner.batchAndPerfGeneratedKeys(Scripts.MYSQL.BATCH_GEN_KEYS.get(0), Scripts.MYSQL.BATCH_GEN_KEYS.get(1), Scripts.MYSQL.BATCH_GEN_KEYS.get(2));
        mySqlAdapterRunner.delete(Scripts.MYSQL.DELETE.get(0), Scripts.MYSQL.DELETE.get(1), Scripts.MYSQL.DELETE.get(2));

        mySqlAdapterRunner.insert(Scripts.MYSQL.INSERT.get(0), Scripts.MYSQL.INSERT.get(1), Scripts.MYSQL.INSERT.get(2));
        mySqlAdapterRunner.deleteJoin(Scripts.MYSQL.DELETE_JOIN.get(0), Scripts.MYSQL.DELETE_JOIN.get(1), Scripts.MYSQL.DELETE_JOIN.get(2));
    }


}
