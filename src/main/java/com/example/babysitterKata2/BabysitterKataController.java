package com.example.babysitterKata2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BabysitterKataController {

    @RequestMapping(value = "job", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> validateJob(@RequestBody Family[] family) {
        if (family[0].payShiftStartTime == 1) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Job Accepted");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }
}
