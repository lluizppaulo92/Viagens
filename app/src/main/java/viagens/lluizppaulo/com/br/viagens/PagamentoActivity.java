package viagens.lluizppaulo.com.br.viagens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import viagens.lluizppaulo.com.br.viagens.Util.MoedaUtil;
import viagens.lluizppaulo.com.br.viagens.modelo.Pacote;

public class PagamentoActivity extends AppCompatActivity {

    private Button mBtnFinalizarCompra;
    private TextView mTxtValorPagamento;
    private Pacote p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle("Pagamento");
        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            p = (Pacote) intent.getSerializableExtra("pacote");
        }

        mTxtValorPagamento = findViewById(R.id.pagamento_valor_compra);
        mTxtValorPagamento.setText(MoedaUtil.formataParaBrasileiro(p.getPreco()));

        mBtnFinalizarCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        mBtnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent1.putExtra("pacote",p);
                startActivity(intent1);
            }
        });

    }
}
