package com.amdocs.training;

import com.amdocs.training.model.Feedback;
import com.amdocs.training.repository.feedbackRepository;
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
public class FeedbackRepositoryTest {
    @Autowired
    private feedbackRepository repo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateFeedback() {
        Feedback feedback = new Feedback();
        feedback.setName("David");
        feedback.setEmail("davidanl@amdocs.com");
        feedback.setFeedback("Test for feedback");

        Feedback saveFeedback = repo.save(feedback);

        Feedback exitsFeedback = testEntityManager.find(Feedback.class, saveFeedback.getId());

        assertThat(exitsFeedback.getEmail()).isEqualTo(feedback.getEmail());
    }

    @Test
    public void testFindCourseByEmail() {
        String email = "davidanl@amdocs.com";
        Feedback feedback = repo.findFeedbackBy(email);

        assertThat(feedback).isNotNull();
    }
}
