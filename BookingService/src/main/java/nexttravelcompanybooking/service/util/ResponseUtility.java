package nexttravelcompanybooking.service.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseUtility {
    private int code;
    private String message;
    Object data;
}
