package br.gov.sp.prodesp.sim.servicosprefeituras.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter.IndicacaoAdapter;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Constantes;

public class IndicacaoActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicacao);
        tabLayout = findViewById(R.id.tablayout);
        setTabView();

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        viewPager = findViewById(R.id.viewpager);
        IndicacaoAdapter adapter = new IndicacaoAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), this);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            viewPager.setCurrentItem(extras.getInt("ABA_SELECIONADA"));
        }
    }

    private void setTabView() {
//        if (Utils.isLargeScreen(getApplicationContext())) {
//            tabLayout.addTab(tabLayout.newTab()
//                    .setContentDescription("INFRATOR")
//                    .setIcon(R.drawable.tab_condutor)
//                    .setText("INFRATOR"));
//            tabLayout.addTab(tabLayout.newTab()
//                    .setContentDescription("AGENTE")
//                    .setIcon(R.drawable.tab_agente)
//                    .setText("AGENTE"));
//        } else {
        tabLayout.addTab(tabLayout.newTab()
                        .setContentDescription(Constantes.TAB_PROPRIETARIO)
//                    .setIcon(R.drawable.tab_proprietario)
        );
        tabLayout.addTab(tabLayout.newTab()
                        .setContentDescription(Constantes.TAB_CONDUTOR)
//                    .setIcon(R.drawable.tab_condutor)
        );
//        }
    }
}
