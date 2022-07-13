package com.example.fregmentnavigation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.fregmentnavigation.databinding.FragmentOtpBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OtpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OtpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    /*private lateinit var etnumber1: EditText
    private lateinit var etnumber2: EditText
    private lateinit var etnumber3: EditText
    private lateinit var etnumber4: EditText
    private lateinit var btn_verifyotp: Button
    private lateinit var initview:View*/
    private lateinit var binding:FragmentOtpBinding
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
     binding= FragmentOtpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       /* etnumber1=initview.findViewById(R.id.etnumber1)*/
        binding.etnumber1.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?: 0) >= 0){
                binding.etnumber2.requestFocus()
            }
        }
        /*etnumber2=initview.findViewById(R.id.etnumber2)*/
        binding.etnumber2.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?: 0) >= 0){
                binding.etnumber3.requestFocus()
            }
        }
        /*etnumber3=initview.findViewById(R.id.etnumber3)*/
        binding.etnumber3.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?: 0) >= 0){
                binding.etnumber4.requestFocus()
            }
        }
        /*etnumber4=initview.findViewById(R.id.etnumber4)*/
        binding.etnumber4.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?: 0) >= 0){

            }
        }
        /*btn_verifyotp=initview.findViewById(R.id.btn_verifyotp)*/
        binding.btnVerifyotp.setOnClickListener {
            var enteredetnumber1=binding.etnumber1.text.toString()
            var enteredetnumber2=binding.etnumber2.text.toString()
            var enteredetnumber3=binding.etnumber3.text.toString()
            var enteredetnumber4=binding.etnumber4.text.toString()
            if (TextUtils.isEmpty(enteredetnumber1)){

                binding.etnumber1.error=("FILL")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(enteredetnumber2)){

                binding.etnumber2.error=("FILL")
                return@setOnClickListener
            }else if (TextUtils.isEmpty(enteredetnumber3)){

                binding.etnumber3.error=("FILL")
                return@setOnClickListener
            }else if (TextUtils.isEmpty(enteredetnumber4)){

                binding.etnumber4.error=("FILL")
                return@setOnClickListener
            }else{
       findNavController().navigate(R.id.action_otpFragment_to_screenFragment)
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
         * @return A new instance of fragment OtpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OtpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}