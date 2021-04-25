package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<PhotoGrid> mPhotoGrid;

    public MyGridAdapter(Context context, List<PhotoGrid> mPhotoGrid) {
        this.mPhotoGrid = mPhotoGrid;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPhotoGrid.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item,parent,false);//有父容器，宽高有效
            viewHoder = new ViewHoder();
            viewHoder.imageView =convertView.findViewById(R.id.grid_item_iv);
            viewHoder.textView =convertView.findViewById(R.id.grid_item_tv);
            convertView.setTag(viewHoder);
        }else{
            viewHoder = (ViewHoder) convertView.getTag();
        }
        viewHoder.imageView.setImageResource(mPhotoGrid.get(position).getImageId());
        viewHoder.textView.setText(mPhotoGrid.get(position).getName());

        return convertView;
    }

    //封装每个item的属性，方便复用
    private class ViewHoder{
        private ImageView imageView;
        private TextView textView;
    }
}
