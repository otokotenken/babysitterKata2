package com.example.babysitterKata2;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BabysitterKataControllerTest {

    MockMvc mvc;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(babysitterKataController).build();
    }

    @Test
    public void validateJobEndpointReturnsAnJobAcceptedMessage() throws Exception {
        String request = "";
        mvc.perform(post("/job").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(request))
                .andExpect(status().isAccepted())
                .andExpect(content().string("Job Accepted"));
    }

}