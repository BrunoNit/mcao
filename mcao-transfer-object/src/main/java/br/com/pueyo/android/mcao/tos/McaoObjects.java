package br.com.pueyo.android.mcao.tos;

import br.com.pueyo.android.mcao.tos.objects.CompraVista;
import br.com.pueyo.android.mcao.tos.objects.Transacao;

public class McaoObjects {

    public static Transacao getCompraVista(){
        return new CompraVista();
    }
}
