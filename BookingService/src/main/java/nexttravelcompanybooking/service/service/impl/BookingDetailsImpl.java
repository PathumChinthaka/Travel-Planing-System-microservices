package nexttravelcompanybooking.service.service.impl;

import lombok.RequiredArgsConstructor;
import nexttravelcompanybooking.service.dto.BookingDTO;
import nexttravelcompanybooking.service.dto.BookingStatusDTO;
import nexttravelcompanybooking.service.dto.GuideBookingDetailsDTO;
import nexttravelcompanybooking.service.dto.HotelBookingDetailsDTO;
import nexttravelcompanybooking.service.entity.Booking;
import nexttravelcompanybooking.service.entity.BookingStatus;
import nexttravelcompanybooking.service.entity.GuideBookingDetails;
import nexttravelcompanybooking.service.entity.HotelBookingDetails;
import nexttravelcompanybooking.service.repository.*;
import nexttravelcompanybooking.service.service.BookingDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingDetailsImpl implements BookingDetailsService {

    private final ModelMapper modelMapper;

    private final BookingDetailsRepository bookingRepository;

    private final BookingStatusRepository statusRepository;

    private final GuideBookingRepository guideBookingRepository;

    private final HotelBookingRepository hotelBookingRepository;

    private final VehicleBookingRepository vehicleBookingRepository;

    //save booking in database
    @Override
    public void saveBookingDetails(BookingDTO bookingDTO) {
        bookingRepository.save(modelMapper.map(bookingDTO, Booking.class));
    }

    //get booking data from database
    @Override
    public BookingDTO getBookingData(int booking_id) {
        Optional<Booking> bookingData = bookingRepository.findById(booking_id);
        return modelMapper.map(bookingData, BookingDTO.class);
    }

    //get all booking data from database
    @Override
    public List<Booking> getAllBookingDetails() {
        return bookingRepository.findAll();
    }

    //Delete booking data from database
    @Override
    public void deleteBookingData(int booking_Id) {
        bookingRepository.deleteById(booking_Id);
    }

    //save bookingStatus in database
    @Override
    public void saveBookingStatus(BookingStatusDTO bookingStatusDTO) {
        statusRepository.save(modelMapper.map(bookingStatusDTO, BookingStatus.class));
    }

    //getAll bookingStatus from database
    @Override
    public List<BookingStatus> getAllBookingStatus() {
        return statusRepository.findAll();
    }

    //save Guide booking data in database
    @Override
    public void saveGuideBooking(GuideBookingDetailsDTO guideBookingDTO) {
        if (!guideBookingRepository.existsById(guideBookingDTO.getGuidBookingId())) {
            guideBookingRepository.save(modelMapper.map(guideBookingDTO, GuideBookingDetails.class));
        } else {
            throw new RuntimeException(guideBookingDTO.getGuidBookingId() + " Guide Already Exist");
        }
    }

    //get all Guide booking data from database
    @Override
    public List<GuideBookingDetails> getAllGuideBookings() {
        return guideBookingRepository.findAll();
    }

    //delete Guide booking data from database
    @Override
    public void deleteGuideBooking(int guidId) {
        guideBookingRepository.deleteById(guidId);
    }

    //Save Hotel booking data in database
    @Override
    public void saveHotelBooking(HotelBookingDetailsDTO hotelBookingDetailsDTO) {
        hotelBookingRepository.save(modelMapper.map(hotelBookingDetailsDTO,HotelBookingDetails.class));
    }

    //update Hotel booking data in database
    @Override
    public void updateHotelBooking(HotelBookingDetailsDTO hotelBookingDetailsDTO) {
        if (!hotelBookingRepository.existsById(hotelBookingDetailsDTO.getHotelBookingId())){
            hotelBookingRepository.save(modelMapper.map(hotelBookingDetailsDTO, HotelBookingDetails.class));
        }else {
            throw new RuntimeException(hotelBookingDetailsDTO.getBookingId()+" HotelBookingID Not Exist");
        }

    }

    //delete Hotel booking data from database
    @Override
    public void deleteHotelBooking(int booking_Id) {
        hotelBookingRepository.deleteById(booking_Id);
    }

    //getAll Hotel booking data from database
    @Override
    public List<HotelBookingDetails> getAllHotelBookings() {
        return hotelBookingRepository.findAll();
    }




}
