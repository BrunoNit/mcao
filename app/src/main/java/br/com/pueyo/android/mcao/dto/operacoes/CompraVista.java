package br.com.pueyo.android.mcao.dto.operacoes;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.pueyo.android.mcao.R;
import br.com.pueyo.android.mcao.dto.TipoOperacao;



/**
 * Created by 07669751770 on 20/06/17.
 */

public class CompraVista extends OperacaoDTO {

    private static final String TAG = CompraVista.class.getName() ;
    private double taxas;
    private double valorBruto;
    private double valorUnitario;
    private double cotacao;

    public CompraVista(String codigo, Date data, TipoOperacao tipo, Integer quantidade, double valor) {
        super(codigo,data, tipo, quantidade, valor);

    }

    public CompraVista() {


    }


    public double getTaxas() {
        return taxas;
    }

    public void setTaxas(double taxas) {
        this.taxas = taxas;
    }

    public double getValorBruto() {
        if(valorBruto == 0.0){
            return getValor() + getTaxas();
        }
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(": ").append(getCodigo()).append(" | ");
        sb.append("Data:").append(": ").append(getData()).append(" | ");
        sb.append("Tipo: ").append(": ").append(getTipo().name()).append(" | ");
        sb.append("Quantidade: ").append(": ").append(getQuantidade()).append(" | ");
        sb.append("Valor Liquido: ").append(": ").append(getValor()).append(" | ");
        sb.append("Taxas: ").append(": ").append(getTaxas()).append(" | ");
        sb.append("Valor Bruto: ").append(": ").append(getValorBruto()).append(" | ");
        sb.append("Valor Unitário: ").append(": ").append(getValorUnitario()).append(" | ");
        sb.append("Cotação: ").append(": ").append(getCotacao());

        return sb.toString();
    }

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
        this.setTipo(TipoOperacao.COMPRA);
        this.setValorUnitario(getCotacao());

        return this;
    }
}
