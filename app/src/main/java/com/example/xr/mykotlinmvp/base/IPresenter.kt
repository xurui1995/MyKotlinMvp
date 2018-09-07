package com.example.xr.mykotlinmvp.base

interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()
}