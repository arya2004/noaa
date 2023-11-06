package com.codeconnectx.codeconnectx.repository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.annotation.AccessType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.codeconnectx.codeconnectx.model.Assignment;
import com.codeconnectx.codeconnectx.model.Classroom;
import com.codeconnectx.codeconnectx.model.Testcase;
import com.google.gson.Gson;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;
import java.util.Set;

@Repository
public class AssignmentDaoimpl implements AssignmentDao{
    
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY="ASSIGNMENT";

    @Override
    public boolean saveAssignment(Assignment assignment, String classroomid){
        try{
            if(assignment.getAssignmentid() != null){
                System.out.println("Not NULL");
            }
            redisTemplate.opsForHash().put(KEY,classroomid+":"+assignment.getAssignmentid(),assignment);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object> fetchAllAssignment(String classroomid){
        Set<String> assignmentkeys;
        List<Object> assignments = new ArrayList<>();
        Object temp;
       
        // assignments = redisTemplate.opsForHash().values(KEY);
        assignmentkeys = redisTemplate.opsForHash().entries(KEY).keySet();
        System.out.println(redisTemplate.opsForHash().entries(KEY).keySet());
        for(String item : assignmentkeys){
            temp =  redisTemplate.opsForHash().get(KEY,item);
            assignments.add(temp);
        }

    return assignments;
    }

    @Override
    public Object fetchAssignmentById(Long id, String classroomid){
        Object assignment; 
        System.out.println("test"+classroomid+":"+id.toString());
        assignment = redisTemplate.opsForHash().get(KEY,classroomid+":"+id.toString());
        return assignment; 
    }

    @Override
    public boolean deleteAssignment(Long id, String classroomid){
        try{
            redisTemplate.opsForHash().delete(KEY,classroomid+":"+id.toString());
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAssignment(Long id, Assignment assignment, String classroomid){
        try{
            redisTemplate.opsForHash().put(KEY,classroomid+":"+id,assignment);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private static final String KEY1="TESTCASE";

    @Override
    public boolean saveTestcase(Testcase testcase, String assign_id,String classroomid){
        try{
            // List<Testcase> testlist = new ArrayList<>();
            // testlist.add(testcase);
            //String new_testcase = new Gson().toJson(testcase);
            redisTemplate.opsForHash().put(KEY1,classroomid+":"+assign_id+":"+testcase.getTestcaseid(),testcase);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object> fetchAllTestcase(String assign_id,String classroomid){
        Set<String> testcasekeys;
        List<Object> testcases = new ArrayList<>();
        Object temp;
       
        // testcases = redisTemplate.opsForHash().values(KEY);
        testcasekeys = redisTemplate.keys(classroomid+":"+assign_id+":*");
        for(String item : testcasekeys){
            temp =  redisTemplate.opsForHash().get(KEY,item);
            testcases.add(temp);
        }

    return testcases;
    }

    @Override
    public Object fetchTestcaseById(String assign_id,String testcaseid,String classroomid){
        Object testcase;
        testcase = redisTemplate.opsForHash().get(KEY1,classroomid+":"+assign_id+":"+testcaseid);
        return testcase;
    }

    @Override
    public boolean deleteTestcase(String assign_id,String testcaseid,String classroomid){
        try{
            redisTemplate.opsForHash().delete(KEY1,classroomid+":"+assign_id+":"+testcaseid);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        } 
    }

    //CLASSROOM
    private static final String KEY2 = "CLASSROOM";

    @Override
    public boolean saveClassroom(Classroom classroom) {
        try {
            redisTemplate.opsForHash().put(KEY2,classroom.getClassroomid(),classroom);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object> fetchAllClassrooms() {
        List<Object> result = redisTemplate.opsForHash().values(KEY2);
        return result;
    }

    @Override
    public Object fetchClassroomById(String classroomid) {
        return redisTemplate.opsForHash().get(KEY2,classroomid);
    }

    @Override
    public boolean deleteClassroom(String classroomid) {
        try {
            redisTemplate.opsForHash().delete(KEY2,classroomid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            // TODO: handle exception
        }
    }
}
