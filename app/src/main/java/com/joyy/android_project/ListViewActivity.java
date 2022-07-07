package com.joyy.android_project;

import static android.view.LayoutInflater.*;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<Animal> mData = null;
    private AnimalAdapter mAdapter = null;
    private ListView list_animal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        list_animal = findViewById(R.id.listView);

        mData = new LinkedList<Animal>();
        mData.add(new Animal("狗说", "你是狗么?", R.mipmap.ic_launcher));
        mData.add(new Animal("牛说", "你是牛么?", R.mipmap.ic_launcher));
        mData.add(new Animal("鸭说", "你是鸭么?", R.mipmap.ic_launcher));
        mData.add(new Animal("鱼说", "你是鱼么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么?", R.mipmap.ic_launcher));
        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, this);
        list_animal.setAdapter(mAdapter);

        View headerView = View.inflate(this, R.layout.view_header, null);
        View footerView = View.inflate(this, R.layout.view_header, null);
        list_animal.addHeaderView(headerView);
        list_animal.addFooterView(footerView);
    }


    /**
     * Created by Jay on 2015/9/18 0018.
     */
    public final class Animal {
        private String aName;
        private String aSpeak;
        private int aIcon;

        public Animal() {
        }

        public Animal(String aName, String aSpeak, int aIcon) {
            this.aName = aName;
            this.aSpeak = aSpeak;
            this.aIcon = aIcon;
        }

        public String getaName() {
            return aName;
        }

        public String getaSpeak() {
            return aSpeak;
        }

        public int getaIcon() {
            return aIcon;
        }

        public void setaName(String aName) {
            this.aName = aName;
        }

        public void setaSpeak(String aSpeak) {
            this.aSpeak = aSpeak;
        }

        public void setaIcon(int aIcon) {
            this.aIcon = aIcon;
        }
    }

    /**
     * Created by Jay on 2015/9/18 0018.
     */
    public final class AnimalAdapter extends BaseAdapter {

        private final LinkedList<Animal> mData;
        private final Context mContext;

        public AnimalAdapter(LinkedList<Animal> mData, Context mContext) {
            this.mData = mData;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mData.size();
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
            convertView = from(mContext).inflate(R.layout.item_list_animal, parent, false);
            ImageView img_icon = convertView.findViewById(R.id.img_icon);
            TextView txt_aName = convertView.findViewById(R.id.txt_aName);
            TextView txt_aSpeak = convertView.findViewById(R.id.txt_aSpeak);
            img_icon.setBackgroundResource(mData.get(position).getaIcon());
            txt_aName.setText(mData.get(position).getaName());
            txt_aSpeak.setText(mData.get(position).getaSpeak());
            return convertView;
        }
    }
}