package com.example.andydesk.desktopbuildconfiguration;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mainActivityImageView) ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Picasso.with(this)
                .load("https://i.ytimg.com/vi/mRf3-JkwqfU/hqdefault.jpg")
                .into(mImageView);

        YoYo.with(Techniques.BounceInDown)
                .delay(1000)
                .playOn(mImageView);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleApiClient mGoogleApiClient =new GoogleApiClient.Builder(this)
                .build();

    }

    private void buildWarningAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Warning");
        builder.setMessage("Are you sure you want to click this?");
        builder.setPositiveButton("Yes", new myButtonListener());
        builder.show();
    }

    @OnClick(R.id.mainActivityImageView)
    public void handleClick(View view) {
        buildWarningAlertDialog();
    }

    @OnLongClick(R.id.mainActivityImageView)
    public boolean handleLongClick(View view) {
        System.out.println("Long clicked button !!!!!!!");
        return false;
    }

    private class myButtonListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            YoYo.with(Techniques.DropOut)
                    .delay(1000)
                    .playOn(mImageView);
        }
    }
}
