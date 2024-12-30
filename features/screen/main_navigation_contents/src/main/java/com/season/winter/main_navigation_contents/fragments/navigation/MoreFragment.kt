package com.season.winter.main_navigation_contents.fragments.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.season.winter.main_navigation_contents.databinding.FragmentMoreBinding
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel

class MoreFragment: Fragment() {

    private var viewDataBinding: FragmentMoreBinding? = null
    val binding get() = viewDataBinding!!

    private val activityViewModel: MainNavigationViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentMoreBinding.inflate(inflater).also {
            viewDataBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding = null
    }
}