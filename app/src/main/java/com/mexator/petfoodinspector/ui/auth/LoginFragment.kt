package com.mexator.petfoodinspector.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mexator.petfoodinspector.R
import com.mexator.petfoodinspector.databinding.FragmentLoginBinding
import com.mexator.petfoodinspector.ui.StartActivity

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_startActivity)
            val startActivityIntent = Intent(activity, StartActivity::class.java)
            startActivity(startActivityIntent)
            activity?.finish()
        }
    }
}