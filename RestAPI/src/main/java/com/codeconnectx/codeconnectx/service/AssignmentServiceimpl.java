package com.codeconnectx.codeconnectx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeconnectx.codeconnectx.model.Assignment;
import com.codeconnectx.codeconnectx.model.Classroom;
import com.codeconnectx.codeconnectx.model.Testcase;
import com.codeconnectx.codeconnectx.repository.AssignmentDao;

import java.util.List;

@Service
public class AssignmentServiceimpl implements AssignmentService{
    
    @Autowired
    private AssignmentDao dao;

    @Override
    public boolean saveAssignment(Assignment assignment, String classroomid){
        // if(assignment != null){
        //     System.out.println("Not NULL");
        // }
        return dao.saveAssignment(assignment, classroomid);
    }

    @Override
    public List<Object> fetchAllAssignment(String classroomid) {
        return dao.fetchAllAssignment( classroomid); 
    }

    @Override
    public Object fetchAssignmentById(Long id, String classroomid){
        return dao.fetchAssignmentById(id, classroomid);
    }

    @Override
    public boolean deleteAssignment(Long id, String classroomid){
        return dao.deleteAssignment(id, classroomid);
    }

    @Override
    public boolean updateAssignment(Long id, Assignment assignment,String classroomid){
        return dao.updateAssignment(id, assignment, classroomid);
    }

    //TESTCASE

    @Override
    public boolean saveTestcase(Testcase testcase, String assign_id, String classroomid){
        // if(assignment != null){
        //     System.out.println("Not NULL");
        // }
        return dao.saveTestcase(testcase,assign_id,classroomid);
    }

    @Override
    public List<Object> fetchAllTestcase(String assign_id, String classroomid) {
        return dao.fetchAllTestcase(assign_id,classroomid); 
    }

    @Override
    public Object fetchTestcaseById(String assign_id,String testcaseid, String classroomid){
        return dao.fetchTestcaseById(assign_id,testcaseid,classroomid);
    }

    @Override
    public boolean deleteTestcase(String assign_id,String testcaseid, String classroomid){
        return dao.deleteTestcase(assign_id, testcaseid,classroomid);
    }

    //Classroom

    @Override
    public boolean saveClassroom(Classroom classroom) {
        return dao.saveClassroom(classroom);
    }

    @Override
    public List<Object> fetchAllClassrooms() {
        return dao.fetchAllClassrooms(); 
    }

    @Override
    public Object fetchClassroomById(String classromid){
        return dao.fetchClassroomById(classromid);
    }

    @Override
    public boolean deleteClassroom(String classroomid){
        return dao.deleteClassroom(classroomid);
    }

}
