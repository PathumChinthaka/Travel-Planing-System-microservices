package lk.nexttravelpackage.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Travel_package_category")
public class TravelPackageCategory {
    @Id
    private int packageCategoryId;
    private String packageCategoryName;
    private HotelCategory hotelCategories;
}
