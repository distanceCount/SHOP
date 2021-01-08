package cn.shop.upload.controller;

import cn.shop.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: UploadController
 * @Description: TODO
 * @author: yang
 * @date: 2021/1/8  15:14
 */
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){
        String uploadImageUrl = uploadService.uploadImage(file);
        return ResponseEntity.ok(uploadImageUrl);
    }
}
