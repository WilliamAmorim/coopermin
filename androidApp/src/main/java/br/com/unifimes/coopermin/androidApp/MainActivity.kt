package br.com.unifimes.coopermin.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.unifimes.coopermin.shared.Greeting

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
