package com.example.projetoquiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txvPergunta;
    RadioGroup rdgPrincipal;
    Button btnResponder;
    int prontuacao = 0;
    int indicePergunta = 0;

    String[] perguntas = {
            "Minha pergunta 1",
            "Minha pergunta 2",
            "Minha pergunta 3",
            "Minha pergunta 4",
            "Minha pergunta 5"
    };

    int[] respoastasCorretas = {
            R.id.rbA,
            R.id.rbB,
            R.id.rbC,
            R.id.rbD
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txvPergunta = findViewById(R.id.txvPergunta);
        rdgPrincipal = findViewById(R.id.rdgPrincipal);
        btnResponder = findViewById(R.id.btnResponder);

        carregarPerguntas();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarPerguntas() {
        if (indicePergunta < perguntas.length) {
            txvPergunta.setText(perguntas[indicePergunta]);
            rdgPrincipal.clearCheck();
            btnResponder.setEnabled(true);
        } else {
            txvPergunta.setText("Fim");
            btnResponder.setEnabled(false);
        }

    }
}