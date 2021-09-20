package com.amdocs.training;


import com.amdocs.training.model.Course;
import com.amdocs.training.repository.courseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CourseRepositoryTest {
    @Autowired
    private courseRepository repo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateCourse() {
        Course course = new Course();
        course.setName("Physics"); // unique
        course.setDescription("Science");
        course.setResources("notes.pdf");
        course.setFees(123);

        Course savedCourse = repo.save(course);
        Course exitsCourse = testEntityManager.find(Course.class, savedCourse.getId());

        assertThat(exitsCourse.getName()).isEqualTo(course.getName());
    }

    @Test
    public void testFindCourseByName() {
        String name = "Physics";
        Course course = repo.findCourseBy(name);

        assertThat(course).isNotNull();
    }
}
