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
    private int vehicle_booking_id;
    @NotEmpty(message = "booking_id is required")
    private int booking_id;
    @NotEmpty(message = "vehicle_id is required")
    private int vehicle_id;
    @NotEmpty(message = "vehicle price is required")
    private double price;
    @NotNull(message = "vehicle discount should not be Null")
    private double discount;
    @NotEmpty(message = "vehicle cancellation policy is required")
    private int can_policy_id;
    @NotEmpty(message = "vehicle cancellation Fee is required")
    private double can_fee;
    @NotNull(message = "vehicle status should not be Null")
    private String status;
}
