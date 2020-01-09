package com.erajaya.service.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erajaya.service.application.entity.Application;


@Repository	
public interface ApplicationRepository extends JpaRepository <Application,String> {
	@Query
	(value = "SELECT *from tbl_application_type"
          , nativeQuery = true)
    List<Object[]> AllApplication();
}
