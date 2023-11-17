package lk.ijse.shadowStudio.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String itemId;
    private String itemName;
    private String itemType;
    private String rentalPrice;
}
