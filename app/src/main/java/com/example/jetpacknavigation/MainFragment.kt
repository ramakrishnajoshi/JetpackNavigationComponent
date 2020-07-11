package com.example.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    /* NavController manages app navigation within a NavHost. Apps will generally obtain a controller
    * directly from a host, or by using one of the utility methods on the Navigation class rather
    * than create a controller directly.Navigation flows and destinations are determined by the
    * navigation graph owned by the controller.
    * */

    /* Kotlin:
    Fragment.findNavController()
    View.findNavController()
    Activity.findNavController(viewId: Int)

    Java:
    NavHostFragment.findNavController(Fragment)
    Navigation.findNavController(Activity, @IdRes int viewId)
    Navigation.findNavController(View)*/

    lateinit var navigationLinksController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationLinksController = Navigation.findNavController(view)
        //or navigationLinksController = findNavController()

        view_transactions_btn.setOnClickListener {
            navigationLinksController.navigate(R.id.action_mainFragment_to_viewTransactionsFragment)
        }

        send_money_btn.setOnClickListener {
            send_money_btn.text = "Changed Text"
            navigationLinksController.navigate(R.id.action_mainFragment_to_chooseRecepientFragment)
        }

        view_balance_btn.setOnClickListener {
            navigationLinksController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }

    }

}
