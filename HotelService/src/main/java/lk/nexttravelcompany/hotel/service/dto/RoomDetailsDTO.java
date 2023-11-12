package lk.nexttravelcompany.hotel.service.dto;

import lk.nexttravelcompany.hotel.service.entity.CancellationPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDetailsDTO {
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
