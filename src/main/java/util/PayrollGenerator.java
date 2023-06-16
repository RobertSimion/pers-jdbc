package util;

import model.Employee;
import model.EmployeeDetail;
import model.Payroll;

import java.util.LinkedList;
import java.util.List;

public class PayrollGenerator {

    public static List<Payroll> setupPayrollLink(int iterations) {
        List<Payroll> payrolls = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            List<Employee> employeeList = new LinkedList<>();
            EmployeeDetail employeeDetail = EmployeeDetail.builder()
                    .idemployee(10 * i)
                    .firstname("FirstName ")
                    .lastname("LastName ")
                    .seniority(0)
                    .address("Street " + i)
                    .build();
            Employee employee = Employee.builder()
                    .idemployee(10 * i)
                    .idpayroll(i)
                    .salary(i)
                    .position("Position ")
                    .employeeDetail(employeeDetail)
                    .build();
            employeeList.add(employee);

            Payroll payroll = Payroll.builder()
                    .idpayroll(i)
                    .status("Ok")
                    .budget(i)
                    .employeeList(employeeList)
                    .build();
            payrolls.add(payroll);
        }

        return payrolls;
    }
}
