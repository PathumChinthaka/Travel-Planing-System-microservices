package lk.nexttravelcompany.hotel.service.repository;

import lk.nexttravelcompany.hotel.service.entity.HotelCategory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelCategoryRepository extends ReactiveCrudRepository<HotelCategory,String> {
}
