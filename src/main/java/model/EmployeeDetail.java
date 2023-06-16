package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDetail {
    int idemployee;
    String firstname;
    String lastname;
    int seniority;
    String address;
}
