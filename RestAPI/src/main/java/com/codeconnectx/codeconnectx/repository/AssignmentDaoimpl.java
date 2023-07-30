package com.codeconnectx.codeconnectx.repository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.annotation.AccessType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.codeconnectx.codeconnectx.model.Assignment;

import java.util.List;

@Repository
public class AssignmentDaoimpl implements AssignmentDao{
    
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY="ASSIGNMENT";

    @Override
    public boolean saveAssignment(Assignment assignment){
        try{
            redisTemplate.opsForHash().put(KEY,assignment.getId().toString(),assignment);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Assignment> fetchAllAssignment(){
        List<Assignment> assignments;
        assignments = redisTemplate.opsForHash().values(KEY);
        return assignments;
    }

    @Override
    public Assignment fetchAssignmentById(Long id){
        Assignment assignment;
        assignment = (Assignment) redisTemplate.opsForHash().get(KEY,id.toString());
        return assignment; 
    }

    @Override
    public boolean deleteAssignment(Long id){
        try{
            redisTemplate.opsForHash().delete(KEY,id.toString());
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAssignment(Long id, Assignment assignment){
        try{
            redisTemplate.opsForHash().put(KEY,id,assignment);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
