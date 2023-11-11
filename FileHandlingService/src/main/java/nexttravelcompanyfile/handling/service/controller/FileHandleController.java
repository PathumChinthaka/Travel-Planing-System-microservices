package nexttravelcompanyfile.handling.service.controller;

import nexttravelcompanyfile.handling.service.service.custom.FileHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("")
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
public class FileHandleController {

    @Autowired
    FileHandleService fileHandleService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestPart("imageFile")MultipartFile file) throws IOException {
        String uploadImage = fileHandleService.uploadToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData=fileHandleService.downloadFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }
}
