package com.example.aaron.examenappgrados.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.aaron.examenappgrados.R
import com.example.aaron.examenappgrados.network.SoapCaller
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mf_btnSend.setOnClickListener {
            if (mf_edtCuantity.text.isNotEmpty()) {
                val celsius = mf_edtCuantity.text.toString()
                context?.let {
                    context ->
                    SoapCaller.convert(context,celsius) {
                        response ->

                    }
                }
            }
        }
    }
}
