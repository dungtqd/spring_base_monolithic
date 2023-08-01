package org.ngsd.ngs_website.utils;

import org.springframework.context.annotation.Description;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Trieu Quang Dung
 * @created 2023.08.01 - 2:16 PM
 * @project NGS Website
 */
@Description("DateUtil class")
public class DateUtil {
    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat formatterDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat formatterDob = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Description: Convert String date to Date
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException {
        return formatter.parse(date);
    }

    /**
     * Description: Convert String date to Date
     *
     * @param dateTime
     * @return
     * @throws ParseException
     */
    public static Date parseDateTime(String dateTime) throws ParseException {
        return formatterDateTime.parse(dateTime);
    }

    public static Boolean equalTwoDate(Date date1, Date date2) {
        date1 = startOfDay(date1);
        date2 = startOfDay(date2);

        return date1.equals(date2);
    }

    /**
     * Description: Return start of a date
     *
     * @param date
     * @return
     */
    public static Date startOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return startOfDay(calendar);
    }

    /**
     * Description: Return start of a day with 00:00:00
     *
     * @param calendar
     * @return
     */
    public static Date startOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * Description: Get calendar with date
     *
     * @param date
     * @return
     */
    public static Calendar date(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * Description: Return end of a day with 23:59:59
     *
     * @param calendar
     * @return
     */
    public static Date endOfDay(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * Description: Return end of a date
     *
     * @param date
     * @return
     */
    public static Date endOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return endOfDay(calendar);
    }

    /**
     * Description: Return end of a String date
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date endOfDay(String date) throws ParseException {
        return endOfDay(parseDate(date));
    }

    /**
     * Description: Add some days to the date
     *
     * @param date
     * @param days
     * @return
     * @throws ParseException
     */
    public static Date addDays(Date date, int days) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * Description: Add time to a date
     *
     * @param date
     * @param time
     * @return
     */
    public static Date addTime(Date date, Long time) {
        date.setTime(date.getTime() + time);
        return date;
    }

    /**
     * Description: Add some years to a date
     *
     * @param date
     * @param years
     * @return
     */
    public static Date addYears(Date date, Integer years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * Description: Format a local DateTime with format pattern
     *
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static String toString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * Description: Format a local DateTime
     *
     * @param localDateTime
     * @return
     */
    public static String toString(LocalDateTime localDateTime) {
        return toString(localDateTime, "yyyyMMddHHmmss");
    }

    /**
     * Description: Convert a date to String datetime
     *
     * @param date
     * @return
     */
    public static String toDateTimeString(Date date) {
        return formatterDateTime.format(date);
    }

    /**
     * Description: Convert a date to String date
     *
     * @param date
     * @return
     */
    public static String toDateString(Date date) {
        return formatter.format(date);
    }

    /**
     * Description: Convert a date to Birth of date
     *
     * @param date
     * @return
     */
    public static String toDobString(Date date) {
        return formatterDob.format(date);
    }

    /**
     * Description: Return age of Birth of date
     *
     * @param dobStr
     * @return
     * @throws ParseException
     */
    public static Period getAge(String dobStr) throws ParseException {
        Date birthDay = formatterDob.parse(dobStr);
        LocalDate dob = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(dob, now);
    }

    /**
     * Description: Return days difference between two dates
     *
     * @param previousDate
     * @param nextDate
     * @return
     */
    public static long diffDays(Date previousDate, Date nextDate) {
        long diff = nextDate.getTime() - previousDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    /**
     * Description: Return seconds difference between two dates
     *
     * @param previousDate
     * @param nextDate
     * @return
     */
    public static long diffSecs(Date previousDate, Date nextDate) {
        long diff = nextDate.getTime() - previousDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.SECONDS);
    }
}
