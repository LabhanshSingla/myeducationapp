package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.CourseHelper.PickUpFromWhereYouLeft;
import com.example.myapplication.CourseHelper.PopularCourse;

import java.util.List;

public class PopularCourseAdaptor extends RecyclerView.Adapter<PopularCourseAdaptor.PopulateViewHolder> {

    Context context;
    List<PopularCourse> popularCourseList;
    private ItemClickListener mItemListener;

    @NonNull
    @Override
    public PopulateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_row_item,parent,false);
        return new PopulateViewHolder(view);
    }

    public PopularCourseAdaptor(Context context, List<PopularCourse> popularCourseList,ItemClickListener itemClickListener) {
        this.context = context;
        this.popularCourseList = popularCourseList;
        this.mItemListener=itemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull PopulateViewHolder holder, int position) {
        holder.courseName.setText(popularCourseList.get(position).getName());
        holder.offered_by.setText(" Offered-By "+ "->" + " "+popularCourseList.get(position).getOfferedBy());
        holder.itemView.setOnClickListener(view ->{
            mItemListener.onItemClick(popularCourseList.get(position));
        });
        Glide.with(context).load(popularCourseList.get(position).getCourseimg()).into(holder.courseImage);


    }

    @Override
    public int getItemCount() {
        return popularCourseList.size();
    }

    public interface ItemClickListener{
        void onItemClick( PopularCourse details);


    }

    public static class PopulateViewHolder extends RecyclerView.ViewHolder{

        ImageView courseImage;
        TextView courseName, offered_by;



        public PopulateViewHolder(@NonNull View itemView) {
            super(itemView);
            courseImage = itemView.findViewById(R.id.courseImg);
            courseName = itemView.findViewById(R.id.CourseName);
            offered_by= itemView.findViewById(R.id.offered_by);
        }
    }

}
