package cl.dany.abautme;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment {


    public EmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        final Button contact = (Button) view.findViewById(R.id.escribemeBtn);
        final EditText userInput = (EditText) view.findViewById(R.id.editText1);
        final Button send = (Button) view.findViewById(R.id.enviarBtn);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact.setVisibility(View.GONE);
                userInput.setVisibility(View.VISIBLE);
                send.setVisibility(View.VISIBLE);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("*/*");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]
                        {"davergarap@uc.cl"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto App Móvil");
                intent.putExtra(Intent.EXTRA_TEXT, userInput.getText().toString());
                startActivity(intent);
            }
        });

    }
}
