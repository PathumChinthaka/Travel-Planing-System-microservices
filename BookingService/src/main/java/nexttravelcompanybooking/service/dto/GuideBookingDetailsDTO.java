package nexttravelcompanybooking.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideBookingDetailsDTO {
    @NotEmpty(message = "Guide Booking id is required")
    private int guid_booking_id;
    @NotEmpty(message = "Booking id is required")
    private int booking_id;
    @NotEmpty(message = "guide id is required")
    private int guid_id;
    @NotNull(message = "user Email should not be Null")
    @NotEmpty(message = "User Email is required")
    private double price;
    @NotNull(message = "user Email should not be Null")
    private double discount;
    @NotNull(message = "Cancellation Policy should not be Null")
    @NotEmpty(message = "Cancellation Policy is required")
    private int can_policy_id;
    @NotNull(message = "Cancellation Fee should not be Null")
    @NotEmpty(message = "Cancellation Fee is required")
    private double can_fee;
    @NotNull(message = "Cancellation Fee should not be Null")
    private String status;
}
