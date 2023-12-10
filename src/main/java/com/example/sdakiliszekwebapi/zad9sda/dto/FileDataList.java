package com.example.sdakiliszekwebapi.zad9sda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FileDataList {
    private List<FileDataDto> fileDataDtoList;
}
