package br.com.unifimes.coopermin.androidApp

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.unifimes.coopermin.androidApp.fragment.HomeFragment
import br.com.unifimes.coopermin.androidApp.fragment.ProfileFragment

class HomeActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var li_home : LinearLayout
    lateinit var li_contrato : LinearLayout
    lateinit var li_profile : LinearLayout;

    lateinit var img_circle1 : ImageView
    lateinit var img_circle2 : ImageView
    lateinit var img_circle3 : ImageView

    lateinit var img_home : ImageView
    lateinit var img_contrato : ImageView
    lateinit var img_profile : ImageView

    lateinit var txt_home : TextView
    lateinit var txt_contrato : TextView
    lateinit var txt_profile : TextView

    var slideDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        li_home = findViewById(R.id.li_home)
        li_contrato = findViewById(R.id.li_contrato)
        li_profile  = findViewById(R.id.li_profile)

        img_circle1 = findViewById(R.id.img_circle1)
        img_circle2 = findViewById(R.id.img_circle2)
        img_circle3 = findViewById(R.id.img_circle3)

        img_home = findViewById(R.id.img_home)
        img_contrato = findViewById(R.id.img_contrato)
        img_profile = findViewById(R.id.img_profile)

        txt_home  = findViewById(R.id.txt_home)
        txt_contrato  = findViewById(R.id.txt_contrato)
        txt_profile  = findViewById(R.id.txt_profile)

        li_home.setOnClickListener(this)
        li_contrato.setOnClickListener(this)
        li_profile.setOnClickListener(this)

        img_circle1.setVisibility(View.VISIBLE)
        img_home.setImageResource(R.drawable.ic_outline_home_green)
        txt_home.setTextColor(Color.parseColor("#2ac17e"))

    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.li_home -> {
                    home(true); contrato(false); perfil(false)
                }
                R.id.li_contrato -> {
                    home(false); contrato(true); perfil(false)
                }
                R.id.li_profile -> {
                    home(false);contrato(false);perfil(true)
                }

            }
        }

    }

    fun home(ativo: Boolean?){
        if(ativo == true) {
            img_circle1.setVisibility(View.VISIBLE)
            img_home.setImageResource(R.drawable.ic_outline_home_green)
            txt_home.setTextColor(Color.parseColor("#2ac17e"))
            replace_fragment(HomeFragment())
        }else{
            img_circle1.setVisibility(View.GONE)
            img_home.setImageResource(R.drawable.ic_outline_home_24)
            txt_home.setTextColor(Color.parseColor("#757575"))
        }
    }

    fun contrato(ativo: Boolean?){
        if(ativo == true) {
            img_circle2.setVisibility(View.VISIBLE)
            img_contrato.setImageResource(R.drawable.ic_outline_assignment_green)
            txt_contrato.setTextColor(Color.parseColor("#2ac17e"))
        }else{
            img_circle2.setVisibility(View.GONE)
            img_contrato.setImageResource(R.drawable.ic_outline_contract_24)
            txt_contrato.setTextColor(Color.parseColor("#757575"))
        }
    }

    fun perfil(ativo: Boolean?){
        if(ativo == true) {
            img_circle3.setVisibility(View.VISIBLE)
            img_profile.setImageResource(R.drawable.ic_outline_account_circle_green)
            txt_profile.setTextColor(Color.parseColor("#2ac17e"))
            replace_fragment(ProfileFragment())
        }else{
            img_circle3.setVisibility(View.GONE)
            img_profile.setImageResource(R.drawable.ic_outline_account_circle_24)
            txt_profile.setTextColor(Color.parseColor("#757575"))
        }
    }

    fun replace_fragment(fragment: Fragment?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frame, fragment!!)
        transaction.commit()
    }


}