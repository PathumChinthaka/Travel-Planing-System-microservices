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
public class Booking {
    @Id
    private int bookingId;
    private int travelPackageId;
    private String bookingStartDate;
    private String bookingEndDate;
    private int promotionId;
    private int customerId;
    private String createDate;
    private double travelPackageDiscount;
    private double totalPrice;
    private double totalDiscountPrice;
    private double paidAmount;
    private String paidSlipt;
    @OneToOne
    private BookingStatus bookingStatusId;
    private String cancelDate;
    private double cancelFee;
    private String reduntDate;
    private double refundAmount;
    private String status;
}
