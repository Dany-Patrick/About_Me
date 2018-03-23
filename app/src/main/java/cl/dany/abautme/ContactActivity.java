package cl.dany.abautme;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    final static int CALL= 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        final TextView linkedin = (TextView) findViewById(R.id.linkedin);
        final TextView phone = (TextView) findViewById(R.id.telefono);

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkedinIntent = new Intent(Intent.ACTION_VIEW);
                linkedinIntent.setData(Uri.parse("https://www.linkedin.com/in/daniel-pérez-426288139"));
                startActivity(linkedinIntent);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    String [] permiso = {Manifest.permission.ACCOUNT_MANAGER };
                    requestPermissions(permiso, CALL);
                    return;
                }
                else{

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone.getText().toString()));
                    startActivity(callIntent);
                }

            }
        });

        //comemm
    }
}
