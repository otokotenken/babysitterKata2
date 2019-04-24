package com.example.babysitterKata2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

public class BabysitterKataServiceTest {

    @InjectMocks
    BabysitterKataService babysitterKataService;

    Family familyA;
    @Before
    public void setUp() {
        familyA = new Family(5, 11, 15);
    }

    @Test
    public void ifStartTimeIsLessThanOrEqualTwelveSubtractFive() {
        assertEquals(7, babysitterKataService.convertTimeToAPostiveRange(familyA.payShiftStartTime));
    }

}