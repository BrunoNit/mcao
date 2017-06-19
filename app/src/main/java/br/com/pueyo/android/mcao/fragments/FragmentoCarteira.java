package br.com.pueyo.android.mcao.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import br.com.pueyo.android.mcao.DetalhesAcaoActivity;
import br.com.pueyo.android.mcao.builder.CarteiraBuilder;
import br.com.pueyo.android.mcao.R;
import br.com.pueyo.android.mcao.adapters.CarteiraAdapter;
import br.com.pueyo.android.mcao.decorators.DividerItemDecoration;
import br.com.pueyo.android.mcao.dto.CardCarteiraAcaoDTO;
import br.com.pueyo.android.mcao.listeners.RecyclerItemClickListener;

/**
 * Created by 07669751770 on 16/06/17.
 */

public class FragmentoCarteira extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RadioButton mLinearLayoutRadioButton;
    protected RadioButton mGridLayoutRadioButton;

    protected RecyclerView carteiraRecycleView;
    protected CarteiraAdapter carteiraAdapter;
    protected RecyclerView.LayoutManager carteiraLayoutManager;
    protected String[] dados;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragmento_carteira, container, false);

        rootView.setTag(TAG);

        carteiraRecycleView = (RecyclerView) rootView.findViewById(R.id.carteira_recycler_view);

        carteiraLayoutManager = new GridLayoutManager(getActivity(),4);

        mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;

        if(savedInstanceState != null){
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable(KEY_LAYOUT_MANAGER);
        }

        carteiraRecycleView.setHasFixedSize(true);

        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        carteiraAdapter = new CarteiraAdapter(criarBase());

        carteiraRecycleView.setAdapter(carteiraAdapter);

//        Drawable d = ContextCompat.getDrawable(getActivity(),R.drawable.line_divider);
//
//        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(d);
//
//        carteiraRecycleView.addItemDecoration(decoration);

        carteiraRecycleView.addOnItemTouchListener(new RecyclerItemClickListener(this.getContext(), carteiraRecycleView, new RecyclerItemClickListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(getActivity(),DetalhesAcaoActivity.class);
                TextView tv = (TextView) view.findViewById(R.id.codAcao);
                String codAcao = getResources().getString(R.string.param_cod_acao);
                i.putExtra(codAcao,tv.getText());
                startActivity(i);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Log.w(TAG,"Item Click Longo da posição [" + position +"]");

            }
        }));

//        mLinearLayoutRadioButton = (RadioButton) rootView.findViewById(R.id.linear_layout_rb);
//        mLinearLayoutRadioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
//            }
//        });
//
//        mGridLayoutRadioButton = (RadioButton) rootView.findViewById(R.id.grid_layout_rb);
//        mGridLayoutRadioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
//            }
//        });
       return rootView;
    }

      public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (carteiraRecycleView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) carteiraRecycleView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                carteiraLayoutManager= new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                carteiraLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                carteiraLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        carteiraRecycleView.setLayoutManager(carteiraLayoutManager);
        carteiraRecycleView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    private CardCarteiraAcaoDTO[] criarBase(){

        CardCarteiraAcaoDTO[] carteira = new CarteiraBuilder<CardCarteiraAcaoDTO>().addAcao("LIXC4",12340.0,1000).
                addAcao("ELET3",27456.56,900).addAcao("EMBR3",15678.0,700).addAcao("EMBR4",15678.0,700).addAcao("EMBR5",15678.0,700).addAcao("EMBR6",15678.0,700)
                .addAcao("EMBR19",15678.0,700).addAcao("EMBR8",15678.0,700).addAcao("EMBR7",15678.0,700).build();
        return carteira;
    }



}
