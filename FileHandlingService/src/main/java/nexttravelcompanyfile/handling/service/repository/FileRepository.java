package nexttravelcompanyfile.handling.service.repository;

import nexttravelcompanyfile.handling.service.entity.FileData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FileRepository extends MongoRepository<FileData,String> {
    List<FileData> findByFileName(String fileName);
}
