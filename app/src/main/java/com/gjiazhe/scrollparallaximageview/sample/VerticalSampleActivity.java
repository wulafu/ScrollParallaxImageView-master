package com.gjiazhe.scrollparallaximageview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.gjiazhe.scrollparallaximageview.ScrollParallaxImageView;
import com.gjiazhe.scrollparallaximageview.parallaxstyle.VerticalMovingStyle;

public class VerticalSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_sample);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private VerticalMovingStyle verticalMovingStyle = new VerticalMovingStyle();
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_img_vertical, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.iv.setParallaxStyles(verticalMovingStyle);
            RequestManager req = Glide.with(getApplicationContext());

            switch (position % 5) {
                case 0 : req.load(R.drawable.pic1).placeholder(R.drawable.pic1).into(holder.iv); break;
                case 1 : req.load(R.drawable.pic2).placeholder(R.drawable.pic2).into(holder.iv); break;
                case 2 : req.load(R.drawable.pic3).placeholder(R.drawable.pic3).into(holder.iv); break;
                case 3 : req.load(R.drawable.pic4).placeholder(R.drawable.pic4).into(holder.iv); break;
                case 4 : req.load(R.drawable.pic5).placeholder(R.drawable.pic5).into(holder.iv); break;
            }
        }

        @Override
        public int getItemCount() {
            return 25;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ScrollParallaxImageView iv;
            ViewHolder(View itemView) {
                super(itemView);
                iv = (ScrollParallaxImageView) itemView.findViewById(R.id.img);
            }
        }
    }
}
