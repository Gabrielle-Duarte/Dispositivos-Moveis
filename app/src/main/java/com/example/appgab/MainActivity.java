package com.example.appgab;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Contador de cliques - Uma aplicação que registra a quantidade de cliques do usuário.
public class MainActivity extends AppCompatActivity {
    TextView textView;
    int contador=0;
    @Override
    //É um classe de texto; View é um quadrado para você;
    // TextView é para dar designer ao texto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this); //Utilizar de Borda a Borda;
        setContentView(R.layout.activity_main);
        Button b=findViewById(R.id.button); //Classe para fazer referência; b = guardado na memoria ram;
        textView tv = findViewById(R.id.tv);//R arquivo automatico para armazenar referencias. Sem precisar de caminho especifico

        tv.setText(Integer.toString(contador)); //Ele aceita um elemento da classe R e não um inteiro;
        //Definir um evento para o botão; Ctrl+Q mostra sobre o método;
        b.setOnClickListener(v ->{ //Uma função que recebe uma visão e implementa no codigo

        textView=findViewById(R.id.tv);
        textView.setText(contador);
        textView.setOnClickListener(v->{
            textView.setText("Bla");
        });
    }
}
//textSize: tamanho da fonte; textColor: cor da fonta;
//finViewById() localiza o objeto pelo ID e guarda
//Git switch nomeBranch --> muda de branch
//muriloms2006-sketch >> Aula romulo
//Quando da erro, ir no Logcat
//seleciona o componente, vai em atributos e vai em procurar, hint e escreve o nome
//hint, digitar o nome minimo e maximo para poder aparecer para o usuario
//git add .
// git commit -m "Sorteio em um intervalo definido pelo usuario"
//git push origin contador sorteio (Sobe as duas branch) ou git push origin --all (sobe tudo)
