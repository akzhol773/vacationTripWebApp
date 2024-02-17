package com.neobis.vacationtrip.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.neobis.vacationtrip.entities.Image;
import com.neobis.vacationtrip.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final Cloudinary cloudinary;

    public Image saveImage(MultipartFile image) throws IOException {
        String imageUrl = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap()).get("url").toString();
        Image imageToBeSaved = new Image();
        imageToBeSaved.setImageUrl(imageUrl);
        return imageRepository.save(imageToBeSaved);
    }


}
