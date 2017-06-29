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
import br.com.pueyo.android.mcao.dto.operacoes.CompraVista;
import br.com.pueyo.android.mcao.dto.operacoes.OperacaoDTO;
import br.com.pueyo.android.mcao.listeners.DialogoNotificavel;

/**
 * Created by 07669751770 on 29/06/17.
 */

public class DialogoOperacao <T extends OperacaoDTO>  extends DialogFragment {

    DialogoNotificavel listener;

    private static final String TAG = DialogoOperacao.class.getName();
    private View dialogView;
    private int layout;


    Class<T> clazz;

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
                        try {
                            T operacao = (T) clazz.newInstance().gerarOperacaoFromView(dialogView);
                            listener.onDialogPositiveClick(DialogoOperacao.this,operacao);
                            dialog.cancel();

                        } catch (java.lang.InstantiationException e) {
                            Log.e(TAG, "Erro ao instanciar a Operação", e);
                        } catch (IllegalAccessException e) {
                            Log.e(TAG, "Erro ao instanciar a Operação", e);
                        }
                       }
                }).setNegativeButton(R.string.btn_cancelar,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogNegativeClick(DialogoOperacao.this);
                        dialog.cancel();
                    }});

        dialogView = inflater.inflate(layout,null);
        TextView campoCodigo = (TextView) dialogView.findViewById(R.id.cmp_codigo_value);
        if(campoCodigo != null){
            campoCodigo.setText(codAcao);
        }
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

    public void setLayout(int layout){
        this.layout = layout;
    }
}
