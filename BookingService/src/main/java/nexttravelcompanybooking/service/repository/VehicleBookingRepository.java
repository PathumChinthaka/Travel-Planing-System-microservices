package nexttravelcompanybooking.service.repository;

import nexttravelcompanybooking.service.entity.VehicleBookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBookingRepository extends JpaRepository<VehicleBookingDetails,Integer> {
}
