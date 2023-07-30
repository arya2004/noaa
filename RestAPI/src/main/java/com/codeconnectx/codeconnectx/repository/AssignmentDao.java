package com.codeconnectx.codeconnectx.repository;
import java.util.List;
import com.codeconnectx.codeconnectx.model.Assignment;

public interface AssignmentDao {
    boolean saveAssignment(Assignment assignment);

    List <Assignment> fetchAllAssignment();

    Assignment fetchAssignmentById(Long id);

    boolean deleteAssignment(Long id);

    boolean updateAssignment(Long id, Assignment assignment);

}
