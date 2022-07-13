package com.example.fregmentnavigation

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.fregmentnavigation.databinding.FragmentRegistrationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
   /* private var param1: String? = null
    private var param2: String? = null
    private lateinit var fullname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cpassword: EditText
    private lateinit var button: Button
    private lateinit var login: TextView
    private lateinit var initview: View*/
    private lateinit var binding: FragmentRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            var param1 = it.getString(ARG_PARAM1)
            var param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding= FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*fullname = initview.findViewById(R.id.etName)
        email = initview.findViewById(R.id.etEmailAddress)
        password = initview.findViewById(R.id.etPassword)
        password.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?: 0) < 6) {
                password.requestFocus()
                password.error = ("PASSWORD MUST BE 6 DIGITS")
            }
        }

        cpassword =initview. findViewById(R.id.etconfirmpassword)
        button = initview.findViewById(R.id.btn_register)
        login = initview.findViewById(R.id.login)*/
        binding.login.setOnClickListener {
findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        binding.btnRegister.setOnClickListener {
            var enteredfullname = binding.etName.text.toString()
            var enteredemail = binding.etEmailAddress.text.toString()
            var enteredpassword = binding.etPassword.text.toString()
            var enteredcpass = binding.etconfirmpassword.text.toString()
            if (TextUtils.isEmpty(enteredfullname) || enteredfullname.length < 3) {
                binding.etName.error = ("NAME IS EMPTY OR INCORRECT")
                return@setOnClickListener
            } else if (!enteredemail.contains("@")) {
                binding.etEmailAddress.error = ("EMAIL IS EMPTY OR INVALID")
                return@setOnClickListener
            } else if (enteredpassword.length < 6) {
                binding.etPassword.error = ("PASSWORD IS EMPTY OR LESS THAN 6 DIGITS")
                return@setOnClickListener
            } else if (!enteredpassword.equals(enteredcpass)) {
               binding.etconfirmpassword.error = ("PASSWORD DOES NOT MATCH")
                return@setOnClickListener
            } else {
findNavController().navigate(R.id.action_registrationFragment_to_phoneFragment)
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
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}