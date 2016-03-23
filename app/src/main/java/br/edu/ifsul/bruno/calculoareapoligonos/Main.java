package br.edu.ifsul.bruno.calculoareapoligonos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private EditText inputBaseMenor;
    private EditText inputBaseMaior;
    private EditText inputAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        // na construção associa aos edit texts
        inputBaseMenor = (EditText) findViewById(R.id.inputBaseMenor);
        inputBaseMaior = (EditText) findViewById(R.id.inputBaseMaior);
        inputAltura = (EditText) findViewById(R.id.inputAltura);

    }

    public void atividadeCalculoTrapezio(View view) {

        if (validarCampos()) {

            Intent intent = new Intent(this, CalculoArea.class);

            intent.putExtra("baseMenor", inputBaseMenor.getText().toString());
            intent.putExtra("baseMaior", inputBaseMaior.getText().toString());
            intent.putExtra("altura", inputAltura.getText().toString());

            Integer requestCode = 235;
            startActivityForResult(intent, requestCode);

        }
        else {
            Toast.makeText(Main.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validarCampos() {

        if ( inputBaseMenor.getText().toString().equals("") ) {
            return false;
        }
        if ( inputBaseMaior.getText().toString().equals("") ) {
            return false;
        }
        if ( inputAltura.getText().toString().equals("") ) {
            return false;
        }
        return true;

    }

    // pegar a resposta e fazer alguma coisa
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 235) {
            if (resultCode == RESULT_OK) {
                String area = data.getStringExtra("area");
                Toast.makeText(Main.this, "A área do Trapézio é: " + area + " m²", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Main.this, "Você cancelou a ação!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void limparCampos(View view) {

        inputBaseMenor.setText("");
        inputBaseMaior.setText("");
        inputAltura.setText("");

    }
}
