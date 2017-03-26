package com.tayal.intent_list;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by lirisha on 30-12-2016.
 */
public class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private  Context context;

    public CustomList(Context context, String[] names) {
        super(context, R.layout.list_custom_layout, names);
        this.context = context;
        this.names = names;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(R.layout.list_custom_layout, null );
        TextView textView = (TextView) listViewItem.findViewById(R.id.textView);
        textView.setText(names[position]);
        Button button = (Button)listViewItem.findViewById((R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, names[position]);
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }

        });
        return  listViewItem;
    }
}
