package lk.nexttravelcompany.hotel.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Meal_Plane")
public class HotelMealPlane {
    @Id
    private String mealPlaneId;
    private String mealPlaneName;
    private String status;
}
