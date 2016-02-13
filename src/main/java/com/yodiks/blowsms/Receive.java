package com.yodiks.blowsms;

import android.content.BroadcastReceiver;

import android.content.Context;

import android.content.Intent;

import android.os.Bundle;

//import android.telephony.gsm.SmsMessage;

import android.telephony.SmsMessage;
import android.widget.Toast;



public class Receive extends BroadcastReceiver

{

    @Override

    public void onReceive(Context context, Intent intent)

    {

        Bundle bundle = intent.getExtras();       

        SmsMessage[] msgs = null;

        String str = "";           
        if (bundle != null)

        {

            Object[] pdus = (Object[]) bundle.get("pdus");

            msgs = new SmsMessage[pdus.length];  
            String strMsg="";

            for (int i=0; i<msgs.length; i++){

                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);               

                str += "SMS from " + msgs[i].getOriginatingAddress();                   
                str += " :";

                str += msgs[i].getMessageBody().toString();

                str += "\n";       
                strMsg=msgs[i].getMessageBody().toString();

            }
            	Toast.makeText(context, "SMS entry:"+strMsg, Toast.LENGTH_LONG).show();
          
        }                       

    }
    /* Yogi Dika Saputra
     * 4812010024 
     * IT3Aeu
     */

}