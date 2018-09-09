package com.example.xr.mykotlinmvp.ui.fragment

import android.os.Bundle
import com.example.xr.mykotlinmvp.R
import com.example.xr.mykotlinmvp.base.BaseFragment
import com.example.xr.mykotlinmvp.util.StatusBarUtil
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment() {

    private var mTitle: String? = null

    companion object {

        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initView() {
        activity?.let { StatusBarUtil.darkMode(it) }
       // activity?.let { StatusBarUtil.setPaddingSmart(it, toolbar) }
    }

    override fun lazyLoad() {
    }


}