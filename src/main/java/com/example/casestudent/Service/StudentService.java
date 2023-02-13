package com.example.casestudent.Service;


import com.example.casestudent.Entities.StudentEntity;
import com.example.casestudent.Mapper.StudentMapper;
import com.example.casestudent.Models.StudentModel;
import com.example.casestudent.Models.StudentQueryModel;
import com.example.casestudent.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class StudentService implements IStudentService {


    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public Page<StudentModel> getStudents(Pageable pageable, StudentQueryModel studentQueryModel) {
        if (studentQueryModel.getStudentName() == null){
            studentQueryModel.setStudentName("");
        }
        if (studentQueryModel.getDepartmentName() == null){
            studentQueryModel.setDepartmentName("");
        }

        Page<StudentEntity> studentEntities =
                studentRepo.findAllStudent(
                        studentQueryModel.getStudentName(),
                        studentQueryModel.getDepartmentName(),studentQueryModel.getStudentBirthday(),pageable);
        return studentEntities.map(StudentMapper::mapTo);
    }
}
