package br.com.pueyo.android.mcao.tos.objects.enumeracoes;

import br.com.pueyo.android.mcao.tos.objects.enumeracoes.OperacaoCarteira;

/**
 * Created by 07669751770 on 22/06/17.
 */

public enum  TipoTransacao {

    COMPRA("C", OperacaoCarteira.SUBTRACAO),
    VENDA("V", OperacaoCarteira.SOMA),
    DIVIDENDO("D", OperacaoCarteira.SOMA),
    JSCP("J", OperacaoCarteira.SOMA),
    AGRUPAMENTO("G", OperacaoCarteira.NADA),
    DESMEMBRAMENTO("D", OperacaoCarteira.NADA);

    private String cod;
    private OperacaoCarteira operacao;

    private TipoTransacao(String cod, OperacaoCarteira operacao){
        this.cod = cod;
        this.operacao = operacao;
    }


    @Override
    public String toString() {
        return this.cod;
    }

    public String getCod() {
        return cod;
    }

    public OperacaoCarteira getOperacao() {
        return operacao;
    }
}
