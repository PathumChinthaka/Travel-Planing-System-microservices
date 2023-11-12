package lk.nexttravelcompany.hotel.service.service;

import lk.nexttravelcompany.hotel.service.dto.HotelCategoryDTO;
import lk.nexttravelcompany.hotel.service.dto.HotelDTO;
import lk.nexttravelcompany.hotel.service.dto.HotelMealPlaneDTO;
import lk.nexttravelcompany.hotel.service.dto.RoomTypeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelService {

    Mono<HotelDTO>saveHotelDetails(HotelDTO hotelDTO);

    Mono<HotelDTO>getHotelDetails(String hotelId);

    Flux<HotelDTO>getAllHotelDetails();

    Mono<HotelDTO> updateHotelDetails(HotelDTO hotelDTO, String hotelId);

    Mono<Void>deleteHotel(String hotelId);

    Mono<HotelCategoryDTO> saveHotelCategory(HotelCategoryDTO hotelCategoryDTO);

    Flux<HotelCategoryDTO> getAllHotelCategory();

    Mono<HotelDTO> getHotelDetailById(String hotelId);

    Mono<HotelCategoryDTO> getHotelCategoryById(String hotelCategoryId);

    Mono<HotelCategoryDTO> updateHotelCategory(HotelCategoryDTO hotelCategoryDTO, String hotelCategoryId);

    Mono<Void> deleteHotelCategory(String hotelCategoryId);

    Mono<HotelMealPlaneDTO> saveMealPlane(HotelMealPlaneDTO mealPlaneDTO);

    Mono<RoomTypeDTO> saveRoomType(RoomTypeDTO roomTypeDTO);
}
