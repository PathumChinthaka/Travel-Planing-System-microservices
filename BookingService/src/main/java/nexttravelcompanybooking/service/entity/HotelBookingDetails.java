package nexttravelcompanybooking.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class HotelBookingDetails {
    @Id
    private int hotelBookingId;
    @OneToOne
    private Booking bookingId;
    private int hotelId;
    private double calPrice;
    private double discountPrice;
    private double hotelPrice;
    private String status;
    @ManyToOne
    private RoomBookingDetails roomBookingDetails;
}
