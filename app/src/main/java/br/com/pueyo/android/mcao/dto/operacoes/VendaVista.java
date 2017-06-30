package br.com.pueyo.android.mcao.dto.operacoes;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.pueyo.android.mcao.R;
import br.com.pueyo.android.mcao.dto.TipoOperacao;

/**
 * Created by 07669751770 on 30/06/17.
 */

public class VendaVista  extends OperacaoVista {





    @Override
    public OperacaoDTO gerarOperacaoFromView(View v) {
        TextView edtCodigo = (TextView) v.findViewById(R.id.cmp_codigo_value);
        EditText edtData = (EditText) v.findViewById(R.id.cmp_data_value);
        EditText edtQuantidade = (EditText) v.findViewById(R.id.cmp_qtde_value);
        EditText edtCotacao = (EditText) v.findViewById(R.id.cmp_cotacao_value);
        EditText edtTaxas = (EditText) v.findViewById(R.id.cmp_valor_taxas_value);

        this.setCodigo(edtCodigo.getText().toString());
        this.setData(converteData(edtData.getText().toString()));
        this.setQuantidade(converterQuantidade(edtQuantidade.getText().toString()));
        this.setCotacao(converteDouble(edtCotacao.getText().toString()));
        this.setTaxas(converteDouble(edtTaxas.getText().toString()));
        this.setValor(getQuantidade() * getCotacao());
        this.setTipo(TipoOperacao.VENDA);
        this.setValorUnitario(getCotacao());

        return this;
    }


    @Override
    public double getValorBruto() {

        double valorUnitario = this.getValorUnitario();
        Integer quantidade = this.getQuantidade();

        double valorLiquido = valorUnitario * quantidade;

        return valorLiquido - this.getTaxas();

    }
}
