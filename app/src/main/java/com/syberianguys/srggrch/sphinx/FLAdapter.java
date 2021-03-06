package com.syberianguys.srggrch.sphinx;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FLAdapter extends ArrayAdapter<FlatSTR> {
    public FLAdapter(Context context, FlatSTR[] resource) {
        super(context, R.layout.adapter_flat, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final FlatSTR name = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_flat, null);
        }

        if ((name.security == 1) || (name.fire_alarm == 1) || (name.magnet_field == 1)  || (name.leak == 1))
            ((ImageView) convertView.findViewById(R.id.flatIndicator)).setImageResource(R.drawable.color_error);

        // Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.flatName)).setText(name.flat + " " + name.security
                + ' ' + name.fire_alarm + ' ' + name.magnet_field + ' ' + name.leak);
        return convertView;
    }
}
