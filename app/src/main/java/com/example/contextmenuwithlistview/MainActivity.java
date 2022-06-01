package com.example.contextmenuwithlistview;  //androidx.constraintlayout.widget.ConstraintLayout

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listViewFoodItems;
    ArrayAdapter<String> stringArrayAdapter;
    String [] foodItems = {"vada pav" , "pav bhaji","dosa","poha","pani puri"};
    int MenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        stringArrayAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,foodItems);
        listViewFoodItems.setAdapter(stringArrayAdapter);//how to and what to disply the items and how my list look like
        registerForContextMenu(listViewFoodItems); //fetch how many food items

    }

    private void initViews()
    {
        listViewFoodItems =findViewById(R.id.listViewFoodItems);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Context Menu");
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        MenuItem = item.getItemId();
        switch(MenuItem)
        {
            case R.id.like:
                makeToast("Like");
                break;

            case R.id.dislike:
                makeToast("DisLike");
                break;

            case R.id.comments:
                makeToast("Comments");
                break;

            case R.id.addToCart:
                makeToast("Add_to_Cart");
                break;
        }
        return super.onContextItemSelected(item);
    }
    private void makeToast(String textInput)
    {
        Toast.makeText(this,textInput,Toast.LENGTH_SHORT).show();
    }

}