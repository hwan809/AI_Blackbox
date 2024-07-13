package com.example.ai_blackbox.accident_view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ai_blackbox.MainActivity;
import com.example.ai_blackbox.R;
import com.example.ai_blackbox.accident_view.ui.login.LoginActivity;
import com.example.ai_blackbox.ui.home.HomeFragment;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    
    ArrayList<ItemData> listview_data = new ArrayList<ItemData>();
    
    @Override
    public int getCount() {
        return listview_data.size();
    }

    @Override
    public Object getItem(int position) {
        return listview_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.accident_view_item, parent, false);
        }

        TextView accident_value_text = (TextView) convertView.findViewById(R.id.accident_value_text);
        TextView location_text = (TextView) convertView.findViewById(R.id.location_text);
        ImageView accident_image = (ImageView) convertView.findViewById(R.id.accident_image);
        Button analyze_button = (Button) convertView.findViewById(R.id.listview_item_button);

        ItemData itemData = listview_data.get(position);

        accident_value_text.setText(itemData.getAccidentValue());
        location_text.setText(itemData.getAccident_location());
        int image_id = itemData.getAccident_image_id();
        accident_image.setImageResource(image_id);

        analyze_button.setOnClickListener(v -> {
            Intent intent = new Intent(context, AccidentActivity.class);
            context.startActivity(intent);
        });

        return convertView;
    }
    
    public void add_item(String accident_value, int accident_image_id, String accident_location) {
        ItemData m_item = new ItemData();
        
        m_item.setAccidentValue(accident_value);
        m_item.setAccident_image_id(accident_image_id);
        m_item.setAccident_location(accident_location);

        listview_data.add(m_item);
    }
}
