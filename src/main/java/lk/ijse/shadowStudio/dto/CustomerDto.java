package lk.ijse.shadowStudio.dto;

import lombok.*;

import java.lang.invoke.StringConcatException;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String customerId;
    private String customerName;
    private String customerNic;
    private String customerTp;
    private String description;
}
