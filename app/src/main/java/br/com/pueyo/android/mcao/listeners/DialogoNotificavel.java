package br.com.pueyo.android.mcao.listeners;

import android.support.v4.app.DialogFragment;

import br.com.pueyo.android.mcao.dto.operacoes.OperacaoDTO;

/**
 * Created by 07669751770 on 20/06/17.
 */

public interface DialogoNotificavel {

    public void onDialogPositiveClick(DialogFragment dialog, OperacaoDTO operacao);
    public void onDialogNegativeClick(DialogFragment dialog);
}
