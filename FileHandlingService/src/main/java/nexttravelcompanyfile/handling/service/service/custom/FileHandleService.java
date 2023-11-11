package nexttravelcompanyfile.handling.service.service.custom;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileHandleService {
   String uploadToFileSystem(MultipartFile file) throws IOException;
   byte[] downloadFromFileSystem(String fileName) throws IOException;
}
