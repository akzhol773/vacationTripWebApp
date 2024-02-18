package com.neobis.vacationtrip.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageRequestDto {
    private String name;
    private MultipartFile file;
}