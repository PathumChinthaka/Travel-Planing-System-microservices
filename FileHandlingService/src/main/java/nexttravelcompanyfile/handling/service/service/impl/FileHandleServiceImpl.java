package nexttravelcompanyfile.handling.service.service.impl;

import nexttravelcompanyfile.handling.service.entity.FileData;
import nexttravelcompanyfile.handling.service.repository.FileRepository;
import nexttravelcompanyfile.handling.service.service.custom.FileHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FileHandleServiceImpl implements FileHandleService {

    @Autowired
    FileRepository fileRepository;

    private final String FOLDER_PATH="D:/Spring-Boot-Projects/NextTravelAssets/";

    @Override
    public String uploadToFileSystem(MultipartFile file) throws IOException {

        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileRepository.save(FileData.builder()
                .id(UUID.randomUUID().toString())
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    @Override
    public byte[] downloadFromFileSystem(String fileName) throws IOException {

        List<FileData> fileDataList = fileRepository.findByFileName(fileName);

        if (!fileDataList.isEmpty()) {
            FileData fileData = fileDataList.get(0);
            String filePath = fileData.getFilePath();
            return Files.readAllBytes(new File(filePath).toPath());
        } else {
            throw new FileNotFoundException("File not found: " + fileName);
        }
    }


}
