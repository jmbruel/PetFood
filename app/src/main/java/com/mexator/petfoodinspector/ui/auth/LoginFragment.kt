package com.mexator.petfoodinspector.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.mexator.petfoodinspector.databinding.AuthFieldsBinding
import com.mexator.petfoodinspector.databinding.FragmentLoginBinding
import com.mexator.petfoodinspector.ui.StartActivity
import com.mexator.petfoodinspector.ui.auth.login.*

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var fieldsBinding: AuthFieldsBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        fieldsBinding = AuthFieldsBinding.bind(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.subscribe(this::render)

        binding.buttonLogin.setOnClickListener {
            viewModel.logIn(
                fieldsBinding.emailField.text.toString(),
                fieldsBinding.passwordField.text.toString()
            )
        }
    }

    private fun render(state: LoginViewState) {
        when (state) {
            is ProgressState -> {
                binding.progress.visibility = View.VISIBLE
            }
            is SuccessState -> {
                binding.progress.visibility = View.INVISIBLE
                val startActivityIntent = Intent(activity, StartActivity::class.java)
                startActivity(startActivityIntent)
                activity?.finish()
            }
            is ErrorState -> {
                binding.progress.visibility = View.INVISIBLE
                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}