package lk.nexttravelpackage.service.service;

import lk.nexttravelpackage.service.dto.PackageCategoryDTO;
import lk.nexttravelpackage.service.dto.TravelPackageDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TravelPackageService {
    Mono<TravelPackageDTO> savePackage(TravelPackageDTO packageDTO);
    Mono<PackageCategoryDTO>savePackageCategory(PackageCategoryDTO packageCategoryDTO);
    Mono<TravelPackageDTO>getPackage(String packageName);
    Flux<TravelPackageDTO> getAllPackages();
    Flux<PackageCategoryDTO> getAllPackageCategories();
    Mono<TravelPackageDTO>updatePackage(TravelPackageDTO packageDTO);
    Mono<Void>deletePackage(String packageId);
}
