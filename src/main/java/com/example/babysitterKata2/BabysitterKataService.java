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

    public boolean validateStartTimeWithInRange(int startTime) {
        if (convertTimeToAPositiveRange(startTime) < 11) {
            return true;
        }
        return false;
    }

    public boolean validateEndTimeWithInRange(int endTime, int startTime) {
        if (convertTimeToAPositiveRange(endTime) > convertTimeToAPositiveRange(startTime)) {
            return true;
        } else
            return false;
    }

    public int calculatePay(Family[] family) {
        int paymentTotal = 0;
        int previousTime = 0;
        for (Family session : family) {
            int convertedTIme = convertTimeToAPositiveRange(session.payShiftEndTime) - previousTime;
            paymentTotal += session.payRate * convertedTIme;
            previousTime += convertedTIme;
        }
        return paymentTotal;
    }
}
