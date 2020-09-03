package com.fourall.home.ui.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.fragment.app.Fragment
import com.fourall.home.R
import com.fourall.home.R.drawable.logo_animation
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(){

//    private lateinit var homeViewModel: HomeViewModel
    private lateinit var rocketAnimation: AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rocketImage = view.findViewById<ImageView>(R.id.logoImageView).apply {
            setBackgroundResource(R.drawable.logo_animation)
            rocketAnimation = background as AnimationDrawable
        }
        SpringAnimation(rocketImage, DynamicAnimation.SCALE_X, 10f) to
        SpringAnimation(rocketImage, DynamicAnimation.SCALE_X, 10000000f)
        rocketAnimation.start()
    }


}