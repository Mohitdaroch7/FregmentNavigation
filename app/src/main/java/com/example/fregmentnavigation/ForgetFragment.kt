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
import androidx.navigation.fragment.findNavController
import com.example.fregmentnavigation.databinding.FragmentForgetBinding
import com.example.fregmentnavigation.databinding.FragmentRegistrationBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ForgetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForgetFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
  /* private lateinit var tilNewPassword: EditText
   private lateinit var tilconpassword: EditText
    private lateinit var btn_done: Button
    private lateinit var initview:View */
   /* lateinit var et_newpassword: TextInputEditText
    lateinit var et_conpassword: TextInputEditText
    lateinit var bt_done: MaterialButton
    lateinit var initview:View*/
    private lateinit var binding: FragmentForgetBinding
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
        binding= FragmentForgetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* et_newpassword=initview.findViewById(R.id.et_newpassword)
        et_conpassword=initview.findViewById(R.id.et_conpassword)
        bt_done=initview.findViewById(R.id.bt_done)*/
        binding.btnDone.setOnClickListener {
            var enteredpassword=binding.etNewPassword.text.toString()
            var enteredcpassword=binding.etConPassword.text.toString()
            if (TextUtils.isEmpty(enteredpassword) || enteredpassword.length<6){
                binding.etNewPassword.error=("PASSWORD IS LESS THAN 6")
                return@setOnClickListener
            }else if (TextUtils.isEmpty(enteredcpassword) || !enteredpassword.equals(enteredcpassword)){
                binding.etConPassword.error=("PASSWORD DOES NOT MATCH")
                return@setOnClickListener
            }else{
   findNavController().navigate(R.id.action_forgetFragment_to_screenFragment)
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
         * @return A new instance of fragment ForgetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ForgetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}