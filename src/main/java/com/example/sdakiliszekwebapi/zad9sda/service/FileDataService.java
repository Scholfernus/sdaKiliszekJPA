package com.example.sdakiliszekwebapi.zad9sda.service;

import com.example.sdakiliszekwebapi.zad9sda.dto.FileDataDto;
import com.example.sdakiliszekwebapi.zad9sda.dto.FileDataList;
import com.example.sdakiliszekwebapi.zad9sda.exception.SdaException;
import com.example.sdakiliszekwebapi.zad9sda.mapper.FileDataDtoMapper;
import com.example.sdakiliszekwebapi.zad9sda.model.FileData;
import com.example.sdakiliszekwebapi.zad9sda.repository.FileDataRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataList getFilesData() {
        List<FileData> dataList = fileDataRepository.findAll();
        List<FileDataDto> fileDataDtos = dataList.stream()
                .map(FileDataDtoMapper::map)
                .collect(Collectors.toList());
        return new FileDataList(fileDataDtos);
    }

    public FileDataDto getFileData(String id) {
        FileData fileData = fileDataRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new SdaException("File data doesn't exists! Id: " + id));
        return FileDataDtoMapper.map(fileData);
    }

    public String createFileData(FileDataDto dataDto) {
        FileData fileData = FileData
                .builder()
                .fileName(dataDto.getFileName())
                .content(dataDto.getContent())
                .extension(dataDto.getExtension())
                .sizeInKb(dataDto.getSizeInKb())
                .build();
        FileData saved = fileDataRepository.save(fileData);
        log.info("createFileData finished! {}", saved.getId().toString());
        return saved.getId().toString();
    }

    public void updateFileData(String id, FileDataDto fileDataDto) {
        FileData fileData = fileDataRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new SdaException("File data doesn't exists! Id: " + id));
        fileData.setFileName(fileDataDto.getFileName());
        fileData.setContent(fileDataDto.getContent());
        fileData.setExtension(fileDataDto.getExtension());
        fileData.setSizeInKb(fileDataDto.getSizeInKb());
        fileDataRepository.save(fileData);
        log.info("FileData {} was updated! ", id);
    }

    public void deleteFileData(String id) {
        FileData fileData = fileDataRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new SdaException("File data doesn't exists! ID: " + id));
        fileDataRepository.delete(fileData);
        log.info("File data was removed {} ", id);
    }
}
