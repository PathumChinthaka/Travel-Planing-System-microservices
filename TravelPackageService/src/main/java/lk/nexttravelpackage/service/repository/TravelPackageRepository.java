package lk.nexttravelpackage.service.repository;

import lk.nexttravelpackage.service.entity.TravelPackage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TravelPackageRepository extends ReactiveMongoRepository<TravelPackage,String> {
    Mono<TravelPackage>findByPackageName(String packageName);
    Mono<Void>deleteByPackageId(String packageId);
}
