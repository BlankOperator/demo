package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.pojo.Officeimage;
import com.example.demo.pojo.Vehicleimage;
import com.example.demo.service.OfficeimageService;
import com.example.demo.service.VehicleService;
import com.example.demo.service.VehicleimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {
    @Value("${imageUrl}")
    private String imageUrl;
    @Autowired
    private OfficeimageService officeimageService;
    @Autowired
    private VehicleimageService vehicleimageService;
    @PostMapping("/officeImage/{id}")
    public Boolean uploadOfficeImage(MultipartFile file, @PathVariable Integer id) {
        String originalFilename = file.getOriginalFilename();
        String suffix = FileUtil.extName(originalFilename);
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        File rootFile = new File(rootPath + this.imageUrl);
        System.out.println(rootFile);
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }
        while (true) {
            String avatarName = UUID.randomUUID().toString() + StrUtil.DOT + suffix;
            File imageFile = new File(rootPath + this.imageUrl + avatarName);
            if (!imageFile.exists()) {
                try {
                    file.transferTo(imageFile);
                    Officeimage officeimage = new Officeimage();
                    officeimage.setOfficeId(id);
                    officeimage.setName(avatarName);
                    officeimageService.save(officeimage);
                } catch (Exception e) {
                    throw new RuntimeException("更新头像失败", e);
                }
                return true;
            }
        }
    }

    @PostMapping("/vehicleImage/{id}")
    public Boolean uploadVehicleImage(MultipartFile file, @PathVariable Integer id) {
        String originalFilename = file.getOriginalFilename();
        String suffix = FileUtil.extName(originalFilename);
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        File rootFile = new File(rootPath + this.imageUrl);
        System.out.println(rootFile);
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }
        while (true) {
            String avatarName = UUID.randomUUID().toString() + StrUtil.DOT + suffix;
            File imageFile = new File(rootPath + this.imageUrl + avatarName);
            if (!imageFile.exists()) {
                try {
                    file.transferTo(imageFile);
                    Vehicleimage vehicleimage = new Vehicleimage();
                    vehicleimage.setVehicleId(id);
                    vehicleimage.setName(avatarName);
                    vehicleimageService.save(vehicleimage);
                } catch (Exception e) {
                    throw new RuntimeException("更新头像失败", e);
                }
                return true;
            }
        }
    }
}
