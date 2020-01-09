package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class MainActivity extends AppCompatActivity {

//    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango",
//            "Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits(); //初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);  //ArrayAdaptero它可以通过泛型来指定 要适配的数据类型，然后在构造函数中把要适配的数据传入。ArrayAdapter有多个构造函数的重载，你应该根据实际情况选择最合适的一种。这里由于我们提供的数据都是字符串，因此将 ArrayAdapter的泛型指定为String,然后在ArrayAdaptei■的构造函数中依次传入当前上下文、 ListView子项布局的id,以及要适配的数据。注意，我们使用了 android.R. layout. simple_ list item l作为ListView子项布局的id,这是一个Android内置的布局文件，里面只有一个 TextView,可用于简单地显示一段文本。这样适配器对象就构建好了。
        ListView listview= (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter); //还需要调用ListView的setAdapter()方法，将构建好的适配器对象传递进去，这样 ListView和数据之间的关联就建立完成了。
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(
                        MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initFruits()
    {

        for(int i=0;i<2;i++)
        {
            Fruit apple = new Fruit("Apple",R.drawable.apple);
            fruitList.add(apple);
            Fruit orange = new Fruit("Orange",R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.pear);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry);
            fruitList.add(strawberry);

        }
    }
}


