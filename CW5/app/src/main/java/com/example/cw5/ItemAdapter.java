package com.example.cw5;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {
    ArrayList<Items> List2 = new ArrayList<>();
    Context context;

    public ItemAdapter(ArrayList<Items> List2, Context context ) {
        this.List2 = List2 ;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_item, parent,false );
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        ((ViewHolder)holder).textType.setText(List2.get(position).getItemName());
        ((ViewHolder)holder).textprice.setText(List2.get(position).getItemPrice()+"KD");
        //((ViewHolder)holder).img.setImageResource(List2.get(position).getItemImage());
        Picasso.with(context).load(List2.get(position).getItemImage()).into(((ViewHolder)holder).img);
        ((ViewHolder)holder).v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("laptop",List2.get(position));
                context.startActivity(intent);
            }
        });



        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Items removedlap = List2.get(position);

                    AlertDialog.Builder alert = new AlertDialog.Builder(context)
                            .setTitle("Attention")
                            .setMessage("Are you sure you want to delete ?")
                            .setPositiveButton("delete", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    List2.remove(position);
                                    notifyDataSetChanged();
                                    Snackbar.make(context, view, "1 item deleted",3000)
                                            .setAction("undo", new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    List2.add(removedlap);
                                                    notifyDataSetChanged();
                                                }
                                            }).show();


                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                    alert.show();

                }

            });
    }


    @Override
    public int getItemCount() {
        return List2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img, delete;
        TextView textType;
        TextView textprice;
        View v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            img = v.findViewById(R.id.imageView);
            textType = v.findViewById(R.id.textViewtype);
            textprice = v.findViewById(R.id.textViewprice);
            delete = v.findViewById(R.id.delete);


        }
    }
}
