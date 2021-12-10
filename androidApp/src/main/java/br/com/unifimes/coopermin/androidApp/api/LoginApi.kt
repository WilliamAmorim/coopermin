package br.com.unifimes.coopermin.androidApp.api

import android.os.AsyncTask
import br.com.unifimes.coopermin.shared.model.ErrorModel
import com.google.gson.Gson
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class LoginApi : AsyncTask<Void, Void, ErrorModel>() {

    override fun doInBackground(vararg params: Void?): ErrorModel? {


        val resposta = StringBuilder()
        try {
            val url = URL("https://coopermin.herokuapp.com/api/login")
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.setRequestMethod("POST")
            connection.setRequestProperty("Accept", "application/json")
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000)

//            var jsonInputString = "{\"login\": \"associado1@gmail.com\", \"senha\": \"123\"}"
//
//            connection.getOutputStream().use { os ->
//                val input = jsonInputString.toByteArray(charset("utf-8"))
//                os.write(input, 0, input.size)
//            }


            connection.connect()

//            val scanner = Scanner(url.openStream())
//            while (scanner.hasNext()) {
//                resposta.append(scanner.next())
//            }

            System.out.println("Resposta:"+url.toString())

        } catch (e: MalformedURLException) {
            e.printStackTrace()
            System.out.println("EXCEPTION:" + e.message)
        } catch (e: IOException) {
            e.printStackTrace()
            System.out.println("EXCEPTION:" + e.message)
        }



        return Gson().fromJson<Any>(resposta.toString(), ErrorModel()::class.java) as ErrorModel?
    }

}