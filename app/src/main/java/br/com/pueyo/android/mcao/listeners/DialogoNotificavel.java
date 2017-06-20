package br.com.pueyo.android.mcao.listeners;

import android.support.v4.app.DialogFragment;

/**
 * Created by 07669751770 on 20/06/17.
 */

public interface DialogoNotificavel {

    public void onDialogPositiveClick(DialogFragment dialog);
    public void onDialogNegativeClick(DialogFragment dialog);
}
