package br.edu.ifsul.bruno.calculoareapoligonos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CalculoArea extends AppCompatActivity {

    private Double baseMenor;
    private Double baseMaior;
    private Double altura;
    private Double area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculo_area);

        Intent intent = getIntent();
        baseMenor = Double.parseDouble( intent.getStringExtra("baseMenor") );
        baseMaior = Double.parseDouble( intent.getStringExtra("baseMaior") );
        altura = Double.parseDouble( intent.getStringExtra("altura") );
    }

    public void retornarValorCalculado(View view) {

        area = (baseMaior + baseMenor) * .5 * altura;

        Intent intent = new Intent();
        intent.putExtra("area", area.toString());
        setResult(RESULT_OK, intent);
        finish();
    }


    public void retornarCancel(View view) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

}
