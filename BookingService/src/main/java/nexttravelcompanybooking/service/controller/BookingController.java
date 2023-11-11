package nexttravelcompanybooking.service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nexttravelcompanybooking.service.dto.BookingDTO;
import nexttravelcompanybooking.service.dto.BookingStatusDTO;
import nexttravelcompanybooking.service.dto.GuideBookingDetailsDTO;
import nexttravelcompanybooking.service.dto.HotelBookingDetailsDTO;
import nexttravelcompanybooking.service.entity.Booking;
import nexttravelcompanybooking.service.entity.BookingStatus;
import nexttravelcompanybooking.service.entity.GuideBookingDetails;
import nexttravelcompanybooking.service.entity.HotelBookingDetails;
import nexttravelcompanybooking.service.service.BookingDetailsService;
import nexttravelcompanybooking.service.util.ResponseUtility;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingDetailsService bookingService;

    //  handle booking Post request
    @PostMapping("/savebooking")
    public ResponseUtility saveBookingDetails(@RequestBody BookingDTO bookingDTO) {
        bookingService.saveBookingDetails(bookingDTO);
        return new ResponseUtility(200, "Booking Details saved", null);
    }

    //  handle get booking request
    @GetMapping("{bookingId}")
    public ResponseUtility getBookingData(@PathVariable int bookingId) {
        BookingDTO bookingData = bookingService.getBookingData(bookingId);
        return new ResponseUtility(200, "fetch booking data", bookingData);
    }

    //  handle getAll booking request
    @GetMapping("/getAll")
    public ResponseUtility getAllBookingDetails() {
        List<Booking> allBookings = bookingService.getAllBookingDetails();
        return new ResponseUtility(200, "Fetch all Booking Details", allBookings);
    }

    //  handle delete booking request
    @DeleteMapping("{bookingId}")
    public ResponseUtility deleteBookingData(@PathVariable int bookingId) {
        bookingService.deleteBookingData(bookingId);
        return new ResponseUtility(200, bookingId + "Deleted succesfully", null);
    }

    //  handle post bookingStatus request
    @PostMapping("/bookingStatus/save")
    public ResponseUtility saveBookingStatus(@Valid @RequestBody BookingStatusDTO bookingStatusDTO) {
        System.out.println("booking status :"+bookingStatusDTO);
        return null;
//        bookingService.saveBookingStatus(bookingStatusDTO);
//        return new ResponseUtility(200, "Booking status saved", null);
    }

    //  handle get All bookingStatus request
    @GetMapping("/bookingstatus/getAll")
    public ResponseUtility getAllBookingStatus() {
        List<BookingStatus> allBookingStatus = bookingService.getAllBookingStatus();
        return new ResponseUtility(200, "All Booking status", allBookingStatus);
    }

    //  handle post GuideBooking request
    @PostMapping("/bookguide/save")
    public ResponseUtility saveGuideBooking(@RequestBody GuideBookingDetailsDTO bookingDetailsDTO) {
        bookingService.saveGuideBooking(bookingDetailsDTO);
        return new ResponseUtility(200, "GuideBooking Saved", null);
    }

    //  handle get All GuideBookings request
    @GetMapping("/bookguide/getAll")
    public ResponseUtility getAllGuideBookings() {
        List<GuideBookingDetails> allGuideBookings = bookingService.getAllGuideBookings();
        return new ResponseUtility(200, "All Guide Bookings", allGuideBookings);
    }

    //  handle delete GuideBooking request
    @DeleteMapping("{guideId}")
    public ResponseUtility getAllGuideBookings(@PathVariable int guideId) {
        bookingService.deleteGuideBooking(guideId);
        return new ResponseUtility(200, guideId + " GuideBooking Deleted", null);
    }

    //  handle post HotelBooking request
    @PostMapping("/hotelbooking/save")
    public ResponseUtility saveHotelBookings(@RequestBody HotelBookingDetailsDTO hotelBookingDTO) {
        bookingService.saveHotelBooking(hotelBookingDTO);
        return new ResponseUtility(200, "Hotel Booking saved", null);
    }

    //  handle Update HotelBooking request
    @PutMapping("/hotelbooking/update")
    public ResponseUtility updateHotelBookings(@RequestBody HotelBookingDetailsDTO hotelBookingDTO) {
        bookingService.updateHotelBooking(hotelBookingDTO);
        int bookingId = hotelBookingDTO.getBooking_id();
        return new ResponseUtility(200, bookingId + " Updated Successfully", null);
    }

    //  handle delete HotelBooking request
    @DeleteMapping("{hotelBookingId}")
    public ResponseUtility deleteHotelBookings(@PathVariable int hotelBookingId) {
        bookingService.deleteHotelBooking(hotelBookingId);
        return new ResponseUtility(200, hotelBookingId + " Deleted Successfully", null);
    }

    //  handle getAll HotelBooking request
    @GetMapping("/hotelbooking/getAll")
    public ResponseUtility getAllHotelBookings() {
        List<HotelBookingDetails> allHotelBookings = bookingService.getAllHotelBookings();
        return new ResponseUtility(200, "Fetch All Booking details",allHotelBookings);
    }

}
