package nexttravelcompanybooking.service.repository;

import nexttravelcompanybooking.service.entity.GuideBookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideBookingRepository extends JpaRepository<GuideBookingDetails,Integer> {
}
