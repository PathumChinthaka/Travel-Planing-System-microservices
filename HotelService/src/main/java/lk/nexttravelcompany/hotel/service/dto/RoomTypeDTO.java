package lk.nexttravelcompany.hotel.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTypeDTO {
    private String roomTypeId;
    private String roomTypeName;
    private String status;
}
