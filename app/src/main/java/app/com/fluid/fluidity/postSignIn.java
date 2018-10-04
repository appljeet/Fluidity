package app.com.fluid.fluidity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class postSignIn extends AppCompatActivity implements View.OnClickListener {


    private DatabaseReference mDatabase;
    ViewFlipper viewFlipper;
    Button goForward;
    Button goBackwards;
    TextView nameShow, signName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_sign_in);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        viewFlipper = findViewById(R.id.viewFlipper);
        goForward = findViewById(R.id.goForward);
        goBackwards = findViewById(R.id.goBackward);
        nameShow = findViewById(R.id.showName);

        goForward.setOnClickListener(this);
        goBackwards.setOnClickListener(this);
        signName = (EditText) findViewById(R.id.signInName);
        fillTextView();



    }



    @Override
    public void onClick(View v) {
        if (v == goForward) {
            viewFlipper.showNext();
        }
        else if (v == goBackwards) {
            viewFlipper.showPrevious();
        }
    }



    public void fillTextView() {
        nameShow.setText(String.valueOf(signName));
    }




}