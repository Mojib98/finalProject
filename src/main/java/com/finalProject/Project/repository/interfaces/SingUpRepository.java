package com.finalProject.Project.repository.interfaces;

import com.finalProject.Project.entity.BaseClass;
import com.finalProject.Project.entity.Customer;
import com.finalProject.Project.entity.Expert;
import com.finalProject.Project.entity.Users;
import com.finalProject.Project.service.interfaces.GenericService;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SingUpRepository<T extends Users> extends JpaRepository<T,Integer> {

}