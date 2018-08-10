package br.gov.sp.prodesp.sim.servicosprefeituras.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;
import br.gov.sp.prodesp.sim.servicosprefeituras.utils.DataUtil;

public class TabProprietarioFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_proprietario, container, false);

        TextView dataAtual = view.findViewById(R.id.activity_dados_proprietario_data);
        dataAtual.setText(DataUtil.dataEmTexto(Calendar.getInstance()));
        return view;
    }
}
