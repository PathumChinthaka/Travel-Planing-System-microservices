package nexttravelcompanybooking.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleBookingDetailsDTO {
    @NotEmpty(message = "vehicle_booking_id is required")
    private int vehicleBookingId;
    @NotEmpty(message = "booking_id is required")
    private BookingDTO bookingId;
    @NotEmpty(message = "vehicle_id is required")
    private int vehicleId;
    @NotEmpty(message = "vehicle price is required")
    private double price;
    @NotNull(message = "vehicle discount should not be Null")
    private double discount;
    @NotEmpty(message = "vehicle cancellation policy is required")
    private int canPolicyId;
    @NotEmpty(message = "vehicle cancellation Fee is required")
    private double canFee;
    @NotNull(message = "vehicle status should not be Null")
    private String status;
}
