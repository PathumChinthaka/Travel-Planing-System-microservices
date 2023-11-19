package nexttravelcompanybooking.service.dto;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nexttravelcompanybooking.service.entity.Booking;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideBookingDetailsDTO {
    @NotEmpty(message = "Guide Booking id is required")
    private int guidBookingId;
    @NotEmpty(message = "Booking id is required")
    private Booking bookingId;
    @NotEmpty(message = "guide id is required")
    private int guidId;
    @NotNull(message = "user Email should not be Null")
    @NotEmpty(message = "User Email is required")
    private double price;
    @NotNull(message = "user Email should not be Null")
    private double discount;
    @NotNull(message = "Cancellation Policy should not be Null")
    @NotEmpty(message = "Cancellation Policy is required")
    private int canPolicyId;
    @NotNull(message = "Cancellation Fee should not be Null")
    @NotEmpty(message = "Cancellation Fee is required")
    private double canFee;
    @NotNull(message = "Cancellation Fee should not be Null")
    private String status;
}
