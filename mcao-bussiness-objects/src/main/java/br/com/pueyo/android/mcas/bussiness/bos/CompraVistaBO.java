package br.com.pueyo.android.mcas.bussiness.bos;

import java.util.logging.Logger;

import br.com.pueyo.android.mcao.tos.objects.CompraVista;

/**
 * Created by 07669751770 on 22/06/17.
 */

public class CompraVistaBO {


        Logger log = Logger.getGlobal();

    public void enviarCompraVista(CompraVista compraVista){
        log.warning("############################ REALIZANDO A COMPRA ["+ compraVista.getTitulo().getCodigoBovespa() + "]####################");
    }
}
