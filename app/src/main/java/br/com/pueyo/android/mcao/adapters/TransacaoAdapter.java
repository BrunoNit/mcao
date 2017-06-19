package br.com.pueyo.android.mcao.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.pueyo.android.mcao.R;
import br.com.pueyo.android.mcao.dto.TransacaoDTO;

/**
 * Created by 07669751770 on 19/06/17.
 */

public class TransacaoAdapter extends RecyclerView.Adapter<TransacaoAdapter.ViewHolder> {

    private TransacaoDTO[] dataSet;

    public TransacaoAdapter(TransacaoDTO[] dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TransacaoDTO transacao = dataSet[position];

        holder.getTxtData().setText(transacao.getDataFormatada("dd/MM/yyyy"));
        holder.getTxtCodigo().setText(transacao.getCodigo().toString());
        holder.getTxtQuantidade().setText(transacao.getQuantidade().toString());
        holder.getTxtTipoOperacao().setText(transacao.getTipo().toString());
        holder.getTxtValor().setText(transacao.getValorFormatado());
        holder.getTxtPrecoMedio().setText(transacao.getPrecoMedioFormatado());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.linha_detalhe_transacao, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtCodigo;
        private TextView txtData;
        private TextView txtTipoOperacao;
        private TextView txtQuantidade;
        private TextView txtValor;
        private TextView txtPrecoMedio;

        public ViewHolder(View itemView) {

            super(itemView);

            this.txtData = (TextView) itemView.findViewById(R.id.row_det_trans_data);
            this.txtCodigo = (TextView) itemView.findViewById(R.id.row_det_trans_codigo);
            this.txtTipoOperacao = (TextView) itemView.findViewById(R.id.row_det_trans_tipo);
            this.txtQuantidade = (TextView) itemView.findViewById(R.id.row_det_trans_qtde);
            this.txtValor = (TextView) itemView.findViewById(R.id.row_det_trans_valor);
            this.txtPrecoMedio = (TextView) itemView.findViewById(R.id.row_det_trans_preco_medio);
        }


        public TextView getTxtCodigo() {
            return txtCodigo;
        }

        public void setTxtCodigo(TextView txtCodigo) {
            this.txtCodigo = txtCodigo;
        }

        public TextView getTxtTipoOperacao() {
            return txtTipoOperacao;
        }

        public void setTxtTipoOperacao(TextView txtTipoOperacao) {
            this.txtTipoOperacao = txtTipoOperacao;
        }

        public TextView getTxtQuantidade() {
            return txtQuantidade;
        }

        public void setTxtQuantidade(TextView txtQuantidade) {
            this.txtQuantidade = txtQuantidade;
        }

        public TextView getTxtValor() {
            return txtValor;
        }

        public void setTxtValor(TextView txtValor) {
            this.txtValor = txtValor;
        }

        public TextView getTxtPrecoMedio() {
            return txtPrecoMedio;
        }

        public void setTxtPrecoMedio(TextView txtPrecoMedio) {
            this.txtPrecoMedio = txtPrecoMedio;
        }
        public TextView getTxtData() {
            return txtData;
        }

        public void setTxtData(TextView txtData) {
            this.txtData = txtData;
        }
    }


}
