package lk.ijse.shadowStudio.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String emp_id;
    private String emp_name;
    private String emp_address;
    private String emp_nic;
    private String emp_tp;
}
