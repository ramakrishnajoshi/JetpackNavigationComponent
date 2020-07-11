package com.example.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_specify_amount.*

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {

    lateinit var recepientName : String
    lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recepientName = requireArguments().getString("name")!! //requireArguments @throws IllegalStateException if no arguments were supplied to
        // the Fragment.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = findNavController()

        textView_receipient_name.text = "Sending money to $recepientName"

        button_send_amount.setOnClickListener {
            val enteredAmount = editText_enter_amount_to_send.text.toString()
            if (enteredAmount.isNotEmpty()){
                val bundle = bundleOf(
                    "name" to recepientName,
                    "amount" to enteredAmount
                )
                navigationController.navigate(R.id.action_specifyAmountFragment_to_transactionConfirmationFragment, bundle)
            }else{
                Toast.makeText(view.context, "Please enter amount to continue", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
