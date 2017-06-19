package br.com.pueyo.android.mcao.builder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pueyo.android.mcao.dto.CardCarteiraAcaoDTO;
import br.com.pueyo.android.mcao.dto.DTO;
import br.com.pueyo.android.mcao.dto.TipoOperacao;
import br.com.pueyo.android.mcao.dto.TransacaoDTO;

/**
 * Created by 07669751770 on 19/06/17.
 */

public class TransacaoBuilder<T extends DTO> extends Builder<T>{

    List<T> transacoes = new ArrayList<T>();


    public TransacaoBuilder getInstance(){
        return new TransacaoBuilder();
    }

    public TransacaoBuilder<T> addTransacao(Date data, String codigo, TipoOperacao tipo, Integer quantidade, double valor, double precoMedio){
        TransacaoDTO transacao = new TransacaoDTO();

        transacao.setData(data);
        transacao.setCodigo(codigo);
        transacao.setTipo(tipo);
        transacao.setQuantidade(quantidade);
        transacao.setValor(valor);
        transacao.setPrecoMedio(quantidade /valor);

        transacoes.add((T) transacao);

        return this;
    }

    public T[] build(){
        DTO[] c = new TransacaoDTO[transacoes.size()];
        int i = 0;
        for(DTO card: transacoes){
            c[i] = card;
            i++;
        }
        return (T[]) c;
    }

}
