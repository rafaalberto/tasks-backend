package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void shouldReturnTrueIfFutureDate() {
        LocalDate localDate = LocalDate.of(2021, 1, 1);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }

    @Test
    public void shouldReturnFalseIfPastDate() {
        LocalDate localDate = LocalDate.of(2010, 1, 1);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(localDate));
    }

    @Test
    public void shouldReturnTrueIfCurrentDate() {
        LocalDate localDate = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }
}
