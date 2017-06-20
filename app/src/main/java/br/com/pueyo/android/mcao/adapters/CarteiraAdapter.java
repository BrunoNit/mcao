package br.com.pueyo.android.mcao.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import br.com.pueyo.android.mcao.R;
import br.com.pueyo.android.mcao.dto.CardCarteiraAcaoDTO;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CarteiraAdapter extends RecyclerView.Adapter<CarteiraAdapter.ViewHolder>  {
    private static final String TAG = "CarteiraAdapter";

    private CardCarteiraAcaoDTO[] mDataSet;
    private AdapterView.AdapterContextMenuInfo info;

    public CarteiraAdapter() {
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private final TextView codAcao;
        private final TextView custoTotal;
        private final TextView custoUnitario;
        private final TextView quantidade;


        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
//            v.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
//                }
//            });

            codAcao = (TextView) v.findViewById(R.id.codAcao);
            custoTotal = (TextView) v.findViewById(R.id.custoTotal);
            custoUnitario = (TextView) v.findViewById(R.id.custoUnitario);
            quantidade = (TextView) v.findViewById(R.id.quantidade);

        }

        public TextView getCodAcao() {
            return codAcao;
        }

        public TextView getCustoTotal() {
            return custoTotal;
        }

        public TextView getCustoUnitario() {
            return custoUnitario;
        }

        public TextView getQuantidade() {
            return quantidade;
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            Log.w(TAG, "###### onCreateContextMenu #######");
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CarteiraAdapter(CardCarteiraAcaoDTO[] dataSet) {
        mDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        CardView v = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_carteira_acao, viewGroup, false);

      return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");
        CardCarteiraAcaoDTO card = mDataSet[position];
        viewHolder.getCodAcao().setText(card.getCodigoAcao());
        viewHolder.getCustoTotal().setText(card.getCustoTotalAsStringCurrency());
        viewHolder.getCustoUnitario().setText(card.getCustoUnitarioAsStringCurrency());
        viewHolder.getQuantidade().setText(card.getQuantidade());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}

