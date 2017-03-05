package com.week.bike.mycity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.week.bike.mycity.bean.CityBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 自定义城市通信录
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<CityBean> mDatas;
    private HashMap<String, Integer> map;
    private FrameLayout frame;
    private TextView text_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CityView letter = (CityView) findViewById(R.id.letter);
        final ListView lv = (ListView) findViewById(R.id.lv);
        text_frame = (TextView) findViewById(R.id.text_frame);
        letter.setOnLetterSelectedListener(new CityView.OnLetterSelectedListener() {
            @Override
            public void setSelectLetter(String s) {
                if (map.get(s) != null) {
                    lv.setSelection(map.get(s));
                }
            }
        });
        initDatas();
        initMap();
        //进行适配
        lv.setAdapter(new MyBaseAdapter());
    }

    /**
     * 初试化Map集合
     */
    private void initMap() {
        map = new HashMap<>();
        for (int i = 0; i < mDatas.size(); i++) {
            String preLetter = "";
            if (i - 1 >= 0) {
                preLetter = mDatas.get(i - 1).getNameSort();
            }
            if (!mDatas.get(i).getNameSort() .equals(preLetter)) {
                map.put(mDatas.get(i).getNameSort(), i);
            }
        }
    }
    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int i) {
            return mDatas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
            TextView tv_nameSort = (TextView) view.findViewById(R.id.tv_nameSort);
            TextView tv_cityName = (TextView) view.findViewById(R.id.tv_cityName);
            String preNameSort = "";
            if (i - 1 >= 0) {
                preNameSort = mDatas.get(i - 1).getNameSort();
            }
            if (mDatas.get(i).getNameSort().equals(preNameSort)) {
                tv_nameSort.setVisibility(View.GONE);
            } else {
                tv_nameSort.setVisibility(View.VISIBLE);
            }
            //进行赋值
            tv_nameSort.setText(mDatas.get(i).getNameSort());
            tv_cityName.setText(mDatas.get(i).getCityName());
            return view;
        }
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        mDatas.add(new CityBean("A", "安徽"));
        mDatas.add(new CityBean("A", "安庆"));
        mDatas.add(new CityBean("A", "安阳"));
        mDatas.add(new CityBean("A", "安大"));
        mDatas.add(new CityBean("B", "北京"));
        mDatas.add(new CityBean("B", "北平"));
        mDatas.add(new CityBean("B", "北海"));
        mDatas.add(new CityBean("F", "福建"));
        mDatas.add(new CityBean("G", "广东"));
        mDatas.add(new CityBean("G", "甘肃"));
        mDatas.add(new CityBean("G", "贵州"));
        mDatas.add(new CityBean("G", "广西"));
        mDatas.add(new CityBean("H", "河南"));
        mDatas.add(new CityBean("H", "湖北"));
        mDatas.add(new CityBean("H", "湖南"));
        mDatas.add(new CityBean("H", "河北"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("J", "江苏"));
        mDatas.add(new CityBean("R", "日本"));
        mDatas.add(new CityBean("R", "日本"));
        mDatas.add(new CityBean("R", "日本"));
        mDatas.add(new CityBean("R", "日本"));

    }

}
