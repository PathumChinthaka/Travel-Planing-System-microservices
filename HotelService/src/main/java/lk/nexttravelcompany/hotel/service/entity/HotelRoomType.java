package lk.nexttravelcompany.hotel.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Hotel_Room_Type")
public class HotelRoomType {
    @Id
    private String roomTypeId;
    private String roomTypeName;
    private String status;
    private int roomCount;
    private int adultCount;
    private int childCount;
}
