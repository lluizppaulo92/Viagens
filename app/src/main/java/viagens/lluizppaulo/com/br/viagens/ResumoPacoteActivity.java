package viagens.lluizppaulo.com.br.viagens;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import viagens.lluizppaulo.com.br.viagens.Util.DiasUtil;
import viagens.lluizppaulo.com.br.viagens.Util.MoedaUtil;
import viagens.lluizppaulo.com.br.viagens.Util.ResourceUtil;
import viagens.lluizppaulo.com.br.viagens.modelo.Pacote;


public class ResumoPacoteActivity extends AppCompatActivity {


    private TextView mTxtValor, mTxtCidade, mTxtDias, mTxtDatas;
    private ImageView mImgLocal;
    private Button mBtnRealizaPagamento;
    private Context context;
    private Pacote p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo do Pacote");
        context = this;

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            p = (Pacote) intent.getSerializableExtra("pacote");
        }


        mTxtCidade = findViewById(R.id.resumo_pacote_cidade);
        mTxtCidade.setText(p.getLocal());

        mImgLocal = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, p.getImagem());
        mImgLocal.setImageDrawable(drawable);

        mTxtDias = findViewById(R.id.resumo_pacote_dias);
        mTxtDias.setText(DiasUtil.formataEmTexto(p.getDias()));

        mTxtValor = findViewById(R.id.resumo_pacote_preco);
        mTxtValor.setText(MoedaUtil.formataParaBrasileiro(p.getPreco()));

        mTxtDatas = findViewById(R.id.resumo_pacote_data);
        Calendar dtIda = Calendar.getInstance();

        Calendar dtVolta = Calendar.getInstance();
        dtVolta.add(Calendar.DATE,p.getDias());

        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = formatoBrasileiro.format(dtIda.getTime());
        String dataFormatadaVolta = formatoBrasileiro.format(dtVolta.getTime());
        String dataFormatadaDaViagem = dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dtVolta.get(Calendar.YEAR);
        mTxtDatas.setText(dataFormatadaDaViagem);

        mBtnRealizaPagamento = findViewById(R.id.resumo_pacote_btn_realizar_pagamento);
        mBtnRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PagamentoActivity.class);
                intent.putExtra("pacote",p);
                startActivity(intent);

            }
        });


    }
}
