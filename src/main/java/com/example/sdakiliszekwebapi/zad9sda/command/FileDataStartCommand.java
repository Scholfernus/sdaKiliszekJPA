package com.example.sdakiliszekwebapi.zad9sda.command;

import com.example.sdakiliszekwebapi.zad9sda.model.FileData;
import com.example.sdakiliszekwebapi.zad9sda.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileDataStartCommand implements CommandLineRunner {
    private final FileDataRepository fileDataRepository;
    @Override
    public void run(String... args) throws Exception {
        FileData fileData = new FileData();
        fileData.setFileName("testFileName");
        fileData.setExtension(".txt");
        fileData.setSizeInKb(1024);
        fileData.setContent("xyz");
        FileData savedFileData = fileDataRepository.save(fileData);
        log.info("Safe fileData id {} ", savedFileData.getId());
    }
}
