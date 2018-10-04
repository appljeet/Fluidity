package app.com.fluid.fluidity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class newUserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    boolean clicked = false;
    Button signInButton;
    TextView nameUser, emailSignIn, passwordSignIn;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);


        mAuth = FirebaseAuth.getInstance();
        nameUser = (EditText) findViewById(R.id.userName);
        passwordSignIn = (EditText) findViewById(R.id.password);
        emailSignIn = (EditText) findViewById(R.id.email);
        signInButton = findViewById(R.id.signIn);
        signInNow();

    }




    //Check if button has been clicked
    private void signInNow() {
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                loginFirebase();
            }
        });
    }

        private void loginFirebase () {
            if (clicked) {
                //Get text of text field
                final String email = emailSignIn.getText().toString().trim();
                final String password = passwordSignIn.getText().toString().trim();


                if (email.isEmpty()) {
                    emailSignIn.setError("Email is required");
                    emailSignIn.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    passwordSignIn.setError("Password is Required");
                    passwordSignIn.requestFocus();
                    return;
                }

                if (email.length() > 0 && password.length() >0) {

                    //code to attempt authentication with Firebase
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        finish();
                                        startActivity(new Intent(newUserActivity.this, postSignIn.class));
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Login failed, please recheck username and password", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });

                } else {
                    Toast.makeText(getApplicationContext(), "Login failed, please recheck username and password", Toast.LENGTH_SHORT).show();
                }
            }


        }







}
