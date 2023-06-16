package model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Payroll {
    int idpayroll;
    String status;
    double budget;
    List<Employee> employeeList;
}
