package nexttravelcompanybooking.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookingStatusDTO {
    @NotEmpty(message = "Booking status id is required")
    private int booking_status_id;
    @NotNull(message = "Booking status name should not be Null")
    @NotEmpty(message = "Booking status name is required")
    private String booking_status_name;
}
