package com.example.hellosoap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";

	private static final String METHOD_NAME = "Connecter";

	private static final String NAMESPACE = "http://tempuri.org/";

	//private static final String URL = "http://localhost:5645/ServiceAuthentification.svc";
	//private static final String URL = "http://10.0.2.2:5645/ServiceAuthentification.svc";
	private static final String URL = "http://132.227.69.4:5645/ServiceAuthentification.svc";
	
	final String SOAP_ACTION = "http://tempuri.org/IServiceAuthentification/Connecter";

	TextView tv;
	StringBuilder sb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		tv = new TextView(this);
        sb = new StringBuilder();
        Toast.makeText(this.getApplicationContext(),"Hello ! XDDDDDDDDDDDD",500).show();
        call();
        tv.setText(sb.toString());
        setContentView(tv);
	}

	
	public void call() {
        try {

            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            request.addProperty("identifiant", "toto");
            request.addProperty("motDePasse", "toto");

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
 
            
            
            
            
            
            
            
            
            androidHttpTransport.call(SOAP_ACTION, envelope);
            
            
            
            
            
            
            
            
            
            
            
            SoapPrimitive result = (SoapPrimitive)envelope.getResponse();

            //to get the data
            String resultData = result.toString();
            // 0 is the first object of data


            sb.append(resultData + "\n"); 
        } catch (Exception e) {
            sb.append("Error:\n" + e.getClass().getName() + "\n" + e.getMessage() + "\n");
        }

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
