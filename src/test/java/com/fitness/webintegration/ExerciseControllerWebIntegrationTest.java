package com.fitness.webintegration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.FitnessApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = FitnessApplication.class)
public class ExerciseControllerWebIntegrationTest {

    @Autowired
    ObjectMapper objectMapper;

    @LocalServerPort
    private int portNumber;

    @Test
//    @Ignore
    public void testfindAll() throws IOException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);


        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.exchange
                ("http://localhost:" + portNumber + "/api/v1/exercises",
                        HttpMethod.GET, entity, String.class);


        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        JsonNode responseJson = objectMapper.readTree(response.getBody());
        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString(), notNullValue());
    }

}
