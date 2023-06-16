package util;

import java.util.List;

public class Scripts {

    public static class MYSQL {

        public static final List<String> INSERT = List.of(
                "INSERT INTO payroll (idpayroll, status, budget) VALUES(?, ?, ?)",
                "INSERT INTO employee (idemployee, idpayroll, salary, position) VALUES (?, ?, ?, ?)",
                "INSERT INTO employee_details (idemployee, firstname, lastname, seniority, address) VALUES (?, ?, ?, ?, ?)"
        );

        public static final List<String> INSERT_BATCH = List.of(
                "INSERT INTO payroll (idpayroll, status, budget) VALUES(?, ?, ?)",
                "INSERT INTO employee (idemployee, idpayroll, salary, position) VALUES (?, ?, ?, ?)",
                "INSERT INTO employee_details (idemployee, firstname, lastname, seniority, address) VALUES (?, ?, ?, ?, ?)"
        );

        public static final List<String> INSERT_LINK = List.of(
                "INSERT INTO payroll (idpayroll, status, budget) VALUES (?, ?, ?)",
                "INSERT INTO employee (idemployee, idpayroll, salary, position) SELECT ?, idpayroll, ?, ? FROM payroll WHERE idpayroll = ?",
                "INSERT INTO employee_details (idemployee, firstname, lastname, seniority, address) SELECT ?, ?, ?, ?, ? FROM employee WHERE idemployee = ?"
        );

        public static final List<String> BATCH_GEN_KEYS = List.of(
                "INSERT INTO payroll (idpayroll, status, budget) VALUES (?, ?, ?)",
                "INSERT INTO employee (idemployee, idpayroll, salary, position) VALUES (?, ?, ?, ?)",
                "INSERT INTO employee_details (idemployee, firstname, lastname, seniority, address) VALUES (?, ?, ?, ?, ?)"
        );

        public static final List<String> SELECT = List.of(
                "SELECT * FROM payroll",
                "SELECT * FROM employee",
                "SELECT * FROM employee_details"
        );

        public static final String SELECT_JOIN = "SELECT p.idpayroll, p.status, p.budget, e.idemployee, e.salary, e.position, " +
                "ed.firstname, ed.lastname, ed.seniority, ed.address " +
                "FROM payroll p " +
                "INNER JOIN employee e ON p.idpayroll = e.idpayroll " +
                "INNER JOIN employee_details ed ON e.idemployee = ed.idemployee";

        public static final List<String> UPDATE = List.of(
                "UPDATE payroll SET status=?, budget=? WHERE idpayroll=?",
                "UPDATE employee SET salary=?, position=? WHERE idemployee=?",
                "UPDATE employee_details SET firstname=?, lastname=?, seniority=?, address=? WHERE idemployee=?"
        );

        public static final String UPDATE_JOIN = "UPDATE payroll p " +
                "INNER JOIN employee e ON p.idpayroll = e.idpayroll " +
                "INNER JOIN employee_details ed ON e.idemployee = ed.idemployee " +
                "SET p.status=?, p.budget=?, e.salary=?, e.position=?, ed.firstname=?, ed.lastname=?, ed.seniority=?, ed.address=? " +
                "WHERE p.idpayroll=? AND e.idemployee=?";

        public static final List<String> DELETE = List.of(
                "DELETE FROM payroll",
                "DELETE FROM employee",
                "DELETE FROM employee_details"
        );

        public static final List<String> DELETE_JOIN = List.of(
                "DELETE ed FROM employee_details ed "
                        + "JOIN employee e ON ed.idemployee = e.idemployee "
                        + "JOIN payroll p ON e.idpayroll = p.idpayroll;",
                "DELETE e FROM employee e "
                        + "JOIN payroll p ON e.idpayroll = p.idpayroll;",
                "DELETE FROM payroll;"
        );

        public static final List<String> DELETE_BATCH = List.of(
                "DELETE FROM payroll",
                "DELETE FROM employee",
                "DELETE FROM employee_details"
        );
    }

    public static class ORACLE {
        public static final String UPDATE_JOIN = "UPDATE (SELECT p.status, p.budget, e.salary, e.position, ed.firstname, ed.lastname, ed.seniority, ed.address\n" +
                "        FROM payroll p \n" +
                "        INNER JOIN employee e ON p.idpayroll = e.idpayroll \n" +
                "        INNER JOIN employee_details ed ON e.idemployee = ed.idemployee \n" +
                "        WHERE p.idpayroll = ? AND e.idemployee = ?) t\n" +
                "SET t.status = ?, t.budget = ?, t.salary = ?, t.position = ?, t.firstname = ?, t.lastname = ?, t.seniority = ?, t.address = ?\n";

        public static final List<String> DELETE_JOIN = List.of(
                "DELETE FROM employee_details ed\n" +
                        "WHERE EXISTS (\n" +
                        "    SELECT 1 \n" +
                        "    FROM employee e \n" +
                        "    JOIN payroll p ON e.idpayroll = p.idpayroll \n" +
                        "    WHERE ed.idemployee = e.idemployee\n" +
                        ")\n",
                "DELETE FROM employee \n" +
                        "WHERE idpayroll IN (\n" +
                        "    SELECT idpayroll \n" +
                        "    FROM payroll\n" +
                        ")\n",
                "DELETE FROM payroll"
        );

    }

    public static class MSSQL {
        public static final String UPDATE_JOIN = "UPDATE [payroll], [employee], [employee_details]\n" +
                "SET [payroll].status=?, [payroll].budget=?, [employee].salary=?, [employee].position=?, [employee_details].firstname=?, [employee_details].lastname=?, [employee_details].seniority=?, [employee_details].address=?\n" +
                "WHERE [payroll].idpayroll=[employee].idpayroll\n" +
                "AND [employee].idemployee=[employee_details].idemployee\n" +
                "AND [payroll].idpayroll=?\n" +
                "AND [employee].idemployee=?;\n";

    }

    public static class POSTGRESQL {
        public static final String UPDATE_JOIN = "\"UPDATE payroll p \" +\n" +
                "                \"SET p.status=?, p.budget=?, e.salary=?, e.position=?, ed.firstname=?, ed.lastname=?, ed.seniority=?, ed.address=? \" +\n" +
                "                \"FROM payroll JOIN employee e ON p.idpayroll = e.idpayroll \" +\n" +
                "                \"JOIN employee_details ed ON e.idemployee = ed.idemployee \" +\n" +
                "                \"WHERE p.idpayroll=? AND e.idemployee=?\";";

        public static final List<String> DELETE_JOIN = List.of(
                "DELETE FROM employee_details ed\n" +
                        "USING employee e, payroll p \n" +
                        "WHERE ed.idemployee = e.idemployee AND e.idpayroll = p.idpayroll;",
                "DELETE FROM employee e \n" +
                        "USING payroll p \n" +
                        "WHERE e.idpayroll = p.idpayroll;",
                "DELETE FROM payroll;"
        );
    }

}
