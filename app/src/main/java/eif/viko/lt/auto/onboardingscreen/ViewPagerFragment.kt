package eif.viko.lt.auto.onboardingscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eif.viko.lt.auto.R
import eif.viko.lt.auto.onboardingscreen.screens.Screen1Fragment
import eif.viko.lt.auto.onboardingscreen.screens.Screen2Fragment
import eif.viko.lt.auto.onboardingscreen.screens.Screen3Fragment
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = arrayListOf(
            Screen1Fragment(),
            Screen2Fragment(),
            Screen3Fragment()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        view.viewPager2onBoardingScreen.adapter = adapter
    }
}