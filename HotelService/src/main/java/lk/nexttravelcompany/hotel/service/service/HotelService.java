package lk.nexttravelcompany.hotel.service.service;

import lk.nexttravelcompany.hotel.service.dto.HotelDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelService {
    Mono<HotelDTO>saveHotelDetails(HotelDTO hotelDTO);
    Mono<HotelDTO>getHotelDetails(int hotelId);
    Flux<HotelDTO>getAllHotelDetails();
    Mono<HotelDTO> updateHotelDetails(HotelDTO hotelDTO);
    Mono<Void>deleteHotel(int hotelId);
}
