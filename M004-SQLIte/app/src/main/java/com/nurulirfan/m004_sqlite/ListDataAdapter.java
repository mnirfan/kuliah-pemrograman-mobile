package com.nurulirfan.m004_sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by mnirfan on 15/05/17.
 */

public class ListDataAdapter extends ArrayAdapter<ItemData> {
    protected ListDBHelper db;
    protected int layout;
    public ListDataAdapter(Context context, int layout_id, ListDBHelper _db){
        super(context, layout_id);
        db = _db;
        layout = layout_id;

        refresh();
    }

    public void refresh(){
        clear();
        addAll(db.getAll());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ItemData data = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);
        }

        TextView text = (TextView) convertView.findViewById(R.id.list_item_text);
        text.setText(data.text);
        return convertView;
    }
}
