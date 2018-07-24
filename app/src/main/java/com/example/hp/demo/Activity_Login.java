package com.example.hp.demo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity_Login extends AppCompatActivity {

    EditText user_email;
    EditText user_pass;
    Button btn_signIn;
    Button btn_forgotPass;
    Button btn_new_user;
    private String email;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_email=(EditText)findViewById(R.id.user_email);
        user_pass=(EditText)findViewById(R.id.user_pass);
        btn_signIn=(Button)findViewById(R.id.btn_SignIn);
        btn_forgotPass=(Button)findViewById(R.id.btn_forgot_pass);
        btn_new_user= (Button)findViewById(R.id.btn_new_user);
        setAuthInstance();
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogInUser();
            }
        });

        btn_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterActivity();
            }
        });

        btn_forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotYourPassword();
            }
        });

    }
    private String getUserEmail() {
        return user_email.getText().toString().trim();
    }

    private String getUserPassword() {
        return user_pass.getText().toString().trim();
    }

    public boolean validate() {
        boolean valid = true;
        String email = user_email.getText().toString();
        String password = user_pass.getText().toString();
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            user_email.setError("enter a valid email address");
            valid = false;
        } else {
            user_pass.setError(null);
        }

        if (password.isEmpty() || (password.length()<8 || password.matches(pattern))) {
            user_pass.setError("entered password must contain minimum 8 alphanumeric characters");
            valid = false;
        } else {
            user_pass.setError(null);
        }

        return valid;
    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void onLogInUser() {
        if (!validate()) {
        }
        else
        {
            logIn(getUserEmail(), getUserPassword());
        }
    }
    private void logIn(String email, String password) {

        final ProgressDialog progressDialog = new ProgressDialog(Activity_Login.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()){
                    goToMainActivity();
                }else {
                    Toast.makeText(getApplicationContext(), "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    user_pass.setText("");
                    user_pass.requestFocus();
                }
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(Activity_Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }

    private void goToRegisterActivity() {
        Intent i= new Intent(getApplicationContext(),Activity_SignUp.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }

    public void forgotYourPassword() {
        LayoutInflater li = LayoutInflater.from(Activity_Login.this);
        View promptsView = li.inflate(R.layout.prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                Activity_Login.this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userMail=(EditText)promptsView.findViewById(R.id.editTextDialogUserInput);
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                email=userMail.getText().toString();
                mAuth.sendPasswordResetEmail(email);
            }
        }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });
        // create alert dialog
        final AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        ((AlertDialog)alertDialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
        userMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                final Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                String MailId = userMail.toString().trim();
                if(MailId.isEmpty()) {
                    //userMail.setError("enter a valid email address");
                    okButton.setEnabled(false);
                }else {
                    //mUserPassWord.setError(null);
                    okButton.setEnabled(true);
                }
            }
        });

    }

}
