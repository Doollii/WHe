package com.example.wh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SnsActivity extends AppCompatActivity {

    ListView list;

    String[] titles = {"test", "test01", "test02"};
    Integer[] images = {
            R.drawable.travel1,
            R.drawable.movie1,
            R.drawable.movie2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sns_main);

        CustomList adapter = new CustomList(SnsActivity.this);
        list = (ListView) findViewById(R.id.post_listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), titles[position],
                        Toast.LENGTH_SHORT).show();
            }
        });


        Button b1 = (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Button b = (Button) findViewById(R.id.post_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnsActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

    }

    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;

        public CustomList(Activity context) {
            super(context, R.layout.test_layout, titles);
            this.context = context;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.test_layout, null, true);
            ImageView postThumbnail = (ImageView) rowView.findViewById(R.id.postThumbnail);
            ImageView authorProfileImage = (ImageView) rowView.findViewById(R.id.authorProfileImage);
            TextView authorName = (TextView) rowView.findViewById(R.id.authorName);
            TextView content = (TextView) rowView.findViewById(R.id.postTextContent);
            authorName.setText(titles[position]);
            postThumbnail.setImageResource(images[position]);
            return rowView;
        }

    }
}




