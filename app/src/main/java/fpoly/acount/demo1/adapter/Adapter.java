package fpoly.acount.demo1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fpoly.acount.demo1.R;
import fpoly.acount.demo1.model.Model;

public class Adapter extends ArrayAdapter<Model> {
    public Adapter(@NonNull Context context, List<Model> models) {
        super(context, 0,models);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lv, parent,false);
        }
        Model model = getItem(position);
        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        TextView txtDescription = convertView.findViewById(R.id.txtDescription);
        txtTitle.setText(model.getTitle());
        txtDescription.setText(model.getDescription());
        return convertView;
    }
}
