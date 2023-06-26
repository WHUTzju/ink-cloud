package cn.hyperchain.ink.web.business.action.warn;

import cn.hyperchain.ink.core.util.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class WarnUtilTest {

    @Test
    public void lastDays() throws ParseException {

        Date ruleStartTime = new SimpleDateFormat("yyyy-MM-dd").parse("2023-05-19");

//        int ld = WarnUtil.lastDays(ruleStartTime, 15);
//        System.out.println(ld);
        System.out.println(DateUtil.countDaysBetween(ruleStartTime, new Date()));
    }


    @Test
    public void t_03() throws ParseException {

        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-17");
        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-05-16");
        Date d3 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-06-01");

        System.out.println(DateUtil.countDaysBetween(d1, d2));
        System.out.println(DateUtil.countDaysBetween(d1, new Date()));
        System.out.println(DateUtil.countDaysBetween(d2, new Date()));

        System.out.println(DateUtil.countDaysBetween(d1, d2) / 15);
        System.out.println(DateUtil.countDaysBetween(d1, new Date()) / 15);
        System.out.println(DateUtil.countDaysBetween(d2, new Date()) / 15);

        System.out.println(15 % 15);
    }


}