package com.andrius.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andrius.database.Book;
import com.andrius.database.BookData;
import com.andrius.database.DataBase;
import com.andrius.database.MainDatabase;

import java.util.List;

public class DetailOfBook extends AppCompatActivity {
    private Book book;
    private Button deleteBtn;
    private List<Book> bookList;
    private BookAdapter adapter;
    private TextView insTitleField;
    private TextView insAuthorField;
    private TextView insGenreField;
    private TextView insPageField;
    private TextView insYearField;
    private TextView insLanguageField;
    private TextView insDecritpionField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of_book);


        deleteBtn = (Button) findViewById(R.id.deleteButton);
        insTitleField = (TextView) findViewById(R.id.InsTitleField);
        insAuthorField = (TextView) findViewById(R.id.InsAuthorField);
        insGenreField = (TextView) findViewById(R.id.InsGenreField);
        insYearField = (TextView) findViewById(R.id.InsYearField);
        insPageField = (TextView) findViewById(R.id.InsPageField);
        insLanguageField = (TextView) findViewById(R.id.InsLanguageField);
        insDecritpionField = (TextView) findViewById(R.id.InsDescriptionField);

        int bookId = getIntent().getIntExtra("id", -1);
        if (bookId != -1) {
            book = MainDatabase.getInstance(getApplicationContext()).bookDao().getItem(bookId);
            insTitleField.setText(book.getTitle());
            insAuthorField.setText(book.getAuthor());
            insGenreField.setText("Genre: " + book.getGenre());
            insYearField.setText("Published year: " + book.getYear());
            insPageField.setText("Page count: " + book.getPage());
            insLanguageField.setText("Language: \n" + book.getLanguage());
            insDecritpionField.setText("Description: \n" + book.getDescription());
        }

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (book !=null ){
                    MainDatabase.getInstance(getApplicationContext()).bookDao().deleteBook(book);
                }
                finish();
                            }
        });
    }
}