package com.fitness.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.interceptors.RequestInterceptor;
import com.fitness.service.CredentialService;
import com.fitness.table.Credential;
import com.fitness.table.User;
import com.fitness.beans.DocketBean;
import com.fitness.interceptors.RequestInterceptor;
import com.fitness.dto.CredentialDTO;
import com.fitness.service.CredentialService;
import com.fitness.table.Credential;
import com.fitness.table.User;
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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = CredentialController.class,secure = false)
//@ActiveProfiles("test")
public class CredentialControllerTest {

    @MockBean
    private CredentialService credentialService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    RequestInterceptor requestInterceptor;

    @MockBean
    DocketBean docketBean;

    @Test @Ignore
    public void testSuccessful_createCredential() throws Exception {
        User user  = new User();
        user.setEmailAddress("nikhil.agrw07@gmail.com");
        Credential credential = new Credential();
        credential.setPassword("pass123");
        credential.setUsername("username1");
        CredentialDTO credentialDTO = new CredentialDTO(credential,user);

        Mockito.when(credentialService.save(any(Credential.class), any(User.class))).thenReturn(credentialDTO.getCredential());


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/credentials")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(credentialDTO))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Credential credential1 = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Credential.class);
        assertEquals("", objectMapper.writeValueAsString(credentialDTO.getCredential()), objectMapper.writeValueAsString(credential1));
        Mockito.verify(credentialService, times(1)).save(any(Credential.class), any(User.class));

    }

}
