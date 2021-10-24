package br.com.unifimes.coopermin.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class DetalheProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)

            var viewPager_imgProduto = findViewById<ViewPager>(R.id.viewPager_imgProduto)
            var textView_porcentagemDesconto = findViewById<TextView>(R.id.textView_porcentagemDesconto)
            var textView_peso = findViewById<TextView>(R.id.textView_peso)
            var textView_tituloProduto = findViewById<TextView>(R.id.textView_tituloProduto)
            var textView_subPreco = findViewById<TextView>(R.id.textView_subPreco)
            var textView_preco = findViewById<TextView>(R.id.textView_preco)
            var textView_descricao = findViewById<TextView>(R.id.textView_descricao)
            var textView_verTodos = findViewById<TextView>(R.id.textView_verTodos)
            var recyclerView_selling = findViewById<RecyclerView>(R.id.recyclerView_selling)
    }
}