package com.example.pixabayapi;

import static com.example.pixabayapi.MainActivity.EXTRA_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    EditText edtSearch;
    Button btnSearch;

    public static final String SEARCH_KEY = "search_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        edtSearch = findViewById(R.id.edtTextSearch);
        btnSearch = findViewById(R.id.searchBtn);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String search_key = edtSearch.getText().toString();

                if (TextUtils.isEmpty(search_key)){
                    edtSearch.setError("Search Something");
                    edtSearch.requestFocus();
                    return;
                }
                else {

                    Intent mainIntent = new Intent(SearchActivity.this, MainActivity.class);

                    mainIntent.putExtra(SEARCH_KEY, search_key);

                    startActivity(mainIntent);

                }

            }
        });
    }
}