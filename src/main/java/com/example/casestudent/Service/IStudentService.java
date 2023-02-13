package com.example.casestudent.Service;


import com.example.casestudent.Models.StudentModel;
import com.example.casestudent.Models.StudentQueryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IStudentService {

    Page<StudentModel> getStudents(Pageable pageable, StudentQueryModel studentQueryModel);

}
