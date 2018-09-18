package com.example.xr.mykotlinmvp.mvp.presenter

import com.example.xr.mykotlinmvp.base.Basepresenter
import com.example.xr.mykotlinmvp.mvp.contract.HomeContract
import com.example.xr.mykotlinmvp.mvp.model.bean.HomeBean

class HomePresenter: Basepresenter<HomeContract.View>(), HomeContract.Presenter {

    private val bannerHomeBean: HomeBean? = null

    private var nextPageUrl: String? =null


    override fun requestHomeData(num: Int) {
    }

    override fun laodMoreData() {
    }

}