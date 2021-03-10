package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SampleData> movieDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,movieDataList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void InitializeMovieData()
    {
        movieDataList = new ArrayList<SampleData>();

        movieDataList.add(new SampleData(R.id.name,R.id.number,R.id.email));
//        movieDataList.add(new SampleData(R.drawable.movieposter2, "아저씨","19세 이상관람가"));
//        movieDataList.add(new SampleData(R.drawable.movieposter3, "어벤져스","12세 이상관람가"));
    }
}


    class SampleData {
        private String name;
        private String number;
        private String email;

        public SampleData(int name, int movieName, int grade) {
            this.name = toString();
            this.number = number;
            this.email = email;
        }

        public String getName() {
            return this.name;
        }

        public String getNumber() {
            return this.number;
        }

        public String getEmail() {
            return this.email;
        }
    }

    class MyAdapter extends BaseAdapter {

        Context mContext = null;
        LayoutInflater mLayoutInflater = null;
        ArrayList<SampleData> sample;

        public MyAdapter(Context context, ArrayList<SampleData> data) {
            mContext = context;
            sample = data;
            mLayoutInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return sample.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public SampleData getItem(int position) {
            return sample.get(position);
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent) {
            View view = mLayoutInflater.inflate(R.layout.listlayout, null);

          EditText name = view.findViewById(R.id.name);
            TextView number = (TextView)view.findViewById(R.id.number);
            TextView email = (TextView)view.findViewById(R.id.email);

            name.setText(sample.get(position).getName());
            number.setText(sample.get(position).getNumber());
            email.setText(sample.get(position).getEmail());

            return view;
        }
    }

