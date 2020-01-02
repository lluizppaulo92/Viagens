package viagens.lluizppaulo.com.br.viagens;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import viagens.lluizppaulo.com.br.viagens.Util.DataUtil;
import viagens.lluizppaulo.com.br.viagens.Util.MoedaUtil;
import viagens.lluizppaulo.com.br.viagens.Util.ResourceUtil;
import viagens.lluizppaulo.com.br.viagens.modelo.Pacote;

public class ResumoCompraActivity extends AppCompatActivity {

    private TextView mTxtDatas, mTxtCidade, mTxtValor;
    private ImageView mImgCidade;
    private Pacote p;
    private Button mBtnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle("Resumo da Compra");

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            p = (Pacote) intent.getSerializableExtra("pacote");
        }

        mImgCidade = findViewById(R.id.resumo_compra_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, p.getImagem());
        mImgCidade.setImageDrawable(drawable);

        mTxtDatas = findViewById(R.id.resumo_compra_datas);
        mTxtDatas.setText(DataUtil.periodoEmTexto(p.getDias()));

        mTxtValor = findViewById(R.id.resumo_compra_valor_compra);
        mTxtValor.setText(MoedaUtil.formataParaBrasileiro(p.getPreco()));

        mTxtCidade = findViewById(R.id.resumo_compra_cidade);
        mTxtCidade.setText(p.getLocal());

        mBtnFinalizar = findViewById(R.id.resumo_compra_btn_listagem);
        mBtnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResumoCompraActivity.this,ListaPacotesActivity.class));
            }
        });



    }
}
