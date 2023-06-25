package com.andrius.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andrius.library_manager.DetailOfBook;
import com.andrius.library_manager.R;

import java.util.List;

@SuppressLint("ViewConstructor")
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private final List<BookData> bookList;

    public BookAdapter(List<BookData> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_book, parent, false);
        BookViewHolder viewHolder = new BookViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        BookData bookData = bookList.get(position);
        holder.bind(bookData);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int clickedPosition = holder.getAdapterPosition();

                // Retrieve the data of the clicked row
                BookData clickedBook = bookList.get(clickedPosition);

                // Extract the desired data field (e.g., author) from the clicked row
                String author = clickedBook.getAuthor();
                String title = clickedBook.getTitle();
                String genre = clickedBook.getGenre();
                String year = String.valueOf(clickedBook.getYear());
                String page = String.valueOf(clickedBook.getPage());
                String language = clickedBook.getLanguage();
                String description = clickedBook.getDescription();


                Context context = view.getContext();
                Intent intent = new Intent(context, DetailOfBook.class);
                intent.putExtra("title", title);
                intent.putExtra("author", author);
                intent.putExtra("genre", genre);
                intent.putExtra("year", year);
                intent.putExtra("page", page);
                intent.putExtra("language", language);
                intent.putExtra("description",description);

                intent.putExtra("position", clickedPosition);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView bookTitle;
        private TextView bookAuthor;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.bookTitle);
            bookAuthor = itemView.findViewById(R.id.bookAuthor);
        }

        public void bind(BookData bookData) {
            bookTitle.setText(bookData.getTitle());
            bookAuthor.setText(bookData.getAuthor());
        }
    }





}
