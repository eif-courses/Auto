package eif.viko.lt.auto.onboardingscreen.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import eif.viko.lt.auto.R
import kotlinx.android.synthetic.main.fragment_screen2.view.*
import kotlinx.android.synthetic.main.fragment_screen3.view.*

class Screen3Fragment : Fragment(R.layout.fragment_screen3) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.screen3_btn.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onBoardingScreen()
        }
    }
    private fun onBoardingScreen(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished4", true)
        editor.apply()
    }
}