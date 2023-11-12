package lk.nexttravelcompany.hotel.service.repository;

import lk.nexttravelcompany.hotel.service.entity.RoomType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends ReactiveMongoRepository<RoomType,String> {
}
