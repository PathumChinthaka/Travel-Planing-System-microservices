package nexttravelcompanybooking.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nexttravelcompanybooking.service.entity.RoomBookingDetails;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelBookingDetailsDTO {
    @NotEmpty(message = "Hotel Booking id is required")
    private int hotelBookingId;
    @NotEmpty(message = "Booking id is required")
    private BookingDTO bookingId;
    @NotEmpty(message = "Hotel id is required")
    private int hotelId;
    @NotNull(message = " cal Price should not be Null")
    @NotEmpty(message = "cal Price required")
    private double calPrice;
    @NotNull(message = "Hotel discount Price should not be Null")
    @NotEmpty(message = "Hotel discount Price is required")
    private double discountPrice;
    @NotNull(message = "Hotel price should not be Null")
    @NotEmpty(message = "Hotel price  is required")
    private double hotelPrice;
    @NotNull(message = "Status should not be Null")
    private String status;
    private RoomBookingDetails roomBookingDetails;

}
