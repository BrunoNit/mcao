package br.com.pueyo.android.mcao;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import br.com.pueyo.android.mcao.adapters.TransacaoAdapter;
import br.com.pueyo.android.mcao.builder.TransacaoBuilder;
import br.com.pueyo.android.mcao.decorators.DividerItemDecoration;
import br.com.pueyo.android.mcao.dto.TipoOperacao;
import br.com.pueyo.android.mcao.dto.TransacaoDTO;
import br.com.pueyo.android.mcao.dto.operacoes.CompraVista;
import br.com.pueyo.android.mcao.fragments.operacoes.OperacaoCompra;
import br.com.pueyo.android.mcao.listeners.DialogoNotificavel;

/**
 * Created by 07669751770 on 19/06/17.
 */

public class DetalhesAcaoActivity  extends AppCompatActivity implements DialogoNotificavel{

    private final String TAG = DetalhesAcaoActivity.class.getName();

    private RecyclerView transacoesRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TransacaoAdapter transacoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_acao);

        Bundle extras = getIntent().getExtras();


        String cod = null;
        if(extras != null){
            cod = extras.getString(getResources().getString(R.string.param_cod_acao));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.act_detalhes_acao_toolbar);
        setSupportActionBar(toolbar);

        setTitle(cod);

        transacoesRecyclerView = (RecyclerView) findViewById(R.id.act_detalhes_acao_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);

        transacoesRecyclerView.setLayoutManager(mLayoutManager);


        TransacaoDTO[] dataSet = buscarTransacoes(cod);
        transacoAdapter = new TransacaoAdapter(dataSet);
        transacoesRecyclerView.setAdapter(transacoAdapter);

        Drawable d = ContextCompat.getDrawable(this,R.drawable.line_divider);

        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(d);
        transacoesRecyclerView.addItemDecoration(decoration);
    }

    private TransacaoDTO[] buscarTransacoes(String cod) {


        Date dataHoje = new Date();
        TransacaoBuilder<TransacaoDTO> builder = new TransacaoBuilder<TransacaoDTO>();
        for(int i = 0; i < 37; i++){
                builder = builder.addTransacao(dataHoje,cod, TipoOperacao.COMPRA,100 * i, 130.0 * i,0.0);
        }
        return builder.build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhes_acoes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.operacao_compra) {
            Log.w(TAG,"COMPRA");
            OperacaoCompra operacaoCompra = new OperacaoCompra();
            operacaoCompra.show(getSupportFragmentManager(),TAG);
            return true;
        }

        if (id == R.id.operacao_venda) {
            Log.w(TAG,"VENDA");
            return true;
        }

        if (id == R.id.operacao_dividendo) {
            Log.w(TAG,"DIVIDENDO");
            return true;
        }

        if (id == R.id.operacao_jscp) {
            Log.w(TAG,"JURO CAPITAL");
            return true;
        }

        if (id == R.id.operacao_agrupamento) {
            Log.w(TAG,"AGRUPAMENTO");
            return true;
        }

        if (id == R.id.operacao_desdobramento) {
            Log.w(TAG,"DESDOBRAMENTO");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        View v = dialog.getView();
        EditText edtCodigo = (EditText) v.findViewById(R.id.cmp_codigo_value);
        EditText edtData = (EditText) v.findViewById(R.id.cmp_data_value);
        EditText edtQuantidade = (EditText) v.findViewById(R.id.cmp_qtde_value);
        EditText edtValorLiquido = (EditText) v.findViewById(R.id.cmp_valor_liquido_value);
        EditText edtTaxas = (EditText) v.findViewById(R.id.cmp_valor_taxas_value);

        Log.w(TAG, "###### CODIGO: " + edtCodigo.getText().toString());






    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
