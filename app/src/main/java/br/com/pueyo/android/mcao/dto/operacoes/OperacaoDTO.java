package br.com.pueyo.android.mcao.dto.operacoes;

import android.util.Log;
import android.view.View;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.pueyo.android.mcao.dto.TipoOperacao;

/**
 * Created by 07669751770 on 20/06/17.
 */

public abstract class OperacaoDTO {
    private static final String TAG = OperacaoDTO.class.getName();
    private Date data;
    private String codigo;
    private TipoOperacao tipo;
    private Integer quantidade;
    private double valor;

    public OperacaoDTO(String codigo, Date data, TipoOperacao tipo, Integer quantidade, double valor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data = data;
    }

    public OperacaoDTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    protected double converteDouble(String s) {
        return Double.valueOf(s);
    }

    protected Integer converterQuantidade(String s) {
        return Integer.valueOf(s);
    }

    protected Date converteData(String data){
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(data);
        } catch (ParseException e) {
            Log.e(TAG, "Erro ao fazer o parser da data", e);
        }
        return null;
    }


    public abstract OperacaoDTO gerarOperacaoFromView(View view);
}
