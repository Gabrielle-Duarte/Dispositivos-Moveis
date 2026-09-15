package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] nomes = new String[]{"Helena", "Livia", "Gabi 2026", "Pedro", "Romulo 2006", "Gabriel"};
    ListView lv;

    @SuppressLint("MissingInflatedId")
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

        lv = findViewById(R.id.listview);

        ArrayAdapter<String>  adapter = new ArrayAdapter<>(this,  //Adaptador de String - Classe: ArrayAdapter (Maiusculo)
                //android.R.layout.simple_list_item_1, //Xml
                //android.R.id.text1, //TextView
                R.layout.item_lista,
                R.id.tvnome,
                nomes //Array de nomes
        );
        lv.setAdapter(adapter);
    }
}

//linha 32 - quando a aplicaçao foi carregada, na linha 28, tem um componente de listagem -listview
//setcontentview o componente foi processado
//activity vai ter vinculado o constrantLayout e o ListView
//Em algum ponto na memoria Ram foi criado isso
//Na linha 32 cria uma variavel "lv" -> fala pro proprio sistema >>Skia - verifica qual delas tem o listView
//ListView>>>>lv aponta para ListView, agora ele ta pronto para exibir, mas nao tem dados.
// Nome 1 2 3 4 --- array de nomes
//Adapter é o cara que o listView chama para poder chamar o metodo "getView()" que retorna uma view --linha 34
//this - contexto ----- para nosso app conseguir conversa com a api, é passado uma variavel chamada context que tem biblioteca chamada skia
//O adaptador desenha os elementos na tela e tem que passar o xml
//Adapter (context, getView(this, xml(R), textView, nomes)