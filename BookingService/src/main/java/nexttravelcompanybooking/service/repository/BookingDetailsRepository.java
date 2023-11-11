package nexttravelcompanybooking.service.repository;

import nexttravelcompanybooking.service.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends JpaRepository<Booking,Integer> {
}
