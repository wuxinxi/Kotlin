package com.example.kotlin.http

import com.example.kotlin.bean.Banner
import retrofit2.http.GET
import retrofit2.http.Headers
import rx.Observable

/**
 * 作者：Tangren on 2017/5/23 19:12
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */
interface APIService {

    @Headers("Cache-Control: public, max-age=60 * 60 * 24 * 7")
    @GET("/course_api/banner/query?type=1")
    fun getHot(): Observable<List<Banner>>

}
