package com.jojo.ark.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jojo.ark.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author JOJO
 * @date 2020/8/19
 */
//@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}