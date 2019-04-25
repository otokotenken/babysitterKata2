package com.example.babysitterKata2;

import org.springframework.stereotype.Service;

@Service
public class BabysitterKataService {

    public int convertTimeToAPositiveRange(int time) {
        int newTime = 0;
        if (time <= 12 && time >= 5) {
            newTime = time-5;
        } else {
            newTime = time + 7;
        }
        return newTime;
    }

}
