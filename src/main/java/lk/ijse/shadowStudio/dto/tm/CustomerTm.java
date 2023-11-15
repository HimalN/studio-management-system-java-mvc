package lk.ijse.shadowStudio.dto.tm;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTm {
    private String customerId;
    private String customerName;
    private String customerNic;
    private String customerTp;
    private String description;
}
