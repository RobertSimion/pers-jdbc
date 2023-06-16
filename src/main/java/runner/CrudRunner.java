package runner;


public interface CrudRunner {
    void insert(String insertPayroll, String insertEmployee, String insertEmployeeDetails);

    void batchInsert(String insertPayroll, String insertEmployee, String insertEmployeeDetails);

    void linkInsert(String insertPayroll, String insertEmployee, String insertEmployeeDetails);

    void batchAndPerfGeneratedKeys(String insertPayroll, String insertEmployee, String insertEmployeeDetails);

    void select(String selectPayroll, String selectEmployee, String selectEmployeeDetails);

    void selectJoin(String selectJoin);

    void update(String updatePayroll, String updateEmployee, String updateEmployeeDetailsStatement);

    void updateJoin(String updateJoin);

    void delete(String deletePayroll, String deleteEmployee, String deleteEmployeeDetails);

    void deleteJoin(String deleteEmployeeDetailsJoin, String deleteEmployeeJoin, String deletePayrollJoin);

    void deleteBatch(String deletePayroll, String deleteEmployee, String deleteEmployeeDetails);
}
