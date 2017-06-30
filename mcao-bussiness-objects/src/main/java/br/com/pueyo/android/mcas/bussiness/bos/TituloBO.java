package br.com.pueyo.android.mcas.bussiness.bos;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * Created by 07669751770 on 30/06/17.
 */

public class TituloBO {

    Logger log = Logger.getGlobal();

    public BigInteger buscarQuantidadeTotalTitulo(String codigoTitulo){
        return BigInteger.TEN.multiply(BigInteger.TEN);
    }


}
