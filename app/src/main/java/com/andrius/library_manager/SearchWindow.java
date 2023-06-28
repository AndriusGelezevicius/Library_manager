package com.andrius.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andrius.database.BookData;

import java.util.ArrayList;
import java.util.List;

public class SearchWindow extends AppCompatActivity {
    Button searchBtn;
    EditText searchTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBtn = findViewById(R.id.searchButton);
        searchTxt = findViewById(R.id.searchField);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
//                String query = searchTxt.getText().toString().trim();
//                List<BookData> bookList = new ArrayList<>();
//                BookAdapter bookAdapter = new BookAdapter(bookList);
//                List<BookData> searchResults = bookAdapter.search(query);
//
//                // Update the adapter's data with the search results
//                bookAdapter.setData(searchResults);
//                Intent intent = new Intent(SearchWindow.this, MainWindow.class);
//                startActivity(intent);
            }
        });


    }

}