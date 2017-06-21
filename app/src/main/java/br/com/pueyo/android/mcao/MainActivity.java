package br.com.pueyo.android.mcao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import br.com.pueyo.android.mcao.adapters.ViewPagerAdapter;
import br.com.pueyo.android.mcao.fragments.FragmentoCarteira;
import br.com.pueyo.android.mcao.fragments.FragmentoCota;
import br.com.pueyo.android.mcao.fragments.FragmentoFechamento;
import br.com.pueyo.android.mcao.fragments.FragmentoTransacao;
import br.com.pueyo.android.mcao.tos.McaoObjects;
import br.com.pueyo.android.mcao.tos.objects.Transacao;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewPage);
        configurarViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void configurarViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentoCarteira(), getResources().getString(R.string.titulo_aba_carteira));
        viewPagerAdapter.addFragment(new FragmentoCota(), getResources().getString(R.string.titulo_aba_cota));
        viewPagerAdapter.addFragment(new FragmentoFechamento(), getResources().getString(R.string.titulo_aba_fechanento));
        viewPagerAdapter.addFragment(new FragmentoTransacao(),"TRANSAÇÕES");

        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
