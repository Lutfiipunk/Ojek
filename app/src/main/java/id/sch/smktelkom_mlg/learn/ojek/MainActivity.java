package id.sch.smktelkom_mlg.learn.ojek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import id.sch.smktelkom_mlg.learn.ojek.R;

public abstract class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox CbJauh, CbDekat;
    TextView tvHasil;
    EditText etNama;
    EditText etLok;
    Button bOk;
    RadioGroup rgStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editText);
        etLok = (EditText) findViewById(R.id.editText2);
        bOk = (Button) findViewById(R.id.button);
        CbJauh = (CheckBox) findViewById(R.id.checkBox);
        CbDekat = (CheckBox) findViewById(R.id.checkBox2);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroup2);

        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        tvHasil = (TextView) findViewById(R.id.textView2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

        CbJauh.setOnCheckedChangeListener(this);
        CbDekat.setOnCheckedChangeListener(this);
    }

    private void doClick() {
        String hasil = "Jarak Anda:\n";
        int startlen = hasil.length();
        if (CbJauh.isChecked()) hasil += CbJauh.getText() + "\n";
        if (CbDekat.isChecked()) hasil += CbDekat.getText() + "\n";

        if(hasil.length()==startlen) hasil+="Tidak ada pilihan";
        tvHasil.setText(hasil);

    }
}
