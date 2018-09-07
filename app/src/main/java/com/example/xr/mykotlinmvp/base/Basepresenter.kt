package com.example.xr.mykotlinmvp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class Basepresenter<T: IBaseView> : IPresenter<T> {

    var mRootView:T? = null
        private set

    private var compositeDisposable = CompositeDisposable()

    override fun attachView(mRootView: T) {
        this.mRootView = mRootView
    }

    override fun detachView() {
       mRootView = null

        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }


    private val isViewAttached: Boolean
            get() = mRootView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachException()
    }

    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private class MvpViewNotAttachException internal constructor(): RuntimeException("Please call IPresenter.attachView(IBaseView) before requesting data to the IPresenter")
}