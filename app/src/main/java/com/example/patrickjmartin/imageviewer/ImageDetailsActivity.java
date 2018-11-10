package com.example.patrickjmartin.imageviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ImageDetailsActivity extends AppCompatActivity {

    private TextView imageDeets;
    private ImageView imageSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        setContentView(R.layout.activity_image_details);

        imageDeets = findViewById(R.id.textView);
        imageSpace = findViewById(R.id.image_details_image);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        final ImageData imageData = (ImageData)intent.getSerializableExtra("image");
        imageSpace.setImageURI(imageData.getStringURI());
        imageDeets.setText(imageData.getName() + "\nURI:\n" + imageData.getStringURI());
        imageDeets.setTextSize(24);
        imageSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullscreenIntent = new Intent(ImageDetailsActivity.this, FullscreenActivity.class);
                fullscreenIntent.putExtra("uri", imageData.getStringURI().toString());
                startActivity(fullscreenIntent);
            }
        });

    }
}
