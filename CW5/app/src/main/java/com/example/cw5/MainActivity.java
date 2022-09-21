package com.example.cw5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Items> myList = new ArrayList<>();
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://laptopsstore-78f5d-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       // Items item4 = new Items("lenovo legion 5 ",R.drawable.dell,389.3);



       // myList.add(item4);

        RecyclerView recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this );
        recycler.setLayoutManager(manager);

        ItemAdapter adapter  = new ItemAdapter(myList, this);
        recycler.setAdapter(adapter);



        final Query myphone = dbRef.child("Laptops");

        myphone.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot a : snapshot.getChildren()){
                    Items laptop = a.getValue(Items.class);
                    myList.add(laptop);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}