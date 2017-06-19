package br.com.pueyo.android.mcao.dto;

/**
 * Created by 07669751770 on 19/06/17.
 */

public enum TipoOperacao {

    COMPRA("C"),
    VENDA("V"),
    DIVIDENDO("D"),
    JSCP("J"),
    AGRUPAMENTO("G"),
    DESMEMBRAMENTO("D");

    private String cod;

    private TipoOperacao(String cod){
        this.cod = cod;
    }


    @Override
    public String toString() {
        return this.cod;
    }
}
