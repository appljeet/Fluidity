package app.com.fluid.fluidity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class postSignIn extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    Button goForward;
    Button goBackwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_sign_in);

        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        goForward = (Button) findViewById(R.id.goForward);
        goBackwards = (Button) findViewById(R.id.goBackward);

        goForward.setOnClickListener(this);
        goBackwards.setOnClickListener(this);
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





}