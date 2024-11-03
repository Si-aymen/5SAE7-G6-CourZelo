package com.pidev.backend.repository;

import com.pidev.backend.entity.Classroom;
import com.pidev.backend.entity.Role;

import com.pidev.backend.entity.Speciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.pidev.backend.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User getUserByLoginAndRole(String login , Role role ) ;
    User deleteUserByLogin(String login);
    User findUserByLogin(String login);
    User findUserByEmail(String email);

    List<User> getUserBySpeciality(Speciality speciality) ;

    List<User> getUsersByRole(Role role);

    List<User> getUserByClassroomsAndRole(Classroom classroom , Role role);


    // List<User> findAllByClassrooms(String Classrooms) ;
    User getUserById(String id);

}