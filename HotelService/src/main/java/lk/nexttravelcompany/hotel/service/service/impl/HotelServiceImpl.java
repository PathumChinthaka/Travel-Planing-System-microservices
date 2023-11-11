package lk.nexttravelcompany.hotel.service.service.impl;

import lk.nexttravelcompany.hotel.service.dto.HotelDTO;
import lk.nexttravelcompany.hotel.service.entity.Hotel;
import lk.nexttravelcompany.hotel.service.repository.HotelRepository;
import lk.nexttravelcompany.hotel.service.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final ModelMapper modelMapper;

    //save hotel details in database
    @Override
    public Mono<HotelDTO> saveHotelDetails(HotelDTO hotelDTO) {
        Hotel hotelEntity = modelMapper.map(hotelDTO, Hotel.class);
        hotelEntity.getHotelCategory().setHotelCategoryId(UUID.randomUUID().toString());
        return hotelRepository.save(hotelEntity).map(hotel ->
                modelMapper.map(hotel,HotelDTO.class));
    }

    //get required hotel details from database
    @Override
    public Mono<HotelDTO> getHotelDetails(int hotelId) {
        Mono<Hotel> findHotel = hotelRepository.findById(hotelId);
        return findHotel.map(hotelDetails -> modelMapper.map(hotelDetails,HotelDTO.class));
    }

    //get All hotel details from database
    @Override
    public Flux<HotelDTO> getAllHotelDetails() {
        Flux<Hotel> allHotelDetails = hotelRepository.findAll();
        return allHotelDetails.map(allhotels ->modelMapper.map(allhotels,HotelDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    //update hotel details in database
    @Override
    public Mono<HotelDTO>updateHotelDetails(HotelDTO hotelDTO) {
        Mono<Hotel> updateHotel = hotelRepository.findById(hotelDTO.getHotelId());
        return updateHotel.flatMap((existHotel)->{
            existHotel.setHotelName(hotelDTO.getHotelName());
            existHotel.setEmail(hotelDTO.getEmail());
            existHotel.setTelephone(hotelDTO.getTelephone());
            existHotel.setMobile(hotelDTO.getMobile());
            existHotel.setFax(hotelDTO.getFax());
            existHotel.setDescription(hotelDTO.getDescription());
            existHotel.setWebsiteLink(hotelDTO.getWebsiteLink());
            existHotel.setFacebook(hotelDTO.getFacebook());
            existHotel.setInstagram(hotelDTO.getInstagram());
            existHotel.setStatus(hotelDTO.getStatus());
            return hotelRepository.save(existHotel);
        }).map((updatedHotel -> modelMapper.map(updatedHotel, HotelDTO.class)));
    }

    //delete hotel details from database
    @Override
    public Mono<Void> deleteHotel(int hotelId) {
        return hotelRepository.deleteById(hotelId);
    }
}
