package br.com.unifimes.coopermin.androidApp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import br.com.unifimes.coopermin.androidApp.R


class HomeAssociadoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_associado, container, false)

        var linearLayout_openContrato = view.findViewById<LinearLayout>(R.id.linearLayout_openContrato)
        var linearLayout_openAssociado = view.findViewById<LinearLayout>(R.id.linearLayout_openAssociado)
        var imageView_config = view.findViewById<ImageView>(R.id.imageView_config)

        linearLayout_openAssociado.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeAssociadoFragment_to_associadoActivity)
        })

        linearLayout_openContrato.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeAssociadoFragment_to_contratosActivity)
        })

        imageView_config.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeAssociadoFragment_to_settingActivity2)
        })

        return view;
    }

}