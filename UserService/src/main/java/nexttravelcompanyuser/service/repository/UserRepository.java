package nexttravelcompanyuser.service.repository;

import nexttravelcompanyuser.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT userId FROM USER ORDER BY userId DESC LIMIT 1", nativeQuery = true)
    String generateUserId();
    boolean existsByUserId(String userId);
    User findByUserName(String userName);
    void deleteByUserId(String userId);
}
