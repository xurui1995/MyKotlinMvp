package com.example.xr.mykotlinmvp.base

interface IBaseView {
    fun showLoading(msg: String = "")

    fun dismissLoading()
}