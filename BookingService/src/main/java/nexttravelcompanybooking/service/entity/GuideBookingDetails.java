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
public class GuideBookingDetails {
    @Id
    private int guidBookingId;
    @OneToOne
    private Booking bookingId;
    private int guidId;
    private double price;
    private double discount;
    private int canPolicyId;
    private double canFee;
    private String status;
}
