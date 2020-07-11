package com.example.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_transaction_confirmation.*

class TransactionConfirmationFragment : Fragment() {

    lateinit var recepientName : String
    lateinit var amount : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_transaction_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recepientName = arguments!!.getString("name")!!
        amount = arguments!!.getString("amount")!!
        transaction_confirmation_message.text = "Sending INR $amount to $recepientName"
    }
}
