package com.example.fregmentnavigation

import android.os.Bundle
import android.text.TextUtils

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fregmentnavigation.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    /*private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var forget: TextView
    private lateinit var login: Button
    private lateinit var create: TextView
    private lateinit var initview: View*/
    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
  /*    email=initview.findViewById(R.id.etEmail)
        password=initview.findViewById(R.id.etPassword)
        forget=initview.findViewById(R.id.tforget)
        login=initview.findViewById(R.id.btn_login)
        create=initview.findViewById(R.id.textView)*/
        binding.tforget.setOnClickListener {
        findNavController().navigate(R.id.action_loginFragment_to_forgetFragment)
        }
       binding.tvcreate.setOnClickListener {
        findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        binding.btnLogin.setOnClickListener {

            var enteredEmail=binding.etEmail.text.toString()
            var enteredpassword=binding.etPassword.text.toString()
            if (TextUtils.isEmpty(enteredEmail) || enteredEmail.contains("@") && enteredEmail.contains(".com")){
               binding.etEmail.error=("email is empty or incorrect")
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(enteredpassword) || enteredpassword.length<6){
                binding.etPassword.error=("password is empty or less than 6 digits")
                return@setOnClickListener
            }else{
findNavController().navigate(R.id.action_loginFragment_to_screenFragment)
            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}