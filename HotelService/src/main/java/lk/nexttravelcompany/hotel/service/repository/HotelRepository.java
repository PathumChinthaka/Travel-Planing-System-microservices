package lk.nexttravelcompany.hotel.service.repository;

import lk.nexttravelcompany.hotel.service.entity.Hotel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface HotelRepository extends ReactiveMongoRepository<Hotel,Integer> {
    Mono<Hotel>findByHotelName(String hotelName);
}
