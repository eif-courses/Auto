package eif.viko.lt.auto.onboardingscreen.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import eif.viko.lt.auto.R
import kotlinx.android.synthetic.main.fragment_screen1.view.*
import kotlinx.android.synthetic.main.fragment_screen1.view.screen1_btn
import kotlinx.android.synthetic.main.fragment_screen2.view.*


class Screen2Fragment : Fragment(R.layout.fragment_screen2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2onBoardingScreen)

        view.screen2_btn.setOnClickListener {
            viewPager?.currentItem = 2
        }

    }
}