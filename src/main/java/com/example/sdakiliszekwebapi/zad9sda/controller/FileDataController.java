package com.example.sdakiliszekwebapi.zad9sda.controller;

import com.example.sdakiliszekwebapi.zad9sda.dto.FileDataDto;
import com.example.sdakiliszekwebapi.zad9sda.dto.FileDataList;
import com.example.sdakiliszekwebapi.zad9sda.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(FileDataController.FILE_DATA_API_BASE_PATH)
@RequiredArgsConstructor
public class FileDataController {
    static final String FILE_DATA_API_BASE_PATH = "/api/files-data";
    private final FileDataService fileDataService;

    @GetMapping
    public FileDataList getFilesData(){
        return fileDataService.getFilesData();
    }
    @GetMapping("/{id}")
    public FileDataDto getFileData(@PathVariable ("id") String id){
        return fileDataService.getFileData(id);
    }
    @PostMapping
    public ResponseEntity<Object> createFileData(@RequestBody @Valid FileDataDto fileDataDto) throws URISyntaxException {
        return ResponseEntity
                .created(new URI(FILE_DATA_API_BASE_PATH + "/" + fileDataService.createFileData(fileDataDto)))
                .build();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFileData(@PathVariable ("id") String id, @RequestBody FileDataDto fileDataDto){
        fileDataService.updateFileData(id, fileDataDto);
    }
    @DeleteMapping("/{id}")
    public void deleteFileData(@PathVariable("id") String id){
        fileDataService.deleteFileData(id);
    }
}
