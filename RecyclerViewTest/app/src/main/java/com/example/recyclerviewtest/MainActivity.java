package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits(); //初始化水果数据
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id. recycler_view);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple);
            fruitList.add(apple);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R. drawable. pear);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple = new Fruit (getRandomLengthName("Pineapple"), R.drawable. pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry);
            fruitList.add(strawberry);
        }
    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
