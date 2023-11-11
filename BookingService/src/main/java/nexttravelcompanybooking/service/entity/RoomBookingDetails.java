package nexttravelcompanybooking.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class RoomBookingDetails {
    @Id
    private int room_booking_id;
    @OneToMany(mappedBy = "roomBookingDetails")
    private List<HotelBookingDetails>hotelBookingId;
    private int room_id;
    private double price;
    private double discount;
    private int can_policy_id;
    private double can_fee;
    private String status;
}
