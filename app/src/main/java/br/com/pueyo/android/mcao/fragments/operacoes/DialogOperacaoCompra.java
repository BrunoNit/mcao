package br.com.pueyo.android.mcao.fragments.operacoes;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import br.com.pueyo.android.mcao.R;
import br.com.pueyo.android.mcao.dto.operacoes.OperacaoVista;
import br.com.pueyo.android.mcao.listeners.DialogoNotificavel;


/**
 * Created by 07669751770 on 20/06/17.
 */

public class DialogOperacaoCompra extends DialogFragment{

    private static final String TAG = DialogOperacaoCompra.class.getName();
    private View dialogView;


    DialogoNotificavel listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle extras = getActivity().getIntent().getExtras();


        String codAcao = null;
        if(extras != null){
            codAcao = extras.getString(getResources().getString(R.string.param_cod_acao));
        }

//        String codAcao = getResources().getString(R.string.param_cod_acao);

        LayoutInflater inflater = getActivity().getLayoutInflater();

        AlertDialog.Builder b = new AlertDialog.Builder(getActivity()).setPositiveButton(R.string.btn_operacao_salvar,
                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        OperacaoVista operacaoVista = (OperacaoVista) new OperacaoVista().gerarOperacaoFromView(dialogView);
                                        listener.onDialogPositiveClick(DialogOperacaoCompra.this, operacaoVista);
                                        dialog.cancel();
                                    }
                            }).setNegativeButton(R.string.btn_cancelar,
                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        listener.onDialogNegativeClick(DialogOperacaoCompra.this);
                                        dialog.cancel();
                                    }});

        dialogView = inflater.inflate(R.layout.dialog_adicionar_transacao,null);
        ((TextView) dialogView.findViewById(R.id.cmp_codigo_value)).setText(codAcao);
        b.setView(dialogView);

        Dialog d = b.create();
        d.getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorMcaoWhite));;

     return d;
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
