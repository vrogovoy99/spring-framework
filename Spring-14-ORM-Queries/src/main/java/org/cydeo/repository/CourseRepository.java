package org.cydeo.repository;

import org.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;


public interface CourseRepository extends JpaRepository<Course, Integer> {

    //find all courses by category
    List<Course> findByCategory(String category);

    //by cathegory and order by name
    List<Course> findByCategoryOrderByName(String category);

    //if course exists then return true otherwise false
    boolean existsByName(String name);
    // count of courses
    int countByCategory(String category);
    // courses that start with
    List<Course> findByNameStartingWith(String name);

    //find all courses by category and returns a stream

    Stream<Course> streamByCategory(String category);
}
