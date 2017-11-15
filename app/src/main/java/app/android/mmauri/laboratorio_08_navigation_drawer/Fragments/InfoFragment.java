package app.android.mmauri.laboratorio_08_navigation_drawer.Fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.android.mmauri.laboratorio_08_navigation_drawer.R;

public class InfoFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton fabMoreInfo;
    AlertDialog.Builder builder;

    public InfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        fabMoreInfo = (FloatingActionButton) view.findViewById(R.id.fabMoreInfo);
        fabMoreInfo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        showInfoDialog();
    }

    private void showInfoDialog() {
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.info_dialog_title);
        builder.setMessage(R.string.info_dialog_message);
        builder.setNeutralButton(R.string.got_it, null);
        builder.create().show();
    }
}
