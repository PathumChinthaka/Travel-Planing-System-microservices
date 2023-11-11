package lk.nexttravelpackage.service.repository;

import lk.nexttravelpackage.service.entity.TravelPackageCategory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageCategoryRepository extends ReactiveMongoRepository<TravelPackageCategory,Integer> {
}
