package com.example.jetpacknavigation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.text.TextUtilsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_recepient.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecepientFragment : Fragment() {

    lateinit var navigationController : NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_choose_recepient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationController = findNavController()

        button_proceed_to_payment.setOnClickListener {
            val enteredName = editText_enter_receipient_name.text.toString()
            if (enteredName.isNotEmpty()){
                val bundle = bundleOf(
                    "name" to enteredName
                )
                navigationController.navigate(R.id.action_chooseRecepientFragment_to_specifyAmountFragment, bundle)
            }else{
                Toast.makeText(view.context, "Please enter name to continue", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
