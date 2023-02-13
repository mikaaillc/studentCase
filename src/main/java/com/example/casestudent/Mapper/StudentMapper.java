package com.example.casestudent.Mapper;


import com.example.casestudent.Entities.StudentEntity;
import com.example.casestudent.Models.StudentModel;;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class StudentMapper {
    public static StudentModel mapTo(StudentEntity studentEntity){
        StudentModel studentModel = new StudentModel();
        studentModel.setName(studentEntity.getName());
        studentModel.setBirthday(studentEntity.getBirthday());
        studentModel.setId(studentEntity.getId());
        studentModel.setDepartmentEntity(studentEntity.getDepartmentEntity());
        return studentModel;
    }

    public static StudentEntity mapTo(StudentModel studentModel){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentModel.getName());
        studentEntity.setBirthday(studentModel.getBirthday());
        studentEntity.setId(studentModel.getId());
        studentEntity.setDepartmentEntity(studentModel.getDepartmentEntity());
        return studentEntity;
    }


    public static List<StudentModel> mapToList(List<StudentEntity> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(StudentMapper::mapTo).collect(Collectors.toList());
    }


}
