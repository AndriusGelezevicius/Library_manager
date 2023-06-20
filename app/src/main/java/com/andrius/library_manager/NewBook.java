package com.andrius.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.andrius.database.BookData;
import com.andrius.database.DataBase;

public class NewBook extends AppCompatActivity {
    Button saveBtn, cancelBtn;
    EditText et_title, et_author, et_genre, et_year, et_page, et_language, et_description;
    ImageButton imageBtn;
    
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
                BookData bookData = new BookData(
                        et_title.getText().toString(),
                        et_author.getText().toString(),
                        et_genre.getText().toString(),
                        et_language.getText().toString(),
                        et_description.getText().toString(),
                        Integer.parseInt(et_year.getText().toString()),
                        Integer.parseInt(et_page.getText().toString())
                );
                DataBase dataBase = new DataBase(NewBook.this);
                dataBase.addOneEntry(bookData);
                Toast.makeText(NewBook.this, "" + bookData, Toast.LENGTH_SHORT).show();
            }
        });
        
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        
    }
}
