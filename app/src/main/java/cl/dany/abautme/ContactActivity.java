package cl.dany.abautme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

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
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone.getText().toString()));
                startActivity(callIntent);
            }
        });

        //comem
    }
}
