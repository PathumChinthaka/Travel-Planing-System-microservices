package lk.nexttravelpackage.service.service.impl;

import lk.nexttravelpackage.service.dto.PackageCategoryDTO;
import lk.nexttravelpackage.service.dto.TravelPackageDTO;
import lk.nexttravelpackage.service.entity.TravelPackage;
import lk.nexttravelpackage.service.entity.TravelPackageCategory;
import lk.nexttravelpackage.service.repository.PackageCategoryRepository;
import lk.nexttravelpackage.service.repository.TravelPackageRepository;
import lk.nexttravelpackage.service.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PackageServiceImpl implements TravelPackageService {

    private final TravelPackageRepository packageRepository;

    private final PackageCategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    //save travel packages in database
    @Override
    public Mono<TravelPackageDTO> savePackage(TravelPackageDTO packageDTO) {
        TravelPackage travelPackage = modelMapper.map(packageDTO, TravelPackage.class);
        travelPackage.setPackageId(UUID.randomUUID().toString());
        return packageRepository.save(travelPackage)
                .map(savedPackage -> modelMapper.map(savedPackage, TravelPackageDTO.class));
    }

    @Override
    public Mono<PackageCategoryDTO> savePackageCategory(PackageCategoryDTO packageCategoryDTO) {
        TravelPackageCategory packageCategory = modelMapper
                .map(packageCategoryDTO, TravelPackageCategory.class);
        packageCategory.getHotelCategories().setHotelCategoryId
                (UUID.randomUUID().toString());
        return categoryRepository.save(packageCategory).map(savedCategory -> modelMapper
                .map(savedCategory, PackageCategoryDTO.class));

    }

    //get travel package from database
    @Override
    public Mono<TravelPackageDTO> getPackage(String packageName) {
        Mono<TravelPackage> byPackageName = packageRepository.findByPackageName(packageName);
        return byPackageName.map(getPackage -> modelMapper.map(getPackage, TravelPackageDTO.class));
    }

    //get All travel packages from database
    @Override
    public Flux<TravelPackageDTO> getAllPackages() {
        Flux<TravelPackage> allPackages = packageRepository.findAll();
        return allPackages.map(travelPackages -> modelMapper.map(travelPackages, TravelPackageDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    //get All package categories from database
    @Override
    public Flux<PackageCategoryDTO> getAllPackageCategories() {
        Flux<TravelPackageCategory> allPackageCategory = categoryRepository.findAll();
        return allPackageCategory.map(allCategory -> modelMapper.map(allCategory, PackageCategoryDTO.class))
                .switchIfEmpty(Flux.empty());
    }

    //update travel packages in database
    @Override
    public Mono<TravelPackageDTO> updatePackage(TravelPackageDTO packageDTO) {
        Mono<TravelPackage> updatePackage = packageRepository.findById(packageDTO.getPackageId());
        return updatePackage.flatMap((existPackage) -> {
            existPackage.setPackageName(packageDTO.getPackageName());
            existPackage.setPackageCategory(packageDTO.getPackageCategory());
            existPackage.setPackageDescription(packageDTO.getPackageDescription());
            existPackage.setAllowPets(packageDTO.getAllowPets());
            existPackage.setRoomTypes(packageDTO.getRoomTypes());
            existPackage.setTravelAreas(packageDTO.getTravelAreas());
            existPackage.setTravelPackageVideoUrl(packageDTO.getTravelPackageVideoUrl());
            return packageRepository.save(existPackage);
        }).map((travelPackage -> modelMapper.map(travelPackage, TravelPackageDTO.class)));
    }

    //delete travel package from database
    @Override
    public Mono<Void> deletePackage(String packageId) {
        return packageRepository.deleteByPackageId(packageId);
    }
}
