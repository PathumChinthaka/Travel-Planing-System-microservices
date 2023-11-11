package nexttravelcompanybooking.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelBookingDetailsDTO {
    @NotEmpty(message = "Hotel Booking id is required")
    private int hotel_Booking_Id;
    @NotEmpty(message = "Booking id is required")
    private int booking_id;
    @NotEmpty(message = "Hotel id is required")
    private int hotel_id;
    @NotNull(message = " cal Price should not be Null")
    @NotEmpty(message = "cal Price required")
    private double cal_price;
    @NotNull(message = "Hotel discount Price should not be Null")
    @NotEmpty(message = "Hotel discount Price is required")
    private double discount_price;
    @NotNull(message = "Hotel price should not be Null")
    @NotEmpty(message = "Hotel price  is required")
    private double hotel_price;
    @NotNull(message = "Status should not be Null")
    private String status;
}
