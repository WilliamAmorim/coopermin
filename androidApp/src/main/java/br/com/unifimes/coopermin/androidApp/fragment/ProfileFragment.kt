package br.com.unifimes.coopermin.androidApp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.com.unifimes.coopermin.androidApp.R
import com.makeramen.roundedimageview.RoundedImageView

class ProfileFragment : Fragment() {

    lateinit var img_profile : RoundedImageView
    lateinit var textView_nome : TextView
    lateinit var textView_email : TextView
    lateinit var textView_telefone : TextView

    lateinit var linearLayout_perfil : LinearLayout
    lateinit var linearLayout_contrato : LinearLayout
    lateinit var linearLayout_config : LinearLayout

    lateinit var button_sair : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view =  inflater.inflate(R.layout.fragment_profile, container, false)

        img_profile = view.findViewById(R.id.img_profile)
        textView_nome = view.findViewById(R.id.textView_nome)
        textView_email = view.findViewById(R.id.textView_email)
        textView_telefone = view.findViewById(R.id.textView_telefone)
        linearLayout_perfil = view.findViewById(R.id.linearLayout_perfil)
        linearLayout_contrato = view.findViewById(R.id.linearLayout_contrato)
        linearLayout_config = view.findViewById(R.id.linearLayout_config)
        button_sair = view.findViewById(R.id.button_sair)

        linearLayout_contrato.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.contratosActivity2)
        })

        linearLayout_config.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingActivity)
        })




        return view;
    }

}