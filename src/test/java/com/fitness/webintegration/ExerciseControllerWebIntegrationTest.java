package com.fitness.webintegration;

import com.fitness.FitnessApplication;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = FitnessApplication.class)
public class ExerciseControllerWebIntegrationTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test @Ignore
    public void testfindAll() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/exercises",String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        JsonNode responseJson = objectMapper.readTree(response.getBody());
        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString(), notNullValue());
    }

}
