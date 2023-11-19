package nexttravelcompanybooking.service.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nexttravelcompanybooking.service.entity.HotelBookingDetails;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomBookingDetailsDTO {
    private int roomBookingId;
    private List<HotelBookingDetails>hotelBookingId;
    private int roomId;
    private double price;
    private double discount;
    private int canPolicyId;
    private double canFee;
    private String status;
}
