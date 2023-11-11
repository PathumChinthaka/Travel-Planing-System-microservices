package nexttravelcompanybooking.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookingDTO {
    private int booking_id;
    private int travel_package_id;
    private String booking_Start;
    private String booking_End_Date;
    private int promotion_id;
    private int customer_id;
    private String createDate;
    private double travel_package_discount_price;
    private double total_price;
    private double total_discount_price;
    private double paid_amount;
    private byte[] paid_slip;
    private int booking_status_id;
    private String cancel_date;
    private double cancel_fee;
    private String redunt_date;
    private double refund_amount;
    private String status;
}
