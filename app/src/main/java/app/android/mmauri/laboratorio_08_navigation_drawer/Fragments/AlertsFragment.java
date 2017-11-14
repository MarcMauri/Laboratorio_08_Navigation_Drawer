package app.android.mmauri.laboratorio_08_navigation_drawer.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import app.android.mmauri.laboratorio_08_navigation_drawer.R;

public class AlertsFragment extends Fragment implements View.OnClickListener {

    private TextView textViewAlerts;
    private FloatingActionButton fabAlerts;

    public AlertsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alerts, container, false);

        textViewAlerts = view.findViewById(R.id.textViewAlerts);
        fabAlerts = view.findViewById(R.id.fabShowAlerts);

        fabAlerts.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        showAlertsDialog();
    }

    private void showAlertsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.alerts_dialog_title);
        builder.setMessage(R.string.alerts_dialog_message);

        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_alerts, null);
        builder.setView(viewInflated);

        final Switch aSwitch = (Switch) viewInflated.findViewById(R.id.switch_alert_dialog);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (aSwitch.isChecked())
                    textViewAlerts.setText(R.string.alerts_enabled);
                else
                    textViewAlerts.setText(R.string.alerts_disabled);
            }
        });
        builder.setNegativeButton(R.string.cancel,null);
        builder.create().show();
    }
}
