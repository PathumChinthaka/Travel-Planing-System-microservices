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
    private int hotel_Booking_Id;
    @OneToOne
    private Booking booking;
    private int hotel_id;
    private double cal_price;
    private double discount_price;
    private double hotel_price;
    private String status;
    @ManyToOne
    private RoomBookingDetails roomBookingDetails;
}
