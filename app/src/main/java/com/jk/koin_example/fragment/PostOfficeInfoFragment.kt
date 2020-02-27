package com.jk.koin_example.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jk.koin_example.R
import com.jk.koin_example.databinding.FragmentPostOfficeInfoBinding
import com.jk.koin_example.model.PostOfficeResponse
import com.jk.koin_example.network.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module
import androidx.lifecycle.Observer
import com.jk.koin_example.network.Status


/**
 * A simple [Fragment] subclass.
 */

val fragmentModule = module {
    factory { PostOfficeInfoFragment() }
}

class PostOfficeInfoFragment : Fragment() {

    private val postOfficeViewModel:PostOfficeViewModel by viewModel()
    private lateinit var binding: FragmentPostOfficeInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_office_info, container, false)
        binding.viewModel = postOfficeViewModel
        postOfficeViewModel.postOfficeResponse.observe(this, observer)
        return binding.root
    }

    private val observer = Observer<Resource<MutableList<PostOfficeResponse>>> {

        when(it.status) {
            Status.SUCCESS -> updatePostOfficeNameText(it.data?.get(0)?.postOffice?.get(0)?.name)
            Status.ERROR -> showError("Something not right")
            Status.LOADING -> showLoading()
        }
    }
    @SuppressLint("SetTextI18n")
    private fun showLoading() {
        binding.pinCodeLabel.text = "Loading..."
    }

    @SuppressLint("SetTextI18n")
    private fun showError(message: String) {
        binding.pinCodeLabel.text = "Error: $message"
    }

    @SuppressLint("SetTextI18n")
    private fun updatePostOfficeNameText(name: String?) {
        binding.pinCodeLabel.text = "Post Office = $name "
    }


}
