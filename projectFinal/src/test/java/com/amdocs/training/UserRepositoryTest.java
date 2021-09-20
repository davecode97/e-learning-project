package com.amdocs.training;


import com.amdocs.training.model.User;
import com.amdocs.training.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("David Llanes");
        user.setEmail("davidanl@amdocs.com");
        user.setPassword("password");
        user.setPhone(12231212);
        user.setAddress("Guadalajara");
        user.setUploadPhoto("photo.jpg");

        User savedUser = repo.save(user);

        User exitsUser = testEntityManager.find(User.class, savedUser.getId());

        assertThat(exitsUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail() {
        String email = "davidanl@amdoc.com";
        User user = repo.findByEmail(email);

        assertThat(user).isNotNull();
    }
}
