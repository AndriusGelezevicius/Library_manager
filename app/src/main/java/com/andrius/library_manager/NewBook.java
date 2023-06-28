package com.andrius.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.andrius.database.Book;
import com.andrius.database.BookDao;
import com.andrius.database.BookData;
import com.andrius.database.DataBase;
import com.andrius.database.MainDatabase;


import java.util.List;

public class NewBook extends AppCompatActivity {
    private Button saveBtn;
    private Button cancelBtn;
    private EditText et_title;
    private EditText et_author;
    private EditText et_genre;
    private EditText et_year;
    private EditText et_page;
    private EditText et_language;
    private EditText et_description;
    private ImageButton imageBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        
        saveBtn = (Button) findViewById(R.id.saveButton);
        cancelBtn = (Button) findViewById(R.id.cancleButton);
        et_title = (EditText) findViewById(R.id.titleField);
        et_author = (EditText) findViewById(R.id.authorField);
        et_genre = (EditText) findViewById(R.id.genreField);
        et_year = (EditText) findViewById(R.id.yearField);
        et_page = (EditText) findViewById(R.id.pageField);
        et_language = (EditText) findViewById(R.id.languageField);
        et_description = (EditText) findViewById(R.id.descriptionField);
        imageBtn = (ImageButton) findViewById(R.id.imageButton);
      
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book(
                        et_title.getText().toString(),
                        et_author.getText().toString(),
                        et_genre.getText().toString(),
                        et_language.getText().toString(),
                        et_description.getText().toString(),
                        Integer.parseInt(String.valueOf(et_year.getText())),
                        Integer.parseInt(et_page.getText().toString())
                );
//                DataBase dataBase = new DataBase(NewBook.this);
//                dataBase.addOneEntry(bookData);
                BookDao bookDao = MainDatabase.getInstance(getApplicationContext()).bookDao();
                bookDao.insertBook(book);
                finish();
            }
        });
        
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
    }
}
