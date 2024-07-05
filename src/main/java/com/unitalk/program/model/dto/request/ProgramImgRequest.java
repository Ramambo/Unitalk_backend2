package com.unitalk.program.model.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProgramImgRequest {
    private List<MultipartFile> files;
}
