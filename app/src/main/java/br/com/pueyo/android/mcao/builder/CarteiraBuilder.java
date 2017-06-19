package br.com.pueyo.android.mcao.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.pueyo.android.mcao.dto.CardCarteiraAcaoDTO;
import br.com.pueyo.android.mcao.dto.DTO;

/**
 * Created by 07669751770 on 16/06/17.
 */

public class CarteiraBuilder<T extends DTO> extends Builder<T>{

   List<T> acoes = new ArrayList<T>();


    public CarteiraBuilder getInstance(){
        return new CarteiraBuilder();
    }

    public CarteiraBuilder<T> addAcao(String codigo, double custoTotal, int quantidade){
        CardCarteiraAcaoDTO cardAcao = new CardCarteiraAcaoDTO();
        cardAcao.setCodigoAcao(codigo);
        cardAcao.setCustoUnitario(custoTotal/quantidade);
        cardAcao.setCustoTotal(custoTotal);
        cardAcao.setQuantidade(String.valueOf(quantidade));
        acoes.add((T) cardAcao);

        return this;
    }

    public T[] build(){
        DTO[] c = new CardCarteiraAcaoDTO[acoes.size()];
        int i = 0;
        for(DTO card: acoes){
            c[i] = card;
            i++;
        }
        return (T[]) c;
    }


}
