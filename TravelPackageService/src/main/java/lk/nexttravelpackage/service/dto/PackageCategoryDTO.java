package lk.nexttravelpackage.service.dto;

import lk.nexttravelpackage.service.entity.HotelCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageCategoryDTO {
    private int packageCategoryId;
    private String packageCategoryName;
    private HotelCategory hotelCategories;
}
