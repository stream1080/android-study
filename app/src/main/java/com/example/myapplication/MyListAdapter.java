package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private Context mcontext;
    private List<Photo> mPhotoList;
    public MyListAdapter(Context context, List<Photo> mList) {
        mcontext = context;
        mPhotoList = mList;
    }

    @Override
    public int getCount() {
        return mPhotoList.size();
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
        ViewHolder viewHolder = null;
        if(convertView == null){
//            加载一个页面
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.list_item,null);//null表示没有父容器，宽高无效
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.item_iv);
            viewHolder.tv_content = convertView.findViewById(R.id.tv_content);
            viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
            viewHolder.btn_item = convertView.findViewById(R.id.item_btn);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(mPhotoList.get(position).getImageId());
        viewHolder.tv_title.setText(mPhotoList.get(position).getTitle());
        viewHolder.tv_content.setText(mPhotoList.get(position).getContent());
        viewHolder.btn_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,mPhotoList.get(position).getTitle(),Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    //封装三个属性，便于复用
    private class ViewHolder{
        ImageView imageView;
        TextView tv_title,tv_content;
        Button btn_item;
    }


}
