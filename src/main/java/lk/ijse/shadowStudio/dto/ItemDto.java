package lk.ijse.shadowStudio.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String itemId;
    private String itemName;
    private String itemType;
    private String rentalPrice;
}
