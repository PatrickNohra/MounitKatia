package com.example.mounitkatia;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class itemArrayAdapter extends ArrayAdapter<mouneItem>{
    private static final String TAG = "itemArrayAdapter";
    private List<mouneItem> itemList = new ArrayList<mouneItem>();

    static class itemViewHolder {
        ImageView itemImg;
        TextView itemName;
        TextView price;
    }

    public itemArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(mouneItem object) {
        itemList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.itemList.size();
    }

    @Override
    public mouneItem getItem(int index) {
        return this.itemList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        itemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview_row_layout, parent, false);
            viewHolder = new itemViewHolder();
            viewHolder.itemImg = (ImageView) row.findViewById(R.id.itemImg);
            viewHolder.itemName = (TextView) row.findViewById(R.id.itemName);
            viewHolder.price = (TextView) row.findViewById(R.id.price);
            row.setTag(viewHolder);
        } else {
            viewHolder = (itemViewHolder)row.getTag();
        }
        mouneItem mouneItem = getItem(position);
        viewHolder.itemImg.setImageResource(mouneItem.getItemImage());
        viewHolder.itemName.setText(mouneItem.getItemName());
        viewHolder.price.setText(mouneItem.getItemPrice());
        return row;
    }

    public Bitmap decodeToBitmap(byte[] decodedByte) {
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
