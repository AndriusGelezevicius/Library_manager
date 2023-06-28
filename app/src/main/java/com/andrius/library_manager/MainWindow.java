package com.andrius.library_manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andrius.database.Book;
import com.andrius.database.BookDao;
import com.andrius.database.BookData;
import com.andrius.database.DataBase;
import com.andrius.database.MainDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainWindow extends AppCompatActivity {
    Animation rotateOpen;
    Animation rotateClose;
    Animation fromBottom;
    Animation toBottom;
    FloatingActionButton addBtn;
    FloatingActionButton newBtn;
    FloatingActionButton searchBtn;
    private boolean clicked = false;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);

        addBtn = findViewById(R.id.addButton);
        newBtn = findViewById(R.id.newButton);
        searchBtn = findViewById(R.id.searchButton);
        recyclerView = findViewById(R.id.recyclerView);

//        DataBase dataBase = new DataBase(this);
//        List<BookData> bookList = dataBase.getEveryone();



        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddButtonClicked();

            }
        });

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, NewBook.class);
                startActivity(intent);
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, SearchWindow.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        BookDao bookDao = MainDatabase.getInstance(getApplicationContext()).bookDao();//pasiimam getAplication is Activitybook
        List<Book> bookList = bookDao.getAll();

        bookAdapter = new BookAdapter(bookList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookAdapter);
    }

    private void onAddButtonClicked() {
        setVisibility(clicked);
        setAnimation();
    }

    private void setVisibility(boolean isClicked) {
        if (!clicked) {
            newBtn.setVisibility(View.VISIBLE);
            searchBtn.setVisibility(View.VISIBLE);
        } else {
            newBtn.setVisibility(View.INVISIBLE);
            searchBtn.setVisibility(View.INVISIBLE);
        }
        clicked = !isClicked;
    }

    private void setAnimation() {
        if (!clicked) {
            addBtn.startAnimation(rotateOpen);
            newBtn.startAnimation(fromBottom);
            searchBtn.startAnimation(fromBottom);
        } else {
            addBtn.startAnimation(rotateClose);
            newBtn.startAnimation(toBottom);
            searchBtn.startAnimation(toBottom);
        }
    }
}