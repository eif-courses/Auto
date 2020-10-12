package eif.viko.lt.auto.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import eif.viko.lt.auto.Adapters.AutoListAdapter
import eif.viko.lt.auto.R
import eif.viko.lt.auto.ViewModels.AutoViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var autoViewModel:AutoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        autoViewModel = ViewModelProvider(this).get(AutoViewModel::class.java)

        val adapterAuto: AutoListAdapter by lazy { AutoListAdapter() }

        adapterAuto.submitList(autoViewModel.autoRepository.getAutos().value)

        auto_recycleview.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
            adapter = adapterAuto
        }
    }
}