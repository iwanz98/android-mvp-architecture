package com.wanztudio.mvp.utils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class DateUtils {

    private static String TAG = DateUtils.class.getSimpleName();

    protected static Calendar calendar;
    protected static DateFormat monthNameFormat;
    protected static DateFormat monthShortNameFormat;
    protected static DateFormat weekdayNameFormat;
    protected static DateFormat weekdayShortNameFormat;

    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static long getTimeElapsed(String start) {
        Calendar now = Calendar.getInstance();

        Calendar startTime = Calendar.getInstance();
        startTime.setTime(DateUtils.parseStringDate(start, "yyyy-MM-dd HH:mm:ss"));

        long milliseconds1 = startTime.getTimeInMillis();
        long milliseconds2 = now.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);

        System.out.println("Time in milliseconds: " + diff + " milliseconds.");
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
        System.out.println("Time in hours: " + diffHours + " hours.");
        System.out.println("Time in days: " + diffDays + " days.");

        return diff;
    }

    public static long getTimeMilis(String time) {
        Calendar now = Calendar.getInstance();
        now.setTime(DateUtils.parseStringDate(time, "yyyy-MM-dd HH:mm:ss"));

        long milliseconds = now.getTimeInMillis();
        long seconds = milliseconds / 1000;
        long minutes = milliseconds / (60 * 1000);
        long hours = milliseconds / (60 * 60 * 1000);
        long days = milliseconds / (24 * 60 * 60 * 1000);

        return milliseconds;
    }

    public static String getStringDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(date);
    }

    public static String getTimeleft(String time) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        String formattedDate = df.format(getCurrentDate());
        try {
            Date now = df.parse(formattedDate);
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date2 = format.parse(time);
            String remaining1 = android.text.format.DateUtils.formatElapsedTime((date2.getTime() - now.getTime()) / 1000);
            if (!remaining1.subSequence(0, 2).equals("00")) {
                SimpleDateFormat df1 = new SimpleDateFormat("HH:mm:ss");
                Date convertedDate = df1.parse(remaining1);
                String formattedDate1 = df.format(convertedDate);
                return formattedDate1;
            } else {
                return "";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDateFormatIndonesia(String tgl, String oldFormat, String newFormat) {
        Date date = parseStringDate(tgl, oldFormat);

        String hasil = "";

        if (newFormat.equals("dd MMMM yyyy"))
            hasil = DateUtils.getStringDate("dd", date) + " " + DateUtils.monthNameFormat().format(date) + " " + DateUtils.getStringDate("yyyy", date);
        else if (newFormat.equals("dd MMM yyyy"))
            hasil = DateUtils.getStringDate("dd", date) + " " + DateUtils.monthShortNameFormat().format(date) + " " + DateUtils.getStringDate("yyyy", date);
        else if (newFormat.equals("dd MMM"))
            hasil = DateUtils.getStringDate("dd", date) + " " + DateUtils.monthShortNameFormat().format(date);
        else if (newFormat.equals("dd"))
            hasil = DateUtils.getStringDate("dd", date);
        else if (newFormat.equals("MMM"))
            hasil = DateUtils.monthShortNameFormat().format(date);
        else if (newFormat.equals("yyyy"))
            hasil = DateUtils.getStringDate("yyyy", date);

        return hasil;
    }


    public static String getStringDate(String format, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(date);
    }

    public static String getStringDate(String format, long date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(DateUtils.longToDate(date));
    }

    public static String getStringDate2(String format, long date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(DateUtils.longToDate2(date));
    }

    public static Date parseStringDate(String strDate, String format) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            Date date = dateFormat.parse(strDate);

            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return today();
    }

    public static DateFormat monthNameFormat() {
        return monthNameFormat;
    }

    public static DateFormat monthShortNameFormat() {
        return monthShortNameFormat;
    }

    public static DateFormat weekdayNameFormat() {
        return weekdayNameFormat;
    }

    public static DateFormat weekdayShortNameFormat() {
        return weekdayShortNameFormat;
    }

    public static void setMonthsName(String[] newMonths) {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        symbols.setMonths(newMonths);
        monthNameFormat = new SimpleDateFormat("MMMM", symbols);
    }

    public static void setShortMonthsName(String[] newShortMonths) {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        symbols.setShortMonths(newShortMonths);
        monthShortNameFormat = new SimpleDateFormat("MMM", symbols);
    }

    public static void setWeekdaysName(String[] newWeekdays) {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        symbols.setWeekdays(newWeekdays);
        weekdayNameFormat = new SimpleDateFormat("EEEE", symbols);
    }

    public static void setShortWeekdaysName(String[] newShortWeekdays) {
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
        symbols.setShortWeekdays(newShortWeekdays);
        weekdayShortNameFormat = new SimpleDateFormat("EEE", symbols);
    }

    public static Date longToDate(long val) {
        return new Date(val * 1000);
    }

    public static Date longToDate2(long val) {
        return new Date(val);
    }

    public static long dateToLong(Date val) {
        return val.getTime() / 1000;
    }

    public static Date today() {
        calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static Date tomorrow() {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date nextYear() {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    public static Date nextMonth() {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    public static String[] monthLabels() {
        String[] titles = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        return titles;
    }

    public static String getmonthLabel(int posisi) {

        String[] titles = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        return titles[posisi];
    }

    public static String[] monthLabelsShort() {
        String[] titles = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"};

        return titles;
    }

    public static String getmonthLabelShort(int posisi) {

        String[] titles = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sep", "Okt", "Nov", "Des"};

        return titles[posisi];
    }

    public static String[] weekDayLabels() {
        String[] titles = {"#", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

        return titles;
    }

    public static String[] weekDayLabelsShort() {
        String[] titles = {"#", "Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"};

        return titles;
    }
}
