package runner;

import conn.DbConnection;
import lombok.Getter;
import model.Employee;
import model.EmployeeDetail;
import model.Payroll;
import org.apache.commons.lang3.time.StopWatch;
import util.PayrollGenerator;

import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class AdapterRunner implements CrudRunner {

    public DbConnection dbconnection;
    private static StopWatch stopWatch;
    private final Integer iterations;
    private static List<Payroll> payrolls = null;

    public AdapterRunner(Integer iterations, DbConnection dbConnection) {
        this.dbconnection = dbConnection;
        stopWatch = new StopWatch();
        this.iterations = iterations;
        payrolls = PayrollGenerator.setupPayrollLink(iterations);
    }

    @Override
    public void insert(String insertPayroll, String insertEmployee, String insertEmployeeDetails) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(insertPayroll);
            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(insertEmployee);
            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(insertEmployeeDetails);

            dbconnection.getConnection().setAutoCommit(false);
            Instant start = Instant.now();
            for (Payroll payroll : payrolls) {
                statement1.setInt(1, payroll.getIdpayroll());
                statement1.setString(2, payroll.getStatus());
                statement1.setDouble(3, payroll.getBudget());

                statement1.executeUpdate();

                for (Employee employee : payroll.getEmployeeList()) {
                    statement2.setInt(1, employee.getIdemployee());
                    statement2.setInt(2, employee.getIdpayroll());
                    statement2.setDouble(3, employee.getSalary());
                    statement2.setString(4, employee.getPosition());
                    statement2.executeUpdate();

                    EmployeeDetail employeeDetail = employee.getEmployeeDetail();
                    statement3.setInt(1, employeeDetail.getIdemployee());
                    statement3.setString(2, employeeDetail.getFirstname());
                    statement3.setString(3, employeeDetail.getLastname());
                    statement3.setInt(4, employeeDetail.getSeniority());
                    statement3.setString(5, employeeDetail.getAddress());
                    statement3.executeUpdate();
                }
            }

            dbconnection.getConnection().commit();
            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Insert with executeUpdate() time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void batchInsert(String insertPayroll, String insertEmployee, String insertEmployeeDetails) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(insertPayroll);
            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(insertEmployee);
            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(insertEmployeeDetails);


            dbconnection.getConnection().setAutoCommit(false);

            Instant start = Instant.now();
            for (Payroll payroll : payrolls) {
                statement1.setInt(1, payroll.getIdpayroll());
                statement1.setString(2, payroll.getStatus());
                statement1.setDouble(3, payroll.getBudget());
                statement1.addBatch();

                for (Employee employee : payroll.getEmployeeList()) {
                    statement2.setInt(1, employee.getIdemployee());
                    statement2.setInt(2, employee.getIdpayroll());
                    statement2.setDouble(3, employee.getSalary());
                    statement2.setString(4, employee.getPosition());
                    statement2.addBatch();

                    EmployeeDetail employeeDetail = employee.getEmployeeDetail();
                    statement3.setInt(1, employeeDetail.getIdemployee());
                    statement3.setString(2, employeeDetail.getFirstname());
                    statement3.setString(3, employeeDetail.getLastname());
                    statement3.setInt(4, employeeDetail.getSeniority());
                    statement3.setString(5, employeeDetail.getAddress());
                    statement3.addBatch();
                }
            }


            statement1.executeBatch();
            statement2.executeBatch();
            statement3.executeBatch();
            dbconnection.getConnection().commit();
            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Insert with batch processing time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }


    @Override
    public void linkInsert(String insertPayroll, String insertEmployee, String insertEmployeeDetails) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(insertPayroll);
            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(insertEmployee);
            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(insertEmployeeDetails);

            dbconnection.getConnection().setAutoCommit(false);

            Instant start = Instant.now();
            for (Payroll payroll : payrolls) {
                statement1.setInt(1, payroll.getIdpayroll());
                statement1.setString(2, payroll.getStatus());
                statement1.setDouble(3, payroll.getBudget());
                statement1.addBatch();

                for (Employee employee : payroll.getEmployeeList()) {
                    statement2.setInt(1, employee.getIdemployee());
                    statement2.setDouble(2, employee.getSalary());
                    statement2.setString(3, employee.getPosition());
                    statement2.setInt(4, payroll.getIdpayroll());
                    statement2.addBatch();

                    EmployeeDetail employeeDetail = employee.getEmployeeDetail();
                    statement3.setInt(1, employeeDetail.getIdemployee());
                    statement3.setString(2, employeeDetail.getFirstname());
                    statement3.setString(3, employeeDetail.getLastname());
                    statement3.setInt(4, employeeDetail.getSeniority());
                    statement3.setString(5, employeeDetail.getAddress());
                    statement3.setInt(6, employee.getIdemployee());
                    statement3.addBatch();
                }
            }

            statement1.executeBatch();
            statement2.executeBatch();
            statement3.executeBatch();
            dbconnection.getConnection().commit();
            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Insert with link  time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void batchAndPerfGeneratedKeys(String insertPayroll, String insertEmployee, String insertEmployeeDetails) {
        Duration elapsedTime = null;

        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(insertPayroll, Statement.RETURN_GENERATED_KEYS);

            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(insertEmployee, Statement.RETURN_GENERATED_KEYS);

            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(insertEmployeeDetails, Statement.RETURN_GENERATED_KEYS);

            dbconnection.getConnection().setAutoCommit(false);


            Instant start = Instant.now();
            for (Payroll payroll : payrolls) {
                statement1.setInt(1, payroll.getIdpayroll());
                statement1.setString(2, payroll.getStatus());
                statement1.setDouble(3, payroll.getBudget());
                statement1.addBatch();

                for (Employee employee : payroll.getEmployeeList()) {
                    statement2.setInt(1, employee.getIdemployee());
                    statement2.setInt(2, payroll.getIdpayroll());
                    statement2.setDouble(3, employee.getSalary());
                    statement2.setString(4, employee.getPosition());
                    statement2.addBatch();

                    EmployeeDetail employeeDetail = employee.getEmployeeDetail();
                    statement3.setInt(1, employeeDetail.getIdemployee());
                    statement3.setString(2, employeeDetail.getFirstname());
                    statement3.setString(3, employeeDetail.getLastname());
                    statement3.setInt(4, employeeDetail.getSeniority());
                    statement3.setString(5, employeeDetail.getAddress());
                    statement3.addBatch();
                }
            }

            statement1.executeBatch();
            ResultSet generatedKeys = statement1.getGeneratedKeys();

            int i = 0;
            while (generatedKeys.next()) {
                payrolls.get(i++).setIdpayroll(generatedKeys.getInt(1));
            }

            statement2.executeBatch();
            generatedKeys = statement2.getGeneratedKeys();

            i = 0;
            while (generatedKeys.next()) {
                for (Employee employee : payrolls.get(i++).getEmployeeList()) {
                    employee.setIdemployee(generatedKeys.getInt(1));
                }
            }

            statement3.executeBatch();

            dbconnection.getConnection().commit();
            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Insert batching optimized with generated keys caching time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    public void batchAndPerfGeneratedKeysFOR_ORACLE(String insertPayroll, String insertEmployee, String insertEmployeeDetails) {
        Duration elapsedTime = null;

        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(insertPayroll, new String[]{"IDPAYROLL"});

            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(insertEmployee, new String[]{"IDEMPLOYEE"});

            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(insertEmployeeDetails);

            dbconnection.getConnection().setAutoCommit(false);


            Instant start = Instant.now();
            for (Payroll payroll : payrolls) {
                statement1.setInt(1, payroll.getIdpayroll());
                statement1.setString(2, payroll.getStatus());
                statement1.setDouble(3, payroll.getBudget());
                statement1.addBatch();

                for (Employee employee : payroll.getEmployeeList()) {
                    statement2.setInt(1, employee.getIdemployee());
                    statement2.setInt(2, payroll.getIdpayroll());
                    statement2.setDouble(3, employee.getSalary());
                    statement2.setString(4, employee.getPosition());
                    statement2.addBatch();

                    EmployeeDetail employeeDetail = employee.getEmployeeDetail();
                    statement3.setInt(1, employeeDetail.getIdemployee());
                    statement3.setString(2, employeeDetail.getFirstname());
                    statement3.setString(3, employeeDetail.getLastname());
                    statement3.setInt(4, employeeDetail.getSeniority());
                    statement3.setString(5, employeeDetail.getAddress());
                    statement3.addBatch();
                }
            }

            statement1.executeBatch();
            ResultSet generatedKeys = statement1.getGeneratedKeys();

            int i = 0;
            while (generatedKeys.next()) {
                payrolls.get(i++).setIdpayroll(generatedKeys.getInt(1));
            }

            statement2.executeBatch();
            generatedKeys = statement2.getGeneratedKeys();

            i = 0;
            while (generatedKeys.next()) {
                for (Employee employee : payrolls.get(i++).getEmployeeList()) {
                    employee.setIdemployee(generatedKeys.getInt(1));
                }
            }

            statement3.executeBatch();

            dbconnection.getConnection().commit();
            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Insert batching optimized with generated keys caching time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }


    @Override
    public void select(String selectPayroll, String selectEmployee, String selectEmployeeDetails) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(selectPayroll, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(selectEmployee, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(selectEmployeeDetails, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet payrollResultSet = statement1.executeQuery();
            ResultSet employeeResultSet = statement2.executeQuery();
            ResultSet employeeDetailsResultSet = statement3.executeQuery();

            List<Payroll> payrolls = new ArrayList<>();

            Instant start = Instant.now();

            while (payrollResultSet.next()) {

                Payroll payroll = Payroll.builder()
                        .idpayroll(payrollResultSet.getInt("idpayroll"))
                        .status(payrollResultSet.getString("status"))
                        .budget(payrollResultSet.getDouble("budget"))
                        .build();

                List<Employee> employees = new ArrayList<>();

                while (employeeResultSet.next()) {
                    if (employeeResultSet.getInt("idpayroll") == payroll.getIdpayroll()) {
                        Employee employee = Employee.builder()
                                .idemployee(employeeResultSet.getInt("idemployee"))
                                .idpayroll(employeeResultSet.getInt("idpayroll"))
                                .salary(employeeResultSet.getDouble("salary"))
                                .position(employeeResultSet.getString("position")).build();

                        while (employeeDetailsResultSet.next()) {
                            if (employeeDetailsResultSet.getInt("idemployee") == employee.getIdemployee()) {
                                EmployeeDetail employeeDetail = EmployeeDetail.builder()
                                        .idemployee(employeeDetailsResultSet.getInt("idemployee"))
                                        .firstname(employeeDetailsResultSet.getString("firstname"))
                                        .lastname(employeeDetailsResultSet.getString("lastname"))
                                        .seniority(employeeDetailsResultSet.getInt("seniority"))
                                        .address(employeeDetailsResultSet.getString("address"))
                                        .build();
                                employee.setEmployeeDetail(employeeDetail);
                                break;
                            }
                        }

                        employees.add(employee);
                    }
                }

                payroll.setEmployeeList(employees);
                payrolls.add(payroll);

                employeeResultSet.beforeFirst();
                employeeDetailsResultSet.beforeFirst();
                Instant end = Instant.now();
                elapsedTime = Duration.between(start, end);
            }

            payrollResultSet.close();
            employeeResultSet.close();
            employeeDetailsResultSet.close();
            statement1.close();
            statement2.close();
            statement3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Select time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void selectJoin(String selectJoin) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement = dbconnection.connect().prepareStatement(
                    selectJoin,
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement.executeQuery();
            List<Payroll> payrolls = new ArrayList<>();

            Instant start = Instant.now();

            while (resultSet.next()) {

                Payroll payroll = Payroll.builder()
                        .idpayroll(resultSet.getInt("idpayroll"))
                        .status(resultSet.getString("status"))
                        .budget(resultSet.getDouble("budget"))
                        .build();

                Employee employee = Employee.builder()
                        .idemployee(resultSet.getInt("idemployee"))
                        .idpayroll(payroll.getIdpayroll())
                        .salary(resultSet.getDouble("salary"))
                        .position(resultSet.getString("position")).build();

                EmployeeDetail employeeDetail = EmployeeDetail.builder()
                        .idemployee(employee.getIdemployee())
                        .firstname(resultSet.getString("firstname"))
                        .lastname(resultSet.getString("lastname"))
                        .seniority(resultSet.getInt("seniority"))
                        .address(resultSet.getString("address"))
                        .build();
                employee.setEmployeeDetail(employeeDetail);

                boolean payrollExist = false;
                for (Payroll p : payrolls) {
                    if (p.getIdpayroll() == payroll.getIdpayroll()) {
                        p.getEmployeeList().add(employee);
                        payrollExist = true;
                        break;
                    }
                }

                if (!payrollExist) {
                    payroll.setEmployeeList(Arrays.asList(employee));
                    payrolls.add(payroll);
                }

                Instant end = Instant.now();
                elapsedTime = Duration.between(start, end);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Select joined time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void update(String updatePayroll, String updateEmployee, String updateEmployeeDetails) {
        Duration elapsedTime = null;
        try {
            PreparedStatement payrollStatement = dbconnection.connect().prepareStatement(
                    updatePayroll);
            PreparedStatement employeeStatement = dbconnection.getConnection().prepareStatement(updateEmployee);
            PreparedStatement employeeDetailsStatement = dbconnection.getConnection().prepareStatement(
                    updateEmployeeDetails
            );

            Instant start = Instant.now();

            for (Payroll payroll : payrolls) {
                int payrollId = payroll.getIdpayroll();
                payrollStatement.setString(1, payroll.getStatus() + 1);
                payrollStatement.setDouble(2, payroll.getBudget() + 1);
                payrollStatement.setInt(3, payrollId);
                payrollStatement.addBatch();

                for (Employee employee : payroll.getEmployeeList()) {
                    int employeeId = employee.getIdemployee();
                    employeeStatement.setDouble(1, employee.getSalary() + 1);
                    employeeStatement.setString(2, employee.getPosition() + 1);
                    employeeStatement.setInt(3, employeeId);
                    employeeStatement.addBatch();

                    EmployeeDetail employeeDetail = employee.getEmployeeDetail();
                    employeeDetailsStatement.setString(1, employeeDetail.getFirstname() + 1);
                    employeeDetailsStatement.setString(2, employeeDetail.getLastname() + 1);
                    employeeDetailsStatement.setInt(3, employeeDetail.getSeniority() + 1);
                    employeeDetailsStatement.setString(4, employeeDetail.getAddress() + 1);
                    employeeDetailsStatement.setInt(5, employeeId);
                    employeeDetailsStatement.addBatch();
                }
            }

            payrollStatement.executeBatch();
            employeeStatement.executeBatch();
            employeeDetailsStatement.executeBatch();

            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);

            payrollStatement.close();
            employeeStatement.close();
            employeeDetailsStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Update without join time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void updateJoin(String updateJoin) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement = dbconnection.connect().prepareStatement(
                    updateJoin);
            Instant start = Instant.now();

            for (Payroll payroll : payrolls) {
                for (Employee employee : payroll.getEmployeeList()) {
                    EmployeeDetail employeeDetail = employee.getEmployeeDetail();
                    statement.setString(1, payroll.getStatus() + 1);
                    statement.setDouble(2, payroll.getBudget() + 1);
                    statement.setDouble(3, employee.getSalary() + 1);
                    statement.setString(4, employee.getPosition() + 1);
                    statement.setString(5, employeeDetail.getFirstname() + 1);
                    statement.setString(6, employeeDetail.getLastname() + 1);
                    statement.setInt(7, employeeDetail.getSeniority() + 1);
                    statement.setString(8, employeeDetail.getAddress() + 1);
                    statement.setInt(9, payroll.getIdpayroll());
                    statement.setInt(10, employee.getIdemployee());
                    statement.addBatch();
                }
            }

            int[] updateCounts = statement.executeBatch();
            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Update joined time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void delete(String deletePayroll, String deleteEmployee, String deleteEmployeeDetails) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(deletePayroll);
            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(deleteEmployee);
            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(deleteEmployeeDetails);

            Instant start = Instant.now();

            statement3.executeUpdate();
            statement2.executeUpdate();
            statement1.executeUpdate();

            Instant end = Instant.now();
            elapsedTime = Duration.between(start, end);

            statement1.close();
            statement2.close();
            statement3.close();

            dbconnection.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Delete time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void deleteJoin(String deleteEmployeeDetailsJoin, String deleteEmployeeJoin, String deletePayrollJoin) {
        Duration elapsedTime = null;
        try {
            PreparedStatement statement1 = dbconnection.connect().prepareStatement(deleteEmployeeDetailsJoin);
            Instant start = Instant.now();
            statement1.executeUpdate();
            statement1.close();

            PreparedStatement statement2 = dbconnection.getConnection().prepareStatement(deleteEmployeeJoin);
            statement2.executeUpdate();
            statement2.close();

            PreparedStatement statement3 = dbconnection.getConnection().prepareStatement(deletePayrollJoin);
            statement3.executeUpdate();
            elapsedTime = Duration.between(start, Instant.now());
            statement3.close();
            dbconnection.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert elapsedTime != null;
            System.out.println("Delete join time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }

    @Override
    public void deleteBatch(String deletePayroll, String deleteEmployee, String deleteEmployeeDetails) {
        Duration elapsedTime = null;
        Instant start = Instant.now();
        try {
            dbconnection.connect().setAutoCommit(false);
            PreparedStatement deletePayrollStmt = dbconnection.getConnection().prepareStatement(deletePayroll);
            PreparedStatement deleteEmployeeStmt = dbconnection.getConnection().prepareStatement(deleteEmployee);
            PreparedStatement deleteEmployeeDetailsStmt = dbconnection.getConnection().prepareStatement(deleteEmployeeDetails);


            deleteEmployeeDetailsStmt.addBatch();
            deleteEmployeeStmt.addBatch();
            deletePayrollStmt.addBatch();

            deleteEmployeeDetailsStmt.executeBatch();
            deleteEmployeeStmt.executeBatch();
            deletePayrollStmt.executeBatch();


            dbconnection.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            elapsedTime = Duration.between(start, Instant.now());
            System.out.println("Delete batch time " + elapsedTime.toMillis());
            dbconnection.disconnect();
        }
    }
}
