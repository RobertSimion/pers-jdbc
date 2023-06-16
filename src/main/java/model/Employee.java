package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    int idemployee;
    int idpayroll;
    double salary;
    String position;
    EmployeeDetail employeeDetail;
}
