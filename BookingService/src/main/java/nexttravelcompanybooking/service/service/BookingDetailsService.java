package nexttravelcompanybooking.service.service;

import nexttravelcompanybooking.service.dto.BookingDTO;
import nexttravelcompanybooking.service.dto.BookingStatusDTO;
import nexttravelcompanybooking.service.dto.GuideBookingDetailsDTO;
import nexttravelcompanybooking.service.dto.HotelBookingDetailsDTO;
import nexttravelcompanybooking.service.entity.Booking;
import nexttravelcompanybooking.service.entity.BookingStatus;
import nexttravelcompanybooking.service.entity.GuideBookingDetails;
import nexttravelcompanybooking.service.entity.HotelBookingDetails;

import java.util.List;

public interface BookingDetailsService {
    //Booking details
    void saveBookingDetails(BookingDTO bookingDTO);
    BookingDTO getBookingData(int booking_id);
    List<Booking> getAllBookingDetails();
    void deleteBookingData(int booking_Id);
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
    void deleteHotelBooking(int booking_Id);
    List<HotelBookingDetails>getAllHotelBookings();
}
