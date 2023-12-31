package lk.nexttravelcompany.hotel.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Room_Type_details")
public class RoomType {
    @Id
    private String roomTypeId;
    private String roomTypeName;
    private String status;
}
