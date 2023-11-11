package nexttravelcompanybooking.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class VehicleBookingDetails {
    @Id
    private int vehicle_booking_id;
    @OneToOne
    private Booking booking_id;
    private int vehicle_id;
    private double price;
    private double discount;
    private int can_policy_id;
    private double can_fee;
    private String status;
}
