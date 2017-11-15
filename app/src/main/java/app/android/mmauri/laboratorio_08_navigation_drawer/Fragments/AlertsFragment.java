package app.android.mmauri.laboratorio_08_navigation_drawer.Fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import app.android.mmauri.laboratorio_08_navigation_drawer.R;

public class AlertsFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {

    private TextView textViewAlerts;
    private FloatingActionButton fabAlerts;

    private AlertDialog.Builder builder;
    private Switch switchBtn;

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
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.alerts_dialog_title);
        builder.setMessage(R.string.alerts_dialog_message);

        // Get the layout inflater
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_alerts, null);
        switchBtn = (Switch) dialogView.findViewById(R.id.switch_alert_dialog);
        builder.setView(dialogView);

        // Set up the buttons
        builder.setPositiveButton(R.string.ok, this);
        builder.setNegativeButton(R.string.cancel, this);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {

            if (switchBtn.isChecked())
                textViewAlerts.setText(R.string.alerts_enabled);
            else
                textViewAlerts.setText(R.string.alerts_disabled);

        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            dialog.cancel();
        }
    }
}
