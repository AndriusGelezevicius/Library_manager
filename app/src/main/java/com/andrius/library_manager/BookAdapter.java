package com.andrius.library_manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andrius.database.Book;
import com.andrius.database.BookData;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ViewConstructor")
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
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
        Book bookData = bookList.get(position);
        holder.bind(bookData);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int clickedPosition = holder.getAdapterPosition();

                // Retrieve the data of the clicked row
                Book clickedBook = bookList.get(clickedPosition);
                // Extract the desired data field (e.g., author) from the clicked row
                int id = clickedBook.getid();
                String author = clickedBook.getAuthor();
                String title = clickedBook.getTitle();
                String genre = clickedBook.getGenre();
                String year = String.valueOf(clickedBook.getYear());
                String page = String.valueOf(clickedBook.getPage());
                String language = clickedBook.getLanguage();
                String description = clickedBook.getDescription();


                Context context = view.getContext();
                Intent intent = new Intent(context, DetailOfBook.class);
                intent.putExtra("id", id);
//                intent.putExtra("title", title);
//
//                intent.putExtra("author", author);
//                intent.putExtra("genre", genre);
//                intent.putExtra("year", year);
//                intent.putExtra("page", page);
//                intent.putExtra("language", language);
//                intent.putExtra("description",description);
//
//                intent.putExtra("position", clickedPosition);
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

        public void bind(Book bookData) {
            bookTitle.setText(bookData.getTitle());
            bookAuthor.setText(bookData.getAuthor());
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public List<Book> search(String query){
        List<Book> searchResult = new ArrayList<>();

        // Perform the search based on the query
        for (Book bookData: bookList){
            // Adjust the condition based on your search requirements
            if(bookData.getTitle().toLowerCase().contains(query.toLowerCase())){
                searchResult.add(bookData);
            }
        }
        return searchResult;
    }
    // Method to update the dataset
    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Book> newData) {
        bookList.clear();
        if (newData != null) {
            bookList.addAll(newData);
        }
        notifyDataSetChanged();
    }

}
