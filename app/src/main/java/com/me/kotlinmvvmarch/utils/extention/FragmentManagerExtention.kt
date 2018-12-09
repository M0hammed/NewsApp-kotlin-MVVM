package com.me.kotlinmvvmarch.utils.extention

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.me.kotlinmvvmarch.R
//import com.me.myapplication.R

internal fun FragmentManager.addFragment(containerLayout: Int, fragment: Fragment,
                                                               TAG: String, toolbarTitle: String?, enableToolBarIcons: Boolean,
                                                               animationIn: Int = R.anim.slide_in, animationOut: Int = R.anim.slide_out) {
    this.beginTransaction()
            .add(containerLayout, fragment, TAG)
            .setCustomAnimations(animationIn, animationOut)
            .commit()
}

internal fun FragmentManager.removeFragment(TAG: String, toolbarTitle: String?, enableToolBarIcons: Boolean,
                                                                  animationIn: Int = R.anim.slide_in, animationOut: Int = R.anim.slide_out) {
    this.findFragmentByTag(TAG)?.let {
        this.beginTransaction()
                .remove(it)
                .setCustomAnimations(animationIn, animationOut)
                .commitNow()
    }
}

internal fun FragmentManager.replaceFragment(containerLayout: Int, fragment: Fragment,
                                                                   TAG: String, toolbarTitle: String?, enableToolBarIcons: Boolean,
                                                                   animationIn: Int = R.anim.slide_in, animationOut: Int = R.anim.slide_out) {
    this.beginTransaction()
            .replace(containerLayout, fragment, TAG)
            .setCustomAnimations(animationIn, animationOut)
            .commit()
}