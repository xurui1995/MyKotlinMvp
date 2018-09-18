package com.example.xr.mykotlinmvp.ui.fragment


import com.example.xr.mykotlinmvp.R
import com.example.xr.mykotlinmvp.base.BaseFragment
import com.example.xr.mykotlinmvp.mvp.contract.HomeContract
import com.example.xr.mykotlinmvp.mvp.model.bean.HomeBean
import com.example.xr.mykotlinmvp.mvp.presenter.HomePresenter
import com.scwang.smartrefresh.header.MaterialHeader

class HomeFragment: BaseFragment(), HomeContract.View {

    override fun getLayoutId() = R.layout.fragment_home

    private var mTitle: String? = null

    private var num = 1

    private var loadingMore = false

    private var isRefresh = false

    private var mMaterialHeader: MaterialHeader? = null

    private val mPresenter by lazy { HomePresenter()}



    override fun initView() {
    }

    override fun lazyLoad() {
    }

    override fun setHomeData(homeBean: HomeBean) {
    }

    override fun setMoreData(itemList: ArrayList<HomeBean.Issue.Item>) {
    }

    override fun showError(msg: String, errorCode: Int) {
    }

    override fun showLoading(msg: String) {
    }

    override fun dismissLoading() {
    }

}