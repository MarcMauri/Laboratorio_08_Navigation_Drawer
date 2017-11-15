package app.android.mmauri.laboratorio_08_navigation_drawer.Fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import app.android.mmauri.laboratorio_08_navigation_drawer.R;

public class EmailFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {

    private FloatingActionButton fabMail;
    private TextView textViewMail;

    private AlertDialog.Builder builder;
    private EditText editTextEmail;


    public EmailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        textViewMail = view.findViewById(R.id.textViewEmail);

        fabMail = view.findViewById(R.id.fabWriteEmail);
        fabMail.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        showEmailDialog();
    }

    private void showEmailDialog() {
        builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.mail_dialog_title);
        builder.setMessage(R.string.mail_dialog_message);

        /* Set up the input (as on the Android course)

        editTextEmail = new EditText(getContext());
        editTextEmail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        builder.setView(editTextEmail);
        */

        // Set up the layout with input text
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_email, null);
        editTextEmail = (EditText) dialogView.findViewById(R.id.editTextMail);
        builder.setView(dialogView);

        // Set up the buttons
        builder.setPositiveButton(R.string.ok, this);
        builder.setNegativeButton(R.string.cancel, this);
        builder.create().show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {

            String email = editTextEmail.getText().toString().trim();
            if (!email.isEmpty()) {
                textViewMail.setText(email);
            }

        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            dialog.cancel();
        }
    }
}
