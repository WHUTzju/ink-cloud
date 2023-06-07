package cn.hyperchain.ink.core.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author inkchain
 * @description
 * @date 2021/2/11
 */
public class DateUtil {


    /**
     * date2>date1
     * @param date1
     * @param date2
     * @return
     */
    public static long countDaysBetween(Date date1, Date date2) {

        LocalDateTime dateTime1 = date1.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        LocalDateTime dateTime2 = date2.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return ChronoUnit.DAYS.between(dateTime1, dateTime2);
    }

//
//    /**
//     * 当前日期 是否比 ruleStartTime 超过 ruleDays
//     * <p>
//     * 例如 2023-05-29 > 2023-05-20+4days
//     *
//     * @param ruleStartTime
//     * @param ruleDays
//     * @return
//     */
//    public static Boolean nowGreaterThen(Date ruleStartTime, Integer ruleDays) {
//        long nowTime = System.currentTimeMillis();
//        return nowTime > addDays(ruleStartTime, ruleDays).getTime();
//    }
//
//    /**
//     * 当前日期 是否比 ruleStartTime 小于 ruleDays
//     *
//     * @param ruleStartTime
//     * @param ruleDays
//     * @return
//     */
//    public static Boolean nowLessThen(Date ruleStartTime, Integer ruleDays) {
//        long nowTime = System.currentTimeMillis();
//        return nowTime < addDays(ruleStartTime, ruleDays).getTime();
//    }


    /**
     * 自然日
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(final Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 自然日
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addWorkDays(final Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);

        return new Date(cal.getTime().getTime());
    }

    /**
     * 上nums个工作日
     *
     * @param todayDate
     * @param nums
     * @return
     */
    public static Date lastWorkDay(Date todayDate, int nums) {
        if (nums < 1) {
            return todayDate;
        }
        LocalDateTime dateTime = todayDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        while (nums > 0) {
            dateTime = lastWorkDay(dateTime);
            nums--;
        }
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 下nums个工作日
     *
     * @param todayDate
     * @param nums
     * @return
     */
    public static Date nextWorkDay(Date todayDate, int nums) {
        if (nums < 1) {
            return todayDate;
        }
        LocalDateTime dateTime = todayDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        while (nums > 0) {
            dateTime = nextWorkDay(dateTime);
            nums--;
        }
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 下一个工作日
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime nextWorkDay(LocalDateTime dateTime) {
        LocalDateTime modifiedDate = dateTime.plusDays(1);
        DayOfWeek week = modifiedDate.getDayOfWeek();
        /**
         * 如果不是周末 则是工作日
         */
        if (!week.equals(DayOfWeek.SATURDAY) && !week.equals(DayOfWeek.SUNDAY)) {
            return modifiedDate;
        }
        return nextWorkDay(modifiedDate);
    }

    /**
     * 上一个工作日
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime lastWorkDay(LocalDateTime dateTime) {
        LocalDateTime modifiedDate = dateTime.minusDays(1);
        DayOfWeek week = modifiedDate.getDayOfWeek();
        /**
         * 如果不是周末 则是工作日
         */
        if (!week.equals(DayOfWeek.SATURDAY) && !week.equals(DayOfWeek.SUNDAY)) {
            return modifiedDate;
        }
        return lastWorkDay(modifiedDate);
    }


    public static Date getStartOfDate(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


}
