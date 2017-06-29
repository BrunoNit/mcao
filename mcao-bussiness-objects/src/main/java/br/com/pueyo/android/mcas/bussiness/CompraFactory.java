package br.com.pueyo.android.mcas.bussiness;

import br.com.pueyo.android.mcas.bussiness.bos.CompraVistaBO;

public class CompraFactory {

    public static CompraVistaBO getCompraVistaBO(){
        return new CompraVistaBO();
    }


}
