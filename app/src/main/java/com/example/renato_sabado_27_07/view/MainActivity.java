package com.example.renato_sabado_27_07.view;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.renato_sabado_27_07.R;
import com.example.renato_sabado_27_07.banco.BancoManager;
import com.example.renato_sabado_27_07.controle.Controle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BancoManager dm;
    private Controle controle;

    private Button buttonInserirAlunos, buttonListarAlunos, buttonListarDisciplina, buttonInserirDisciplina;
    private TextView textViewResultadoAlunos, textViewResultadoDisciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonInserirAlunos = findViewById(R.id.buttonInserirAlunos);
        buttonListarAlunos = findViewById(R.id.buttonListarAlunos);
        buttonListarDisciplina = findViewById(R.id.buttonListarDisciplina);
        buttonInserirDisciplina = findViewById(R.id.buttonInserirDisciplina);
        textViewResultadoAlunos = findViewById(R.id.textViewResultadoAlunos);
        textViewResultadoDisciplina = findViewById(R.id.textViewResultadoDisciplina);

        dm = new BancoManager(this);
        SQLiteDatabase db = dm.open();
        controle = new Controle(db);
    }//onCreate

    public void clicar(View view) {
        if (view.getId() == R.id.buttonInserirAlunos) {
            adicionarAlunos();
        }
        if (view.getId() == R.id.buttonListarAlunos) {
            listarAlunos();
        }
        if (view.getId() == R.id.buttonInserirDisciplina) {
            adicionarDisciplina();
        }
        if (view.getId() == R.id.buttonListarDisciplina) {
            consultarDisciplinasPorAluno();
        }

    }//clicar

    private void consultarDisciplinasPorAluno() {
        String retorno = controle.consultarDisciplinasPorAluno();
        textViewResultadoDisciplina.setText(retorno);
    }

    private void adicionarDisciplina() {
        List<Long> retorno = controle.adicionarDisciplina();
        Toast.makeText(MainActivity.this, retorno.toString(), Toast.LENGTH_SHORT).show();

    }

    private void listarAlunos() {
        String retorno = controle.consultarAlunos();
        textViewResultadoAlunos.setText(retorno);
    }

    private void adicionarAlunos() {
        List<Long> retorno = controle.adicionarAluno();
        Toast.makeText(MainActivity.this, retorno.toString(), Toast.LENGTH_SHORT).show();
    }


}//MainActivity