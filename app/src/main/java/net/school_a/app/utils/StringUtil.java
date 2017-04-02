/* 
 * Copyright 2012 Share.Ltd  All rights reserved.
 * Share.Ltd PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * @StringUtil.java - 2012-6-11 22:36:05 - YanXu
 */

package net.school_a.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * the String util class
 *
 * @author rock
 */
public class StringUtil {

    /**
     * 判读字符串是否为空
     *
     * @param inputString
     * @return
     */
    public static boolean isNullOrEmpty(String inputString) {
        if (null == inputString) {
            return true;
        } else if (inputString.trim().equals("")) {
            return true;
        }

        return false;
    }

    /**
     * 比较两个字符串是否相等
     *
     * @param arg1
     * @param arg2
     * @return
     */
    public static boolean compareEquals(String arg1, String arg2) {
        if (StringUtil.isNullOrEmpty(arg1)) {
            if (StringUtil.isNullOrEmpty(arg2)) {
                return true;
            } else {
                return false;
            }
        } else {
            return arg1.equals(arg2);
        }
    }

    public static String copy(String inputString) {
        if (inputString == null) {
            return null;
        }
        return new String(inputString);
    }

    public static String formatDuration(int hour, int min, int sec) {

        StringBuilder strBuider = new StringBuilder();
        if (hour < 10) {
            strBuider.append(0);
        }
        strBuider.append(hour).append(":");
        if (min < 10) {
            strBuider.append(0);
        }
        strBuider.append(min).append(":");
        if (sec < 10) {
            strBuider.append(0);
        }
        strBuider.append(sec);

        return strBuider.toString();
    }

    public static boolean isTelPhoneNumber(String phoneNumber) {
        Pattern p = Pattern
                .compile("^13[0-9]{1}[0-9]{8}$|15[0-9]{1}[0-9]{8}$|18[0-3,5-9]{1}[0-9]{8}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }

    public static boolean isEmailNumber(String email) {
        Pattern p = Pattern
                .compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * @param date
     * @param format yy-hh-mm
     * @return
     */
    public static String dateFomat(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String dateFormat(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static Date dateFomat(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * 字符串转为经纬度
     *
     * @param str
     * @return
     */
    public static int stringToGeopoint(String str) {
        // int) (39.918* 1E6)
        int i = 0;
        try {
            float temp = Float.parseFloat(str);
            i = (int) (temp * 1E6);
        } catch (Exception ex) {
            i = 0;
        }
        return i;
    }

    public static String dateFormat(long ms) {
        long temp = System.currentTimeMillis() - ms;
        Date date = new Date(ms);
        if (temp < 86400000) {
            return dateFomat(date, "HH:mm");
        } else {
            return dateFomat(date, "MM-dd");
        }
    }

    /**
     * 判断字符串是否是数字
     */
    public static boolean isNumber(String value) {
        return isInteger(value) || isDouble(value);
    }

    /**
     * 判断字符串是否是整数
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是浮点数
     */
    public static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            if (value.contains("."))
                return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
     * 判断某个字符串是否是字母
     */
    public static boolean isABC(String value) {
        try {
            Pattern p = Pattern.compile("^[A-Za-z]+$");
            Matcher m = p.matcher(value);
            return m.matches();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * byte[]转化为String
     *
     * @param bytes
     * @return
     */
    public static String byteToString(byte[] bytes) {
        String str;
        try {
            str = new String(bytes, "UTF-8");
        } catch (Exception e) {
            return e.getMessage();
        }

        //return new String(bytes,"UTF-8");
        return str;
    }

}
