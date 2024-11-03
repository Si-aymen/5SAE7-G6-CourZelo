package com.pidev.backend.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Departments")
public class Department {

    @MongoId
    private String departmentId;

    private String name;
    private String contactInformation;



    @DBRef
    private List<User> teachers;





}
