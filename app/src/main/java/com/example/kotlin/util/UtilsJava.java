package com.example.kotlin.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：Tangren_ on 2017/1/13 17:56.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

public class UtilsJava {
    private static DecimalFormat decimalFormat = new DecimalFormat("######0.00");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 订单号
     *
     * @return
     */
    public static String OrderNo() {
        Date date = new Date();
        StringBuilder builder = new StringBuilder("gas");
        builder.append(sdf.format(date));
        return builder.append(buildRandom(3)).toString();
    }

    private static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1)
            random = random + 0.1;
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) (random * num);
    }


    public static String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateString = format.format(date);// 当前系统时间
        return dateString;
    }

    public static String payType(String type) {
        if (type.equals("scan"))
            return "移动支付";
        else if (type.equals("cash"))
            return "现金支付";
        else if (type.equals("card"))
            return "会员支付";
        else if (type.equals("1"))
            return "微信支付";
        else if (type.equals("2"))
            return "支付宝";
        else if (type.equals("3"))
            return "QQ钱包";

        return type;
    }

    /**
     * 元2分
     *
     * @param amount
     * @return
     */
    public static String Yuan2Fen(String amount) {
        float f = Float.valueOf(amount) * 100;
        return decimalFormat.format(f);
    }

    /**
     * 支付状态
     *
     * @param state
     * @return
     */
    public static String payState(String state) {
        String payState = null;
        switch (state) {
            case "0":
                payState = "支付中";
                break;
            case "1":
                payState = "支付成功";
                break;
            case "2":
                payState = "支付失败";
                break;
            case "3":
                payState = "已冲正";
                break;
            case "4":
                payState = "已退款";
                break;
            case "5":
                payState = "退款";
                break;
            default:
                payState = "未知";
                break;
        }
        return payState;
    }

    public static String getPayType(String s) {
        switch (s) {
            case "微信":
                return s = "1";
            case "QQ":
                return s = "3";
            case "支付宝":
                return s = "3";
        }
        return "1";
    }


}
