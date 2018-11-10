package com.example.patrickjmartin.imageviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ImageData> images;
    private Context context;
    LinearLayout listLayout;
    public static final int IMAGE_REQUEST_CODE = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = new ArrayList<>();
        context = this;
        listLayout = findViewById(R.id.linear_layout);

        Log.i("ActivityStateTracking", String.format("%s - onCreate", getLocalClassName()));

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getImageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getImageIntent.setType("image/*");
                startActivityForResult(getImageIntent, IMAGE_REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_REQUEST_CODE) {
            Uri imData = data.getData();
            ImageData addImage = new ImageData("image" , imData);
            images.add(addImage);
            listLayout.addView(getImageTextView("image", images.size() - 1));



            }
        }
    }

    private TextView getImageTextView(String text, final int index) {
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(layP);
        textView.setText(text + " - " + index);
        textView.setTextSize(24);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageData image = images.get(index);
                Intent detailActivityIntent = new Intent(context, ImageDetailsActivity.class);
                detailActivityIntent.putExtra(image.getName(), image);
                startActivity(detailActivityIntent);
            }
        });

        return textView;

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityStateTracking", String.format("%s - onStart", getLocalClassName()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityStateTracking", String.format("%s - onResume", getLocalClassName()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ActivityStateTracking", String.format("%s - onPause", getLocalClassName()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ActivityStateTracking", String.format("%s - onStop", getLocalClassName()));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ActivityStateTracking", String.format("%s - onRestart", getLocalClassName()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ActivityStateTracking", String.format("%s - onDestroy", getLocalClassName()));
    }
}
