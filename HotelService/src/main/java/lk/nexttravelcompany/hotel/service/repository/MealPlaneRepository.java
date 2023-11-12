package lk.nexttravelcompany.hotel.service.repository;

import lk.nexttravelcompany.hotel.service.entity.HotelMealPlane;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlaneRepository extends ReactiveMongoRepository<HotelMealPlane,String> {
}
