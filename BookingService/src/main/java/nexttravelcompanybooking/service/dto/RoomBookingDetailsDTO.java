package nexttravelcompanybooking.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nexttravelcompanybooking.service.entity.HotelBookingDetails;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomBookingDetailsDTO {
    private int room_booking_id;
    private List<HotelBookingDetails>hotelBookingId;
    private int room_id;
    private double price;
    private double discount;
    private int can_policy_id;
    private double can_fee;
    private String status;
}
