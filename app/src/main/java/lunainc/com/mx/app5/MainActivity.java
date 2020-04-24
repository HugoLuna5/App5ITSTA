package lunainc.com.mx.app5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private EditText mCampo;
    private ListView mLista;

    private ArrayAdapter<String> adapter;

    String colores[] = {"Amarillo", "Azul", "Verde", "Rosado", "Negro", "Marron", "Rojo", "Blanco"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampo = (EditText) findViewById(R.id.campo);
        mLista = (ListView) findViewById(R.id.lista);



        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colores);
        mLista.setAdapter(adapter);


        mCampo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
