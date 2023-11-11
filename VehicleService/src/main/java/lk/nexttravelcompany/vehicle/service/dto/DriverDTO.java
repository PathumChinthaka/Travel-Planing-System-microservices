package lk.nexttravelcompany.vehicle.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private int driver_id;
    private String driver_name;
    private String driver_contact_No;
    private byte[] driver_licen_front;
    private byte[] driver_licen_back;
}
