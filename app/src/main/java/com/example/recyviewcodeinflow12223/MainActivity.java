package com.example.recyviewcodeinflow12223;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /**
     * this is where we display  our object items but they need an adapter. For this we need to create an Adapter class a custom Adapter
     * Adapter is a bridge between the data, ArrayList, and the display, RecyclerView
     * Adapter loads only what can be visible on any given screen and offloads whatever is out of view
     * LayoutManger ready made makes sure we get a list view of our items in LinearLayout form in this case
     */

    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });

    }

    public void insertItem(int position) {
        mExampleList.add(position, new ExampleItem(R.drawable.ic_android, "New item at Position"+ position,"This line 2"));
        mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }




    public void createExampleList() {
        /**
         * here and ArrayList is declared with a class <ExampleItem> so a whole class with its object constructor getters and setters is passed
         * and the ArrayList is assigned new ArrayList<>() so that new objects are fabricated out of it at will
         * A new object requires an image resource mImageResource and text lines mText1 and mText2 according to the dictates of the class ExamleItem object constructor demands
         */
        mExampleList= new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android,"line 1","line2")); // this is an object,created according to constructor,lines are hard coded, drawable is imported
        mExampleList.add(new ExampleItem(R.drawable.ic_audio,"line 3","line 4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_sun,"line 5","line 6"));
/*

        exampleList.add(new ExampleItem(R.drawable.ic_android,"line 7","line 8"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio,"line 9","line 10"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun,"line 11","line 12"));

        exampleList.add(new ExampleItem(R.drawable.ic_android,"line 13","line 14"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio,"line 15","line 16"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun,"line 17","line 18"));

        exampleList.add(new ExampleItem(R.drawable.ic_android,"line 19","line 20"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio,"line 21","line 22"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun,"line 23","line 24"));

        exampleList.add(new ExampleItem(R.drawable.ic_android,"line 25","line 26"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio,"line 27","line 28"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun,"line 29","line 30"));

*/
    }
    public void buildRecyclerView() {

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        // mRecyclerView.setHasFixedSize(mLayoutManager); // this is boolean incompatible with mLayoutManager
        mRecyclerView.setLayoutManager(mLayoutManager); //my solution! and it works!!!!!!!
        mRecyclerView.setAdapter(mAdapter);
    }
}