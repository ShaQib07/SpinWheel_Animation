package com.shakib.testapp.view.spin_wheel

import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shakib.testapp.R
import com.shakib.testapp.application.MyApp

class SpinWheelViewModel : ViewModel() {

    var pointText = SpannableString(MyApp.myResources.getString(R.string.points)).apply {
        setSpan(RelativeSizeSpan(2f), 0,MyApp.myResources.getString(R.string.points).length-3, 0);
    }
    private val startSpin = MutableLiveData(false)
    private val changeAnim = MutableLiveData(0)

    fun onSpinClicked() {
        startSpin.value = true
    }

    fun onChangeAnimationClicked() {
        if (changeAnim.value == 7)
            changeAnim.value = 0

        changeAnim.value = changeAnim.value?.plus(1)
    }

    fun observeSpinButtonClick() : LiveData<Boolean> = startSpin

    fun observeChangeAnimButtonClick() : LiveData<Int> = changeAnim

}