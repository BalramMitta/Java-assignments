package assignment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class KYCFormTest {

    /**
     * Sign up date not taken as anniversary
     * If current date is past the 30 day range of first anniversary
     * results no range of dates for form filling
     * <p>
     * Ex: If sign up date is 02-02-2019 first anniversary is 02-02-2020
     * Form Filling date starts from 03-01-2020
     * If the current date is before 03-01-2020, it has no range.
     * <p>
     * 21-10-2019 is before 03-01-2020
     */
    @Test
    void testNoRange() {
        LocalDate signUpDate = LocalDate.of(2019, 2, 2);
        LocalDate currentDate = LocalDate.of(2019, 10, 21);
        assertEquals("No range", KYCForm.getRangeOfDatesForFormDate(signUpDate, currentDate));
    }

    /**
     * If current date is after the 30 day range of anniversary in current year
     * then anniversary for form filling will be in previous year.
     * <p>
     * Ex: If sign up date is "01-09-2010" and current date is is "12-12-2019"
     * Anniversary in current year is 01-09-2019
     * and form filling start date 02-08-2019 which is in past to current date and nearest
     * <p>
     * Result "02-08-2019 01-10-2019"
     */
    @Test
    void testAnniversaryInCurrentYear() {
        LocalDate signUpDate = LocalDate.of(2010, 9, 1);
        LocalDate currentDate = LocalDate.of(2019, 12, 12);
        assertEquals("02-08-2019 01-10-2019", KYCForm.getRangeOfDatesForFormDate(signUpDate, currentDate));
    }


    /**
     * Form Dates ranges from -30 days of anniversary to +30 days of anniversary.
     * If current date is within the range then range ends at current date
     * <p>
     * sign up date "01-09-2010" current date "12-12-2019"
     * Range "02-08-2019 01-10-2019"
     * End date 01-10-2019 is before 12-12-2019
     * Therefore,
     * Result "02-08-2019 01-10-2019"
     */
    @Test
    void testEndDateisBeforeCurrentDate() {
        LocalDate signUpDate = LocalDate.of(2010, 9, 1);
        LocalDate currentDate = LocalDate.of(2019, 12, 12);
        assertEquals("02-08-2019 01-10-2019", KYCForm.getRangeOfDatesForFormDate(signUpDate, currentDate));
    }


    /**
     * Form Dates ranges from -30 days of anniversary to +30 days of anniversary.
     * If current date is within the range then range ends at current date
     * <p>
     * sign up date "01-09-2010" current date "03-09-2019"
     * Range "02-08-2019 01-10-2019"
     * End date 01-10-2019 is after 03-09-2019
     * Therefore,
     * Result "02-08-2019 03-09-2019"
     */
    @Test
    void testEndDateisAfterCurrentDate() {
        LocalDate signUpDate = LocalDate.of(2010, 9, 1);
        LocalDate currentDate = LocalDate.of(2019, 9, 3);
        assertEquals("02-08-2019 03-09-2019", KYCForm.getRangeOfDatesForFormDate(signUpDate, currentDate));
    }


    /**
     * If current date is past the 30 day range of anniversary in current year
     * then anniversary for form filling will be in previous year.
     * <p>
     * Ex: If sign up date is "01-09-2010" and current date is is "02-02-2019"
     * Anniversary in current year is 01-09-2019
     * and form filling start date 02-08-2019 which is in future to current date
     * Go back to previous year anniversary 01-09-2018 which is nearest past anniversary
     * <p>
     * Result "02-08-2018 01-10-2018"
     */
    @Test
    void testAnniversaryInPreviousYear() {
        LocalDate signUpDate = LocalDate.of(2010, 9, 1);
        LocalDate currentDate = LocalDate.of(2019, 2, 2);
        assertEquals("02-08-2018 01-10-2018", KYCForm.getRangeOfDatesForFormDate(signUpDate, currentDate));
    }

    /**
     * If current date is in the 30 day range of anniversary in next year
     * then anniversary for form filling will be in previous year.
     * <p>
     * Ex: If sign up date is "01-01-2010" and current date is is "30-12-2019"
     * Anniversary in current year is 01-01-2019
     * and form filling start date 02-12-2018 which is in past to current date
     * But form filling start date for next year anniversary "01-01-2020" starts from 02-12-2019 which is before the current date
     * <p>
     * Result "02-12-2019 30-12-2019"   ( end date is after current date )
     */
    @Test
    void testAnniversaryInNextYear() {
        LocalDate signUpDate = LocalDate.of(2010, 1, 1);
        LocalDate currentDate = LocalDate.of(2019, 12, 30);
        assertEquals("02-12-2019 30-12-2019", KYCForm.getRangeOfDatesForFormDate(signUpDate, currentDate));
    }

}