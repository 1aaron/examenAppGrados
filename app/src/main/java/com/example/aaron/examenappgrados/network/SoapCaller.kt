package com.example.aaron.examenappgrados.network

import android.content.Context
import android.util.Log
import com.example.aaron.examenappgrados.R
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.PropertyInfo
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE

object SoapCaller {
    fun convert(context: Context, celsius: String, completionHandler: (response: String) -> Unit) {
        Thread {
            val soapObject = SoapObject(context.getString(R.string.NAMESPACE),context.getString(R.string.SOAP_METHOD))
            val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)

            val mCelsius = PropertyInfo()
            mCelsius.setName("Celsius")
            mCelsius.value = celsius
            soapObject.addProperty(mCelsius)

            envelope.dotNet = true

            envelope.setOutputSoapObject(soapObject)
            val httpTransportSE = HttpTransportSE(context.getString(R.string.URL),context.resources.getInteger(R.integer.TIMEOUT))
            try {
                httpTransportSE.call(context.getString(R.string.SOAP_ACTION),envelope)
                val response: SoapObject = envelope.response as SoapObject
                Log.e("response:",response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }
}