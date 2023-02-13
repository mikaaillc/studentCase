package com.example.casestudent.Repository;

import com.example.casestudent.Entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Long> {

    @Query("SELECT s FROM StudentEntity s , DepartmentEntity d " +
            "WHERE s.departmentEntity.id=d.id and :birthday is null or s.birthday = :birthday " +
            "and (:studentName = '' or upper(s.name) like upper(concat('%',:studentName,'%'))) " +
            "and (:departmentName = '' or upper(d.name) like upper(concat('%',:departmentName,'%')))" )
    Page<StudentEntity> findAllStudent(String studentName, String departmentName, Date birthday, Pageable pageable);

}