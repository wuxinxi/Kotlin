package com.example.kotlin.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * 作者：Tangren_ on 2017/1/13 17:56.
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */

object Utils {

    private val decimalFormat = DecimalFormat("######0.00")
    private val sdf = SimpleDateFormat("yyyyMMddHHmmss")
    private val sdf2 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    /**
     * 订单号

     * @return
     */
    fun OrderNo(): String {
        val date = Date()
        val builder = StringBuilder("gas")
        builder.append(sdf.format(date))
        return builder.append(buildRandom(3)).toString()
    }

    private fun buildRandom(length: Int): Int {
        var num = 1
        var random = Math.random()
        if (random < 0.1)
            random = random + 0.1
        for (i in 0..length - 1) {
            num = num * 10
        }
        return (random * num).toInt()
    }


    // 当前系统时间
    fun getCurrentTime(): String {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return format.format(Date())
    }


    fun getType(type: String) = when (type) {
        "scan" -> "移动支付"
        "cash" -> "现金支付"
        "card" -> "会员支付"
        "1" -> "微信支付"
        "2" -> "支付宝"
        "3" -> "QQ钱包"
        else -> "UNKNOW"
    }


    /**
     * 元2分

     * @param amount
     * *
     * @return
     */
    fun Yuan2Fen(amount: String): String {
        val f = java.lang.Float.valueOf(amount)!! * 100

        return decimalFormat.format(f.toDouble())
    }

    /**
     * 支付状态

     * @param state
     * *
     * @return
     */
    fun payState(state: String) = when (state) {
        "0" -> "支付中"
        "1" -> "支付成功"
        "2" -> "支付失败"
        "3" -> "已冲正"
        "4" -> "已退款"
        "5" -> "退款"
        else -> "未知"
    }

    fun getPayType(t: String): String =
            when (t) {
                "微信" -> "1"
                "QQ" -> "2"
                else -> "3"
            }

}
