package cn.hyperchain.ink.core.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void addDays() {

        //10天后
        System.out.println(DateUtil.addDays(new Date(), 10));
        //10天前
        System.out.println(DateUtil.addDays(new Date(), -10));
    }

    @Test
    public void t_01() {

        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
    }

    @Test
    public void t_03() throws ParseException {

//        System.out.println(DateUtil.nowGreaterThen(
//                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//                        .parse("2023-05-26 12:12:12"), 3
//        ));

        System.out.println(DateUtil.countDaysBetween(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse("2023-05-26 12:12:12"), new Date()));
    }

    @Test
    public void t_04() {
        System.out.println(1 / 15);
    }
}