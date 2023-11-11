package nexttravelcompanybooking.service.repository;

import nexttravelcompanybooking.service.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus,Integer> {
}
