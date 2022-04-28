package com.eren.mypipeline

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.eren.mypipeline.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.textviewFirst.text = BuildConfig.FLAVOR + BuildConfig.BUILD_TYPE + " \r\n inDebugMode= " + isDebug(requireContext()).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun isDebug(context: Context): Boolean {
        val pName: String = context.getPackageName()
        return if (pName != null && pName.endsWith(".debug")) {
            true
        } else {
            false
        }
    }
}