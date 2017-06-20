package br.com.pueyo.android.mcao.fragments.operacoes;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;

import br.com.pueyo.android.mcao.R;
import br.com.pueyo.android.mcao.listeners.DialogoNotificavel;


/**
 * Created by 07669751770 on 20/06/17.
 */

public class OperacaoCompra extends DialogFragment {

    private static final String TAG = OperacaoCompra.class.getName();


    DialogoNotificavel listener;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_adicionar_transacao,null))
                .setPositiveButton(R.string.btn_operacao_salvar, new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogPositiveClick(OperacaoCompra.this);
                    }
                })
                .setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogNegativeClick(OperacaoCompra.this);
                    }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listener = (DialogoNotificavel) context;
        }catch (ClassCastException e){
            Log.e(TAG, context.toString() + " não implemnta a interface DialogoNotificavel");
            throw new ClassCastException(context.toString() + " deve implementar a interface DialogoNotificavel");
        }
    }
}
