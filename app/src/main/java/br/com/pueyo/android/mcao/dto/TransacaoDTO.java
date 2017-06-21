package br.com.pueyo.android.mcao.dto;

import android.content.Intent;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import br.com.pueyo.android.mcao.tos.McaoObjects;


/**
 * Created by 07669751770 on 19/06/17.
 */

public class TransacaoDTO extends DTO{



    private Date data;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private String codigo;
    private TipoOperacao tipo;
    private Integer quantidade;
    private double valor;
    private double precoMedio;

    public TransacaoDTO(Date data, TipoOperacao tipo, Integer quantidade, double valor, double precoMedio) {
        this.data = data;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.precoMedio = precoMedio;
    }

    public TransacaoDTO() {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(double precoMedio) {
        this.precoMedio = precoMedio;
    }


    public String getDataFormatada(String s) {

        DateFormat sdf = new SimpleDateFormat(s);

        return sdf.format(this.getData());
    }

    public String getPrecoMedioFormatado(){
        return converteCurrencyInString(this.precoMedio);
    }
    public String getValorFormatado(){
        return converteCurrencyInString(this.valor);
    }

    private String converteCurrencyInString(double valor){
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        numberFormatter.setCurrency(Currency.getInstance(Locale.getDefault()));
        return numberFormatter.format(valor);
    }
}
