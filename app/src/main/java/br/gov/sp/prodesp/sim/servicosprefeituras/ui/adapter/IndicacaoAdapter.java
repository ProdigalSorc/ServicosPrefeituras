package br.gov.sp.prodesp.sim.servicosprefeituras.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.gov.sp.prodesp.sim.servicosprefeituras.ui.fragments.TabCondutorFragment;
import br.gov.sp.prodesp.sim.servicosprefeituras.ui.fragments.TabProprietarioFragment;

public class IndicacaoAdapter extends FragmentStatePagerAdapter {

    private int mNumOfTabs;
    private Context context;

    public IndicacaoAdapter(FragmentManager fm, int NumOfTabs, Context context) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TabProprietarioFragment();
            case 1:
                return new TabCondutorFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
