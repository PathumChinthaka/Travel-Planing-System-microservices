package nexttravelcompanybooking.service.service;

import nexttravelcompanybooking.service.dto.*;
import nexttravelcompanybooking.service.entity.Booking;
import nexttravelcompanybooking.service.entity.BookingStatus;
import nexttravelcompanybooking.service.entity.GuideBookingDetails;
import nexttravelcompanybooking.service.entity.HotelBookingDetails;

import java.util.List;

public interface BookingDetailsService {
    //Booking details
    void saveBookingDetails(BookingDTO bookingDTO);
    BookingDTO getBookingData(int bookingId);
    List<Booking> getAllBookingDetails();
    void deleteBookingData(int bookingId);
    //booking status
    void saveBookingStatus(BookingStatusDTO bookingStatusDTO);
    List<BookingStatus> getAllBookingStatus();
    //guide booking Details
    void saveGuideBooking(GuideBookingDetailsDTO guideBookingDTO);
    List<GuideBookingDetails> getAllGuideBookings();
    void deleteGuideBooking(int guidId);
    //Hotel booking Details
    void saveHotelBooking(HotelBookingDetailsDTO hotelBookingDetailsDTO);
    void updateHotelBooking(HotelBookingDetailsDTO hotelBookingDetailsDTO);
    void deleteHotelBooking(int bookingId);
    List<HotelBookingDetails>getAllHotelBookings();
    //vehicle booking
//    void saveVehicleBookingDetails(VehicleBookingDetailsDTO vehicleBookingDTO);
//    VehicleBookingDetailsDTO getVehicleBookingData();
}
