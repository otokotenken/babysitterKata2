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

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BabysitterKataControllerTest {

    MockMvc mvc;
    Family[] familyC;
    @Mock
    BabysitterKataService babysitterKataService;

    @InjectMocks
    BabysitterKataController babysitterKataController;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(babysitterKataController).build();
        familyC = new Family[] {new Family(5, 9, 21), new Family(5, 4, 15)};

    }

    @Test
    public void validateJobEndpointReturnsAnJobAcceptedMessage() throws Exception {
        String request = "[{\"payShiftStartTime\": 5, \"payShiftEndTime\": 9, \"payRate\": 21}, {\"payShiftStartTime\": 5, \"payShiftEndTime\": 4, \"payRate\": 15}]";
//        Mockito.when(babysitterKataController.validateJob(Mockito.any())).thenReturn(new ResponseEntity<>("Job Accepted", HttpStatus.ACCEPTED));
        Mockito.when(babysitterKataService.calculatePay(Mockito.any())).thenReturn(189);
        mvc.perform(post("/job").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(request))
                .andExpect(status().isAccepted());

        assertEquals("189", babysitterKataController.validateJob(familyC).getBody());
    }

    @Test
    public void validateJobEndpointInvalidStartTIme() throws Exception {
        String request = "{\"payShiftStartTime\": 0, \"payShiftEndTime\": 10, \"payRate\": 5}";
//        Mockito.when(babysitterKataController.validateJob()).thenReturn(new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST));
        mvc.perform(post("/job")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(request))
                .andExpect(status().isBadRequest());
    }



}