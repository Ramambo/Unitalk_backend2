package com.unitalk.program.service;

import com.unitalk.program.model.entity.Program;
import com.unitalk.program.model.entity.ProgramImg;
import com.unitalk.program.repository.ProgramImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgramImgService {

    // ProgramImgRepository 타입의 객체 참조
    private final ProgramImgRepository programImgRepository;

    // 이미지 저장 경로 생성
    @Transactional
    public void uploadProgramImg(Program program, List<MultipartFile> images) {
        try {
            // 이미지 파일 저장을 위한 경로 설정
            String uploadsDir = "src/main/resources/static/uploads/programImgs/";

            // 각 이미지 파일에 대해 업로드 및 DB 저장 수행
            for (MultipartFile image : images) {

                // 이미지 파일 경로를 저장
                String originalFileName = image.getOriginalFilename();
                String dbFilePath = saveProgramImg(image, uploadsDir);
                String savedFileName = dbFilePath.substring(dbFilePath.lastIndexOf("/") + 1);

                // ProductThumbnail 엔티티 생성 및 저장
                ProgramImg programImg = new ProgramImg(null,program, originalFileName, savedFileName, dbFilePath);
                programImgRepository.save(programImg);
            }
        } catch (IOException e) {
            // 파일 저장 중 오류가 발생한 경우 처리
            e.printStackTrace();
        }
    }

    // 이미지 파일 저장
    @Transactional
    public String saveProgramImg(MultipartFile image, String uploadsDir) throws IOException {
        // 파일 이름 생성(기존 파일명과 랜덤 값을 더하여 새로운 이름 생성)
        String fileName = UUID.randomUUID().toString().replace("-", "") + "_" + image.getOriginalFilename();
        // 실제 파일 저장될 경로
        String filePath = uploadsDir + fileName;
        // DB에 저장할 경로
        String dbFilePath = "/uploads/programImgs/" + fileName;
        // filePath에 사진 저장, DB에 저장된 dbFilePath 반환

        Path path = Paths.get(filePath); // Path 객체 생성
        Files.createDirectories(path.getParent()); // 디렉토리 생성
        Files.write(path, image.getBytes()); // 디렉토리에 파일 저장

        return dbFilePath;
    }

}
