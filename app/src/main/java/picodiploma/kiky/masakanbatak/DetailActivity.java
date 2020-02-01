package picodiploma.kiky.masakanbatak;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView gambar;
    TextView tentang, bahan, langkah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tentang = (TextView) findViewById(R.id.tv_arti);
        tentang.setText(getIntent().getStringExtra("Tentang"));

        bahan = (TextView) findViewById(R.id.tv_bahan);
        bahan.setText(getIntent().getStringExtra("Bahan"));

        langkah = (TextView) findViewById(R.id.tv_langkah);
        langkah.setText(getIntent().getStringExtra("Langkah"));

        gambar = (ImageView) findViewById(R.id.img_item_photo);
        String photo = (getIntent().getStringExtra("Photo"));
        Glide.with(this).load(photo).into(gambar);
    }

}
