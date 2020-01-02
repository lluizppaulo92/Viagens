package viagens.lluizppaulo.com.br.viagens.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import viagens.lluizppaulo.com.br.viagens.R;
import viagens.lluizppaulo.com.br.viagens.modelo.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {


    private List<Pacote> listaPacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> listaPacotes, Context context) {
        this.listaPacotes = listaPacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaPacotes.size();
    }

    @Override
    public Pacote getItem(int i) {
        return listaPacotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Pacote p = listaPacotes.get(i);

        View v =LayoutInflater.from(context).inflate(R.layout.item_pacote, viewGroup, false);

        ImageView imagem = v.findViewById(R.id.item_pacote_img);
        Resources resources = context.getResources();
        int idDrawable =  resources.getIdentifier(p.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagem = resources.getDrawable(idDrawable);
        imagem.setImageDrawable(drawableImagem);


        TextView local = v.findViewById(R.id.item_pacote_nome_cidade);
        local.setText(p.getLocal().toString());
        TextView dias = v.findViewById(R.id.item_pacote_dias);
        dias.setText(p.getDias() > 1 ? p.getDias()+ " Dias" : p.getDias() + " Dia");
        TextView valor  = v.findViewById(R.id.item_pacote_valor);
        NumberFormat formatoMoedaBR = DecimalFormat.getCurrencyInstance(new Locale("pt","br"));
        //valor.setText("R$ "+String.format ("%,.2f", p.getPreco()));
        valor.setText(formatoMoedaBR.format(p.getPreco()).replace("R$","R$ "));

        return v;
    }
}
