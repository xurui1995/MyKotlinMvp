package com.example.xr.mykotlinmvp.mvp.model

import com.example.xr.mykotlinmvp.mvp.model.bean.HomeBean
import com.example.xr.mykotlinmvp.net.RetrofitManager
import com.example.xr.mykotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

class HomeModel {

    fun requestHomeData(num: Int): Observable<HomeBean> {
        return RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
    }

    fun loadMoreData(url: String): Observable<HomeBean> {
        return RetrofitManager.service.getMoreHomeData(url)
    }
}