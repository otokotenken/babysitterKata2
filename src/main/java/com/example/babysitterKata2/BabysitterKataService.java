package com.example.babysitterKata2;

import org.springframework.stereotype.Service;

@Service
public class BabysitterKataService {

    public int convertTimeToAPositiveRange(int time) {
        int newTime = 0;
        if (time <= 12) {
            newTime = time-5;
        }
        return newTime;
    }

}
