package br.com.fiap.mobintroducaoandroid_aula3_app1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ActivityPrincipal extends AppCompatActivity implements View.OnClickListener {

    private Button btnSoma = null;
    private Button btnSub = null;
    private Button btnMult = null;
    private Button btnDiv = null;

    private TextView txtResultado = null;
    private EditText txtOp1 = null;
    private EditText txtOp2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSub = (Button) findViewById(R.id.btnSubtracao);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtOp1 = (EditText) findViewById(R.id.txtOp1);
        txtOp2 = (EditText) findViewById(R.id.txtOp2);

        btnSoma.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        double op1 = Double.valueOf(txtOp1.getText().toString());
        double op2 = Double.valueOf(txtOp2.getText().toString());

        //Para ter duas casas após a vírgula
        //O separador decimal acompanha os settings de Idioma
        DecimalFormat df = new DecimalFormat("0.##");


        if (v == btnSoma){
            txtResultado.setText(df.format(op1+op2));
        }
        if (v == btnSub){
            txtResultado.setText(df.format(op1 - op2));
        }
        if (v == btnDiv){
            txtResultado.setText(df.format(op1 / op2));
        }
        if (v == btnMult){
            txtResultado.setText(df.format(op1*op2));
        }
    }

}
