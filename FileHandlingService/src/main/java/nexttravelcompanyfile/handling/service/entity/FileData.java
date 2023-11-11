package nexttravelcompanyfile.handling.service.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "File_Data")
public class FileData {
    @Id
    private String id;
    private String fileName;
    private String fileType;
    private String filePath;
}
