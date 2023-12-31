package lk.nexttravelpackage.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(value = "Travel_area")
public class TravelArea {
    @Id
    private int travelAreaId;
    private String travelAreaName;
}
