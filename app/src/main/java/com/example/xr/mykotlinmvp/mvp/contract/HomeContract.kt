package com.example.xr.mykotlinmvp.mvp.contract

import com.example.xr.mykotlinmvp.base.IBaseView
import com.example.xr.mykotlinmvp.base.IPresenter
import com.example.xr.mykotlinmvp.mvp.model.bean.HomeBean

interface HomeContract {

    interface View: IBaseView {

        fun setHomeData(homeBean: HomeBean)

        fun setMoreData(itemList: ArrayList<HomeBean.Issue.Item>)

        fun showError(msg: String, errorCode: Int)
    }

    interface Presenter : IPresenter<View> {
        fun requestHomeData(num: Int)

        fun laodMoreData()
    }
}