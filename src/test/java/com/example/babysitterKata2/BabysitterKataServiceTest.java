package com.example.babysitterKata2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

    @Test
    public void IfStartTimeNotBetweenTweleveAndFiveAddSeven() {
        assertEquals(10, babysitterKataService.convertTimeToAPositiveRange(3));
    }

    @Test
    public void shouldReturnTrueStartTimeFivePmIsWithInAvailabilityRAngeOfShiftStarting() {
        assertTrue(babysitterKataService.validateStartTimeWithInRange(5));
    }

    @Test
    public void shouldReturnFalseStartTimeFourAmIsAfterAvailabilityRangeOfShiftStarting() {
        assertFalse(babysitterKataService.validateStartTimeWithInRange(4));
    }

    @Test
    public void shouldReturnTrueIfEndTimeFourAmIsAfterStartTimeOfFivePm() {
        assertTrue(babysitterKataService.validateEndTimeWithInRange(4, 5));
    }

    @Test
    public void shouldReturnFalseIfEndTimeSixPmIsAfterStartTimeOfFivePm() {
        assertFalse(babysitterKataService.validateEndTimeWithInRange(1, 4));
    }

}