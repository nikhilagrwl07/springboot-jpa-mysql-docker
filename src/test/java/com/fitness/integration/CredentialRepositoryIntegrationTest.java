package com.fitness.integration;

import com.fitness.FitnessApplication;
import com.fitness.repository.CredentialRepository;
import com.fitness.table.Credential;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
        classes = FitnessApplication.class)
public class CredentialRepositoryIntegrationTest {

    @Autowired
    CredentialRepository credentialRepository;

    @Test
    public void testfindAll(){
        List<Credential> credentials = credentialRepository.findAll();
        assertThat(credentials.size(), is(greaterThanOrEqualTo(0)));
    }
}
