package com.example.xr.mykotlinmvp.widget

import com.flyco.tablayout.listener.CustomTabEntity

class TabEntity(var title: String, private var selectedIcon: Int, private var unSelectIcon: Int): CustomTabEntity {

    override fun getTabUnselectedIcon() = unSelectIcon

    override fun getTabSelectedIcon() = selectedIcon

    override fun getTabTitle() = title

}