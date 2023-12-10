package com.example.sdakiliszekwebapi.zad9sda.repository;

import com.example.sdakiliszekwebapi.zad9sda.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, UUID> {
}
