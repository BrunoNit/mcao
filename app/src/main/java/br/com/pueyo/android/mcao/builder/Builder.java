package br.com.pueyo.android.mcao.builder;

import br.com.pueyo.android.mcao.dto.DTO;

/**
 * Created by 07669751770 on 19/06/17.
 */

public abstract  class Builder <T extends DTO> {

    public abstract T[] build();
}
