package cn.shop.upload.service;

import cn.shop.common.constants.ShopConstants;
import cn.shop.common.exception.pojo.ExceptionEnum;
import cn.shop.common.exception.pojo.ShopException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @ClassName: UploadService
 * @Description: 文件上传service
 * @author: yang
 * @date: 2021/1/8  15:36
 */
@Service
public class UploadService {
    public String uploadImage(MultipartFile file){
        //判断上传的文件是否为图片
        try {
            InputStream inputStream = file.getInputStream();
            BufferedImage read = ImageIO.read(inputStream);
            if (read == null){
                throw new ShopException(ExceptionEnum.INVALID_FILE_TYPE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ShopException(ExceptionEnum.INVALID_FILE_TYPE);
        }

        //生成文件名称
        String uuid = UUID.randomUUID().toString();
        // 获取源文件名称
        String filename = file.getOriginalFilename();
        //获取文件后缀名
        String extName = filename.substring(filename.lastIndexOf("."));
        //最终文件名
        String lastName = uuid+extName;
        //把图片保存到nginx目录中
        try {
            file.transferTo(new File(ShopConstants.IMAGE_PATH,lastName));
            return ShopConstants.IMAGE_URL+lastName;
        } catch (IOException e) {
            e.printStackTrace();
            throw new ShopException(ExceptionEnum.FILE_UPLOAD_ERROR);
        }
    }
}
