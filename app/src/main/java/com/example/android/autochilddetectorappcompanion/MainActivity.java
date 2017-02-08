package com.example.android.autochilddetectorappcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Setup System","Initialize/Sync your system", R.drawable.setup));
        words.add(new Word("System Guide", "Manual Guide for System", R.drawable.guide));
        words.add(new Word("KidsandCars.org", "Charitable organization", R.drawable.kidscars));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                if (position == 0)
                {
                    Intent intent = new Intent(view.getContext(), SetupActivity.class);
                    startActivity(intent);
                }
                else if (position == 1)
                {
                    Intent intent = new Intent(view.getContext(), GuideActivity.class);
                    startActivity(intent);
                }

                else
                {
                    Intent intent = new Intent(view.getContext(), KidsCarsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
