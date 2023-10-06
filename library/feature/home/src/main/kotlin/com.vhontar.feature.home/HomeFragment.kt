package com.vhontar.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vhontar.core.logger.Logger
import com.vhontar.domain.logger.LogMessage

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Logger.create().log(
            LogMessage(tag = "LoginFragment", message = "onCreateView")
        )
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}