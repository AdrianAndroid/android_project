package com.joyy.android_project;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
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

        private LinkedList<Animal> mData;
        private Context mContext;

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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_animal,parent,false);
            ImageView img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            TextView txt_aName = (TextView) convertView.findViewById(R.id.txt_aName);
            TextView txt_aSpeak = (TextView) convertView.findViewById(R.id.txt_aSpeak);
            img_icon.setBackgroundResource(mData.get(position).getaIcon());
            txt_aName.setText(mData.get(position).getaName());
            txt_aSpeak.setText(mData.get(position).getaSpeak());
            return convertView;
        }
    }
}