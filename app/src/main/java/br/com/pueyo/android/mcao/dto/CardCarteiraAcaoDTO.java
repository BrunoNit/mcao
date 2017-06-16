package br.com.pueyo.android.mcao.dto;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by 07669751770 on 16/06/17.
 */

public class CardCarteiraAcaoDTO {

    private String codigoAcao;
    private double custoTotal;
    private double custoUnitario;
    private String quantidade;


    
    
    
    public String getCodigoAcao() {
        return codigoAcao;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCustoTotalAsStringCurrency(){
        return converteCurrencyInString(getCustoTotal());
    }
    public String getCustoUnitarioAsStringCurrency(){
        return converteCurrencyInString(getCustoUnitario());
    }

    private String converteCurrencyInString(double valor){
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        numberFormatter.setCurrency(Currency.getInstance(Locale.getDefault()));
        return numberFormatter.format(valor);
    }
}
