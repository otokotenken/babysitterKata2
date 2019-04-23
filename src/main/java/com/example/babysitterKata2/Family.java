package com.example.babysitterKata2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Family {
    
        int payShiftEndTime;
        int payRate;
        int payShiftStartTime;

        public int getPayShiftEndTime() {
            return payShiftEndTime;
        }

        public int getPayShiftStartTime() {
            return payShiftStartTime;
        }

        @JsonCreator
        public Family (@JsonProperty("payShiftStartTime") int payShiftStartTime, @JsonProperty("payShiftEndTime") int payShiftEndTime, @JsonProperty("payRate") int payrate) {
            this.payShiftStartTime = payShiftStartTime;
            this.payShiftEndTime = payShiftEndTime;
            this.payRate = payrate;
        }
}
