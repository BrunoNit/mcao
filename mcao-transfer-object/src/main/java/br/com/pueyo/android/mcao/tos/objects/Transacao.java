package br.com.pueyo.android.mcao.tos.objects;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import br.com.pueyo.android.mcao.tos.objects.enumeracoes.TipoTransacao;

/**
 * Created by 07669751770 on 21/06/17.
 */

public abstract class Transacao {

    private Date dataTransacao;
    private Titulo titulo;
    private BigDecimal valorUnitario;
    private BigDecimal valorLiquido;
    private BigDecimal valorBruto;
    private BigDecimal ir;
    private BigInteger quantidade;

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(BigDecimal valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getIr() {
        return ir;
    }

    public void setIr(BigDecimal ir) {
        this.ir = ir;
    }

    public BigInteger getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigInteger quantidade) {
        this.quantidade = quantidade;
    }

    public abstract TipoTransacao getTipoTransacao();




}
