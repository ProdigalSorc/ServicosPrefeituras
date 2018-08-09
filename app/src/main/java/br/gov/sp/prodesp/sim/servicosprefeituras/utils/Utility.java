package br.gov.sp.prodesp.sim.servicosprefeituras.utils;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.gov.sp.prodesp.sim.servicosprefeituras.R;

public class Utility {
    public static ArrayAdapter setDropdownList(String[] stringArray, Activity activity) {
        if (stringArray == null) return null;
        List<String> list = Arrays.asList(stringArray);
        return new ArrayAdapter<>(activity,
                R.layout.custom_dropdown_list,
                R.id.txtDescricao,
                new ArrayList<>(list));
    }
}
