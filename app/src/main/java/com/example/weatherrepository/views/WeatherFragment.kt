package com.example.weatherrepository.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherrepository.MyApplication
import com.example.weatherrepository.databinding.FragmentFirstBinding
import com.example.weatherrepository.viewmodels.WeatherFragmentViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WeatherFragment  : Fragment() {
    @Inject
    lateinit var viewmodel: WeatherFragmentViewModel

    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.model = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MyApplication().appComponent.inject(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewmodel.dispose()
    }
}