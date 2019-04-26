package com.example.babysitterKata2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BabysitterKataController {

    @Autowired
    BabysitterKataService babysitterKataService;

    @RequestMapping(value = "job", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> validateJob(@RequestBody Family[] family) {
        Integer total = babysitterKataService.calculatePay(family);
        System.out.println(total.toString());
        return new ResponseEntity<>(total.toString(), HttpStatus.ACCEPTED);
    }
}
