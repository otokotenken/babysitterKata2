package com.example.babysitterKata2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BabysitterKataControllerTest {

    MockMvc mvc;

    @Mock
    BabysitterKataController babysitterKataController;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(babysitterKataController).build();
    }

    @Test
    public void validateJobEndpointReturnsAnJobAcceptedMessage() throws Exception {
        String request = "";
        Mockito.when(babysitterKataController.validateJob()).thenReturn(new ResponseEntity<>("Job Accepted", HttpStatus.ACCEPTED));
        mvc.perform(post("/job").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(request))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Job Accepted"));
        Mockito.verify(babysitterKataController, Mockito.times(1)).validateJob();
        Mockito.verifyNoMoreInteractions(babysitterKataController);
    }

}