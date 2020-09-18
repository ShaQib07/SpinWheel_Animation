package com.shakib.testapp.view.spin_wheel

import android.os.Bundle
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shakib.testapp.R
import com.shakib.testapp.databinding.ActivitySpinWheelBinding

class SpinWheelActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpinWheelBinding
    private lateinit var viewModel: SpinWheelViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinWheelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SpinWheelViewModel::class.java)
        binding.spinViewModel = viewModel

        val spinAnimation = AnimationUtils.loadAnimation(this, R.anim.spin)

        viewModel.observeSpinButtonClick().observe(this, {
            if (it) {
                binding.cvSpin.startAnimation(spinAnimation)
            }
        })

        viewModel.observeChangeAnimButtonClick().observe(this, {
            when (it) {
                1 -> spinAnimation.interpolator = DecelerateInterpolator()
                2 -> spinAnimation.interpolator = AccelerateInterpolator()
                3 -> spinAnimation.interpolator = AccelerateDecelerateInterpolator()
                4 -> spinAnimation.interpolator = AnticipateInterpolator()
                5 -> spinAnimation.interpolator = OvershootInterpolator()
                6 -> spinAnimation.interpolator = AnticipateOvershootInterpolator()
                7 -> spinAnimation.interpolator = BounceInterpolator()
            }
        })
    }
}