package com.neobis.vacationtrip.services;


import com.neobis.vacationtrip.dtos.ImageRequestDto;

import com.neobis.vacationtrip.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.Map;


@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final CloudinaryService cloudinaryService;


//    public ResponseEntity<Map> uploadImage(ImageRequestDto imageModel) {
//        try {
//            if (imageModel.getName().isEmpty()) {
//                return ResponseEntity.badRequest().build();
//            }
//            if (imageModel.getFile().isEmpty()) {
//                return ResponseEntity.badRequest().build();
//            }
//            Image image = new Image();
//            image.setName(imageModel.getName());
//            image.setUrl(cloudinaryService.uploadFile(imageModel.getFile(), "folder_1"));
//            if (image.getUrl() == null) {
//                return ResponseEntity.badRequest().build();
//            }
//            imageRepository.save(image);
//            return ResponseEntity.ok().body(Map.of("url", image.getUrl()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//
//    }
}



