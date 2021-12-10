package br.com.unifimes.coopermin.androidApp.api

import java.io.BufferedInputStream
import java.io.InputStream
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets


class HttpHelper {

    fun post(json: String){

        val url = URL("https://coopermin.herokuapp.com/api/login")
        val http = url.openConnection() as HttpURLConnection
        http.requestMethod = "POST"
        http.doOutput = true
        http.setRequestProperty("Content-Type", "application/json")

        val data = "{\"login\":\"associado1@gmail.com\",\"senha\":\"123\"}"

        val out = data.toByteArray(StandardCharsets.UTF_8)

        val stream = http.outputStream
        stream.write(out)

        println("@@@@@@@@@@@@@@@@@@=> "+http.responseCode.toString() + " " + http.responseMessage)
        http.disconnect()


    }

    fun p2():String{

        val url = URL("https://coopermin.herokuapp.com/api/login")
        val http: HttpURLConnection = url.openConnection() as HttpURLConnection
        http.setRequestMethod("POST")
        http.setDoOutput(true)
        http.setRequestProperty("Content-Type", "application/json")


        val data = "{\"login\":\"associado1@gmail.com\",\"senhaa\":\"123\"}"

        val out: ByteArray = data.toByteArray(StandardCharsets.UTF_8)

        val stream: OutputStream = http.getOutputStream()
        stream.write(out)

        val x: InputStream = BufferedInputStream(http.getInputStream())
        //val result: String = org.apache.commons.io.IOUtils.toString(x, "UTF-8")
        //val jsonObject = JSONObject(x.toString())

        println("1****************?" + http.responseCode + " || " + http.getResponseMessage() + " || " + x.toString())

        http.disconnect()



        return "Retorno"
    }


}