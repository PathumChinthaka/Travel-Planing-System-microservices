package lk.nexttravelcompany.hotel.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Room_Type")
public class RoomType {
    @Id
    private int room_type_id;
    private String room_type_name;
    private String status;
}
