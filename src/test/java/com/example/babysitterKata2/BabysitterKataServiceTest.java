package com.example.babysitterKata2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BabysitterKataServiceTest {

    @InjectMocks
    BabysitterKataService babysitterKataService;

    Family familyA;
    @Before
    public void setUp() {
        familyA = new Family(12, 11, 15);
    }

    @Test
    public void ifStartTimeIsLessThanOrEqualTwelveSubtractFive() {
        assertEquals(7, babysitterKataService.convertTimeToAPositiveRange(12));
    }

    @Test
    public void ifStartTimeMoreThanOrEqualFiveSubtractFive(){
        assertEquals(0, babysitterKataService.convertTimeToAPositiveRange(5));
    }

}