package com.edutech.classroom.repository;

import com.edutech.classroom.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findAll(); // Esto permite usar .stream() directamente si lo deseas
}