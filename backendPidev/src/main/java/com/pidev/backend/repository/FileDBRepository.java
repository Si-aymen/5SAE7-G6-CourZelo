package com.pidev.backend.repository;


import com.pidev.backend.entity.FileDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileDBRepository extends MongoRepository<FileDB, String> {
	

}
