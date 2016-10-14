package id.sch.smktelkom_mlg.learn.ojek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etLokasi;
    TextView tvhasil;
    Button bOk;
    RadioGroup rgStatus;
    //RadioButton motor, mobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        motor = (RadioButton) findViewById(R.id.radioButtonBM);
        mobil = (RadioButton) findViewById(R.id.radioButtonM);*/
        rgStatus = (RadioGroup) findViewById(R.id.RadioGroupStatus);

        etNama = (EditText) findViewById(R.id.editText);
        etLokasi = (EditText) findViewById(R.id.editText2);
        bOk = (Button) findViewById(R.id.buttonOK);


        bOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               hasil();

            }
        });
        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                if(i == R.id.radioButton3)
                {
                    findViewById(R.id.tilOY).setVisibility(View.GONE);
                }
                else
                {
                    findViewById(R.id.tilOY).setVisibility(View.VISIBLE);
                }
            }
        });
        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doClick();
            }

            private void doClick() {
                String hasil = null;
                if(rgStatus.getCheckedRadioButtonId()!=-1)
                {
                    RadioButton rb = (RadioButton)
                            findViewById(rgStatus.getCheckedRadioButtonId());
                    hasil = rb.getText().toString();
                    if(rgStatus.getCheckedRadioButtonId()!=R.id.radioButton3)
                    {
                        EditText etJA = (EditText) findViewById(R.id.editTextJA);
                        hasil += "\nJumlah Anak : " + etJA.getText();
                    }
                }
                /*
                if(rbBM.isChecked())
                {
                    hasil = rbBM.getText().toString();
                }
                else if(rbM.isChecked())
                {
                    hasil = rbM.getText().toString();
                }
                else if (rbD.isChecked())
                {
                    hasil = rbD.getText().toString();
                }
                else if (rbJ.isChecked())
                {
                    hasil = rbJ.getText().toString();
                }
                */
                if (hasil == null)
                {
                    tvhasil.setText("Belum Memilih Status");
                }
                else
                {
                    tvhasil.setText("Status Anda : " + hasil);
                }
            }
        });

    }

    private void hasil() {
        String lokasi = etLokasi.getText().toString();
        tvhasil.setText(lokasi);
    }

}

