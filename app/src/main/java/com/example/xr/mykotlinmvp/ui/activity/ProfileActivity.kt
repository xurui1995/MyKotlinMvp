package com.example.xr.mykotlinmvp.ui.activity

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.xr.mykotlinmvp.R
import com.example.xr.mykotlinmvp.base.BaseActivity
import com.example.xr.mykotlinmvp.util.StatusBarUtil
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import com.scwang.smartrefresh.layout.util.DensityUtil
import kotlinx.android.synthetic.main.activity_profile.*
import java.util.*

class ProfileActivity: BaseActivity() {

    private var mOffset = 0
    private var mScrollY = 0

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        StatusBarUtil.darkMode(this)
        StatusBarUtil.setPaddingSmart(this, toolbar)

        refreshLayout.apply {

            setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
                override fun onHeaderPulling(header: RefreshHeader?, percent: Float, offset: Int, headerHeight: Int, extendHeight: Int) {
                    mOffset = offset / 2
                    parallax.translationY = (mOffset - mScrollY).toFloat()
                    toolbar.alpha = 1 - Math.min(percent, 1f)
                }

                override fun onHeaderReleasing(header: RefreshHeader?, percent: Float, offset: Int, footerHeight: Int, extendHeight: Int) {
                    mOffset = offset / 2
                    parallax.translationY = (mOffset - mScrollY).toFloat()
                    toolbar.alpha = 1 - Math.min(percent, 1f)

                }
            })

            setOnRefreshListener{ mWebView.loadUrl("https://www.baidu.com")}
            autoRefresh()
        }

        scrollView.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener {
            private var lastScrollY = 0
            private val h = DensityUtil.dp2px(170f)
            private val color = ContextCompat.getColor(applicationContext, R.color.colorPrimary) and 0x00ffffff
            override fun onScrollChange(v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
                var tScrollY = scrollY
                if (lastScrollY < h) {
                    tScrollY = Math.min(h , scrollY)
                    mScrollY = if (tScrollY > h) h else tScrollY
                    buttonBarLayout.alpha = 1f * mScrollY / h
                    toolbar.setBackgroundColor(mScrollY / h * 255 shl 24 or color)
                    parallax.translationY = (mOffset - mScrollY).toFloat()
                }
                lastScrollY = tScrollY
            }
        })

        buttonBarLayout.alpha = 0f

        toolbar.apply {
            alpha = 0f
            setBackgroundColor(0)
            setNavigationOnClickListener { finish() }
        }

        mWebView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {

                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    refreshLayout.finishRefresh()
                    view?.loadUrl(String.format(Locale.CHINA, "javascript:document.body.style.paddingTop='%fpx'; void 0", DensityUtil.px2dp(mWebView.paddingTop.toFloat())))
                }
            }
        }

    }

    override fun initData() {
    }

    override fun start() {
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_profile
    }

}