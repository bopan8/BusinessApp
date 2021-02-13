package com.example.sapBusinessApp.repos;

import com.example.sapBusinessApp.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepo extends JpaRepository <Administrator, Integer> {
    @Query(value = "SELECT * FROM business_app.administrator a WHERE a.administrator_name =:name",nativeQuery = true)
    public Administrator getAdminByName(@Param("name") String name);
}
