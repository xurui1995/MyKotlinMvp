package com.example.xr.mykotlinmvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.xr.mykotlinmvp.R
import com.example.xr.mykotlinmvp.base.BaseFragment
import com.example.xr.mykotlinmvp.ui.activity.ProfileActivity
import com.example.xr.mykotlinmvp.util.StatusBarUtil
import com.example.xr.mykotlinmvp.util.addView
import com.example.xr.mykotlinmvp.util.showToast
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment(), View.OnClickListener {

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
        activity?.let { StatusBarUtil.setPaddingSmart(it, toolbar) }

        this.addView(tv_view_homepage, iv_avatar, iv_about, tv_collection, tv_comment,
                tv_mine_attention, tv_mine_cache, tv_watch_history, tv_feedback)
    }

    override fun lazyLoad() {
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.iv_avatar , R.id.tv_view_homepage -> {
                startActivity(Intent(activity, ProfileActivity::class.java))
            }
            R.id.iv_about -> {

            }

            else -> {showToast("开发ing")}
        }
    }


}