package com.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.dto.CredentialDTO;
import com.fitness.exceptions.UserNotFoundException;
import com.fitness.interceptors.RequestInterceptor;
import com.fitness.service.CredentialService;
import com.fitness.table.Credential;
import com.fitness.table.User;
import com.fitness.beans.DocketBean;
import com.fitness.request.CredentialRequest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CredentialController.class,secure = false)
@ActiveProfiles("test")
public class CredentialControllerTest {

    @Autowired
    CredentialController credentialController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CredentialService credentialService;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    RequestInterceptor requestInterceptor;

    @MockBean
    DocketBean docketBean;

    @Test
    public void testSuccessful_createCredential() throws UserNotFoundException, Exception {

        //Arrange
        String firstName = "Menu";

        CredentialDTO credential = new CredentialDTO();
        credential.setFirstName(firstName);
        credential.setLastName("Agrawal");
        credential.setUserName("username1");
        credential.setPassword("pass123");
        String convertedJson = objectMapper.writeValueAsString(credential);

        Mockito.when(credentialService.getCreditnalsByFirstName(firstName)).thenReturn(credential);

        String url = "/api/v1/credential?userName="+firstName;
        //Act
        ResultActions resultActions = mockMvc.perform(get(url))
                .andExpect(status().isOk());
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());

        CredentialDTO credential1 = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), CredentialDTO.class);
        assertEquals("", objectMapper.writeValueAsString(credential), objectMapper.writeValueAsString(credential1));
//        Mockito.verify(credentialService, times(1)).save(any(Credential.class), any(User.class));





//        ResultActions result = mockMvc.perform(get("/credentials").param("userName", firstName));
//
//        //Assert
//        result.andExpect(status().isOk())
//                .andExpect(content().json(convertedJson));


        Mockito.verify(credentialService, times(1)).save(any(CredentialRequest.class));

    }

}
