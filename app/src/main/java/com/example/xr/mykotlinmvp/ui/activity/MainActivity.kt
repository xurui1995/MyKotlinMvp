package com.example.xr.mykotlinmvp.ui.activity


import android.os.Bundle
import com.example.xr.mykotlinmvp.R
import com.example.xr.mykotlinmvp.base.BaseActivity
import com.example.xr.mykotlinmvp.widget.TabEntity
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")

    private val mIconUnSelectArray = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)

    private val mIconSelectArray = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)

    private var mIndex = 0

    private var mTabEntities = ArrayList<CustomTabEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            mIndex = it.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)

        initTab()
        tab_layout.currentTab = mIndex


    }

    private fun initTab() {
        (0 until mTitles.size)
                .mapTo(mTabEntities) {
                    TabEntity(mTitles[it], mIconSelectArray[it], mIconUnSelectArray[it])
                }

        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {

            }

            override fun onTabReselect(position: Int) {
            }

        })
    }


    override fun initView() {

    }

    override fun initData() {

    }

    override fun start() {
    }

    override fun setLayoutId() = R.layout.activity_main

}
