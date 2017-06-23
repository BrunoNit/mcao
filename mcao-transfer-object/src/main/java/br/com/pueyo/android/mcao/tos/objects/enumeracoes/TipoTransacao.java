package br.com.pueyo.android.mcao.tos.objects;

import br.com.pueyo.android.mcao.tos.objects.enumeracoes.OperacaoCarteira;

/**
 * Created by 07669751770 on 22/06/17.
 */

public enum  TipoTransacao {

    COMPRA("C", OperacaoCarteira.SUBTRACAO),
    VENDA("V"),
    DIVIDENDO("D"),
    JSCP("J"),
    AGRUPAMENTO("G"),
    DESMEMBRAMENTO("D");

    private String cod;

    private TipoTransacao(String cod){

        this.cod = cod;
    }


    @Override
    public String toString() {
        return this.cod;
    }
}
