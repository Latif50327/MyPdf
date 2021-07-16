package com.example.mypdf;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<File> fileList;

    public Adapter(Context context, List<File> fileList) {
        this.context = context;
        this.fileList = fileList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.pdflist_model, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        holder.title.setText(fileList.get(position).getName());
        holder.title.setSelected(true);

        //Bitmap thumb = ThumbnailUtils.createVideoThumbnail(fileList.get(position).getAbsolutePath(), MediaStore.Images.Thumbnails.MINI_KIND);
        //holder.videoThumbnail.setImageBitmap(thumb);
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),PdfViewer.class);
                intent.putExtra("path",fileList.get(position).getAbsolutePath());
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CardView PdfItem;
        public ImageView videoThumbnail;
        public TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            PdfItem = itemView.findViewById(R.id.pdfItem);
            //videoThumbnail = itemView.findViewById(R.id.videothumbnail);
            title = itemView.findViewById(R.id.pdfTitle);
        }
    }
}
