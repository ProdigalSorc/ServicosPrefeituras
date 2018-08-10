package br.gov.sp.prodesp.sim.servicosprefeituras.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.Utility;

public class TabCondutorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_condutor, container, false);

        Spinner editCnhUf = view.findViewById(R.id.activity_dados_condutor_uf_cnh);
        editCnhUf.setAdapter(Utility.setDropdownList(getResources().getStringArray(R.array.uf_array), getActivity()));

        Spinner editCnhRg = view.findViewById(R.id.activity_dados_condutor_uf_rg);
        editCnhRg.setAdapter(Utility.setDropdownList(getResources().getStringArray(R.array.uf_array), getActivity()));

        return view;
    }
}
