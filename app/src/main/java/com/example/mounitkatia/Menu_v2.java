package com.example.mounitkatia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class Menu_v2 extends AppCompatActivity {
    private itemArrayAdapter adapter;
    private ListView listview;
    private static int colorIndex;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Object AdapterView;
    TextView total, itemName, countItem;
    Button confirm;
    ImageView plus, minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_v2);
        colorIndex =0;
        listview = (ListView) findViewById(R.id.listView);
        adapter = new itemArrayAdapter(getApplicationContext(), R.layout.listview_row_layout);

        List<String[]> itemList = readData();
        //add items to the itemlist and then add to array adapter
        for(String[] itemdata:itemList ) {
            String fruitImg = itemdata[0];
            String fruitName = itemdata[1];
            String calories = itemdata[2];
            int fruitImgResId = getResources().getIdentifier(fruitImg, "drawable", getPackageName());

            mouneItem item = new mouneItem(fruitImgResId,fruitName,calories);
            adapter.add(item);
        }
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mouneItem item = new mouneItem(0, itemList.get(position)[1], itemList.get(position)[2]);
                Log.i("information", "complete");
                createAddingItemPopup();


            }
        });
    }
    public void createAddingItemPopup(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupView = getLayoutInflater().inflate(R.layout.popup, null);

        total = (TextView)popupView.findViewById(R.id.total);
        itemName = (TextView)popupView.findViewById(R.id.itemNameAdd);
        countItem = (TextView)popupView.findViewById(R.id.numberofitems);
        plus = (ImageView)popupView.findViewById(R.id.plusItem);
        minus = (ImageView)popupView.findViewById(R.id.minusItem);
        confirm = (Button)popupView.findViewById(R.id.confirm);


        dialogBuilder.setView(popupView);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<String[]>();
        String[] strawJam = new String[3];
        strawJam[0] = "strawberryjam";
        strawJam[1] = "Strawberry Jam";
        strawJam[2] = "2.7$";
        resultList.add(strawJam);

        String[] makdousBatenjen = new String[3];
        makdousBatenjen[0] = "makdous";
        makdousBatenjen[1] = "Eggplant Makdous";
        makdousBatenjen[2] = "2.7$";
        resultList.add(makdousBatenjen);

//        String[] mazaher = new String[3];
//        strawJam[0] = "makdous";
//        strawJam[1] = "Strawberry Jam";
//        strawJam[2] = "2.7$";
//        resultList.add(mazaher);
//
//        String[] labnehCow = new String[3];
//        strawJam[0] = "strawberryjam";
//        strawJam[1] = "Strawberry Jam";
//        strawJam[2] = "2.7$";
//        resultList.add(labnehCow);
//
//        String[] labnehGoat = new String[3];
//        strawJam[0] = "strawberryjam";
//        strawJam[1] = "Strawberry Jam";
//        strawJam[2] = "2.7$";
//        resultList.add(labnehGoat);
//
//        String[] Zaatar = new String[3];
//        strawJam[0] = "strawberryjam";
//        strawJam[1] = "Zaatar 1Kg";
//        strawJam[2] = "2.7$";
//        resultList.add(Zaatar);
//
//        String[] apricotJam = new String[3];
//        strawJam[0] = "strawberryjam";
//        strawJam[1] = "Apricot Jam";
//        strawJam[2] = "2.7$";
//        resultList.add(apricotJam);
//
//        String[] peachJam = new String[3];
//        strawJam[0] = "strawberryjam";
//        strawJam[1] = "Strawberry Jam";
//        strawJam[2] = "2.7$";
//        resultList.add(peachJam);




        return resultList;
    }

}
