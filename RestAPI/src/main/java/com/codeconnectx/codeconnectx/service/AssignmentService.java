package com.codeconnectx.codeconnectx.service;

import com.codeconnectx.codeconnectx.model.Assignment;
import com.codeconnectx.codeconnectx.model.Classroom;
import com.codeconnectx.codeconnectx.model.Testcase;

import java.util.List;

public interface AssignmentService {
    boolean saveAssignment(Assignment assignment, String classroomid);

    List<Object> fetchAllAssignment(String classroomid);

    Object fetchAssignmentById(Long id, String classroomid);

    boolean deleteAssignment(Long id, String classroomid);

    boolean updateAssignment(Long id, Assignment assignment, String classroomid);

    //Testcase
    boolean saveTestcase(Testcase testcase, String assign_id, String classroomid);

    List<Object> fetchAllTestcase(String assign_id, String classroomid);

    Object fetchTestcaseById(String assign_id,String testcaseid, String classroomid);

    boolean deleteTestcase(String assign_id,String testcaseid, String classroomid);

    //Classroom
    boolean saveClassroom(Classroom classrom);
    
    List<Object> fetchAllClassrooms();

    Object fetchClassroomById(String classroomid);

    boolean deleteClassroom(String classroomid);

}
