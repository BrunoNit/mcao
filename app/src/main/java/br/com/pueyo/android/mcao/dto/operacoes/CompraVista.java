package br.com.pueyo.android.mcao.dto.operacoes;

import java.util.Date;

import br.com.pueyo.android.mcao.dto.TipoOperacao;

/**
 * Created by 07669751770 on 20/06/17.
 */

public class CompraVista extends OperacaoDTO {

    private double taxas;
    private double valorBruto;
    private double valorUnitario;

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
            return getValor() * getTaxas();
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
        sb.append("Valor Unitário: ").append(": ").append(getValorUnitario());

        return sb.toString();
    }
}
