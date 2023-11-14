package lk.nexttravelcompany.hotel.service.service.impl;

import lk.nexttravelcompany.hotel.service.dto.*;
import lk.nexttravelcompany.hotel.service.entity.*;
import lk.nexttravelcompany.hotel.service.repository.HotelCategoryRepository;
import lk.nexttravelcompany.hotel.service.repository.HotelRepository;
import lk.nexttravelcompany.hotel.service.repository.MealPlaneRepository;
import lk.nexttravelcompany.hotel.service.repository.RoomTypeRepository;
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

    private final HotelCategoryRepository hotelCategoryRepository;

    private final MealPlaneRepository mealPlaneRepository;

    private final RoomTypeRepository roomTypeRepository;

    //save hotel details in database
    @Override
    public Mono<HotelDTO> saveHotelDetails(HotelDTO hotelDTO) {

        Hotel hotelEntity = modelMapper.map(hotelDTO, Hotel.class);

        hotelDTO.getRoomDetailsDTOList().forEach(roomDTO -> System.out.println(roomDTO.toString()));

        hotelEntity.setRoomDetailsList(
                hotelDTO.getRoomDetailsDTOList().stream()
                        .map(roomDetails -> modelMapper.map(roomDetails, RoomDetails.class)).toList()
        );

        System.out.println(hotelEntity.getRoomDetailsList().toString());

        return hotelRepository.save(hotelEntity)
                .map(savedHotel -> {
                    HotelDTO savedHotelDTO = modelMapper.map(savedHotel, HotelDTO.class);

                    savedHotelDTO.setHotelCategoryDTO(modelMapper.map(savedHotel.getHotelCategory(), HotelCategoryDTO.class));

                    savedHotelDTO.setRoomDetailsDTOList(savedHotel.getRoomDetailsList().stream().map(roomDetails -> {

                        RoomDetailsDTO roomDTO = modelMapper.map(roomDetails, RoomDetailsDTO.class);
                        roomDTO.setHotelRoomTypeDTOList(roomDetails.getHotelRoomTypeDTOList().stream().map(
                                hotelRoomType -> modelMapper.map(hotelRoomType, HotelRoomTypeDTO.class)
                        ).toList());
                        roomDTO.setHotelMealPlaneDTOList(roomDetails.getHotelMealPlaneDTOList().stream().map(
                                hotelMealPlane -> modelMapper.map(hotelMealPlane, HotelMealPlaneDTO.class)
                        ).toList());
                        return roomDTO;

                    }).toList());
                    return savedHotelDTO;
                });
    }

    //get required hotel details from database
    @Override
    public Mono<HotelDTO> getHotelDetails(String hotelId) {
        Mono<Hotel> findHotel = hotelRepository.findById(hotelId);
        return findHotel.map(hotelDetails -> modelMapper.map(hotelDetails, HotelDTO.class));
    }

    //get All hotel details from database
    @Override
    public Flux<HotelDTO> getAllHotelDetails() {
        return hotelRepository.findAll().map(hotel -> {
            HotelDTO hotelDTO = modelMapper.map(hotel, HotelDTO.class);
            hotelDTO.setHotelCategoryDTO(modelMapper.map(hotel.getHotelCategory(), HotelCategoryDTO.class));
            hotelDTO.setRoomDetailsDTOList(hotel.getRoomDetailsList().stream().map(roomDetails -> {
                RoomDetailsDTO roomDTO = modelMapper.map(roomDetails, RoomDetailsDTO.class);
                roomDTO.setHotelRoomTypeDTOList(roomDetails.getHotelRoomTypeDTOList().stream().map(
                        hotelRoomType -> modelMapper.map(hotelRoomType, HotelRoomTypeDTO.class)
                ).toList());
                roomDTO.setHotelMealPlaneDTOList(roomDetails.getHotelMealPlaneDTOList().stream().map(
                        hotelMealPlane -> modelMapper.map(hotelMealPlane, HotelMealPlaneDTO.class)
                ).toList());
                return roomDTO;
            }).toList());
            return hotelDTO;
        });
    }

    //update hotel details in database
    @Override
    public Mono<HotelDTO> updateHotelDetails(HotelDTO hotelDTO, String hotelId) {
        Hotel saveHotel = modelMapper.map(hotelDTO, Hotel.class);
        Mono<Hotel> updateHotel = hotelRepository.findById(saveHotel.getHotelId());

        if (updateHotel != null) {
            return hotelRepository.save(saveHotel).map(hotel -> modelMapper.map(hotel, HotelDTO.class));
        }
        return updateHotel.map(hotel -> modelMapper.map(hotel, HotelDTO.class));
    }

    //delete hotel details from database
    @Override
    public Mono<Void> deleteHotel(String hotelId) {
        return hotelRepository.deleteById(hotelId);
    }


    @Override
    public Mono<HotelCategoryDTO> saveHotelCategory(HotelCategoryDTO hotelCategoryDTO) {
        HotelCategory saveHotelCategory = modelMapper.map(hotelCategoryDTO, HotelCategory.class);
        return hotelCategoryRepository.save(saveHotelCategory)
                .map(savedHotelCategory -> modelMapper.map(savedHotelCategory, HotelCategoryDTO.class));
    }

    @Override
    public Flux<HotelCategoryDTO> getAllHotelCategory() {
        return hotelCategoryRepository.findAll().map(hotelCategory -> modelMapper.map(hotelCategory, HotelCategoryDTO.class));
    }

    @Override
    public Mono<HotelDTO> getHotelDetailById(String hotelId) {
        return hotelRepository.findById(hotelId).map(hotel -> modelMapper.map(hotel, HotelDTO.class));
    }

    @Override
    public Mono<HotelCategoryDTO> getHotelCategoryById(String hotelCategoryId) {
        return hotelCategoryRepository.findById(hotelCategoryId).map(hotelCategory -> modelMapper.map(hotelCategory, HotelCategoryDTO.class));
    }

    @Override
    public Mono<HotelCategoryDTO> updateHotelCategory(HotelCategoryDTO hotelCategoryDTO, String hotelCategoryId) {
        HotelCategory saveHotelCategory = modelMapper.map(hotelCategoryDTO, HotelCategory.class);
        Mono<HotelCategory> updateHotelCategory = hotelCategoryRepository.findById(saveHotelCategory.getHotelCategoryId());

        if (updateHotelCategory != null) {
            return hotelCategoryRepository.save(saveHotelCategory).map(hotelCategory -> modelMapper.map(hotelCategory, HotelCategoryDTO.class));
        }
        return updateHotelCategory.map(hotelCategory -> modelMapper.map(hotelCategory, HotelCategoryDTO.class));
    }

    @Override
    public Mono<Void> deleteHotelCategory(String hotelCategoryId) {
        return hotelCategoryRepository.deleteById(hotelCategoryId);
    }

    @Override
    public Mono<HotelMealPlaneDTO> saveMealPlane(HotelMealPlaneDTO mealPlaneDTO) {
        HotelMealPlane saveMealPlane = modelMapper.map(mealPlaneDTO, HotelMealPlane.class);
        return mealPlaneRepository.save(saveMealPlane).map(mealPlane -> modelMapper.map(mealPlane, HotelMealPlaneDTO.class));
    }

    @Override
    public Mono<RoomTypeDTO> saveRoomType(RoomTypeDTO roomTypeDTO) {
        RoomType saveRoomType = modelMapper.map(roomTypeDTO, RoomType.class);
        return roomTypeRepository.save(saveRoomType).map(roomType -> modelMapper.map(roomType, RoomTypeDTO.class));
    }
}
