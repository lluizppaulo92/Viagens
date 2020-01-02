package viagens.lluizppaulo.com.br.viagens;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import viagens.lluizppaulo.com.br.viagens.adapter.ListaPacotesAdapter;
import viagens.lluizppaulo.com.br.viagens.dao.PacoteDAO;
import viagens.lluizppaulo.com.br.viagens.modelo.Pacote;

public class ListaPacotesActivity extends AppCompatActivity {

    private Context context;
    List<Pacote> lPacotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        context = this;
        final ListView listaPacotes = findViewById(R.id.lista_pacote_lista);
        lPacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter( new ListaPacotesAdapter(lPacotes, this));
        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Intent acResumoPacote = new Intent(context, ResumoPacoteActivity.class);
                acResumoPacote.putExtra("pacote",lPacotes.get(posicao));
                startActivity(acResumoPacote);
            }
        });


    }
}
