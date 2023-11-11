package nexttravelcompanybooking.service.repository;

import nexttravelcompanybooking.service.entity.RoomBookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBookingDetails,Integer> {
}
