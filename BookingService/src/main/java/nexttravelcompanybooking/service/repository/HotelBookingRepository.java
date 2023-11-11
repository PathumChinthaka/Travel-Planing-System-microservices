package nexttravelcompanybooking.service.repository;

import nexttravelcompanybooking.service.entity.HotelBookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBookingDetails,Integer> {
}
