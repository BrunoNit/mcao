package br.com.pueyo.android.mcao.tos.objects;

import java.math.BigDecimal;

import br.com.pueyo.android.mcao.tos.objects.enumeracoes.TipoTransacao;

/**
 * Created by 07669751770 on 22/06/17.
 */

public class CompraVista extends Transacao {

    private BigDecimal taxas;


    public BigDecimal getTaxas() {
        return taxas;
    }

    public void setTaxas(BigDecimal taxas) {
        this.taxas = taxas;
    }

    @Override
    public TipoTransacao getTipoTransacao() {
        return TipoTransacao.COMPRA;
    }
}
