package lk.nexttravelcompany.hotel.service.entity;

import lk.nexttravelcompany.hotel.service.dto.HotelMealPlaneDTO;
import lk.nexttravelcompany.hotel.service.dto.HotelRoomTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Room_details")
public class RoomDetails {
    @Id
    private String roomId;
    private String roomName;
    private List<HotelMealPlaneDTO> hotelMealPlaneDTOList;
    private List<HotelRoomTypeDTO> hotelRoomTypeDTOList;
    private boolean isAC;
    private boolean isPetsAllow;
    private CancellationPolicy cancellationPolicy;
    private double priceDay;
    private double priceDayDiscount;
    private double priceNight;
    private double priceNightDiscount;
    private String status;
}
