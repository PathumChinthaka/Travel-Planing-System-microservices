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
    private int roomBookingId;
    @OneToMany(mappedBy = "roomBookingDetails")
    private List<HotelBookingDetails>hotelBookingId;
    private int roomId;
    private double price;
    private double discount;
    private int canPolicyId;
    private double canFee;
    private String status;
}
