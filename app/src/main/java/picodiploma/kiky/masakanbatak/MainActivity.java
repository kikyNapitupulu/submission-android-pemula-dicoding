package picodiploma.kiky.masakanbatak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rvFood;
    private ArrayList<Food> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFood = findViewById(R.id.rv_food);
        rvFood.setHasFixedSize(true);

        list= new ArrayList<>();
        list.addAll(FoodData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvFood.setLayoutManager(new LinearLayoutManager(this));
        ListFoodAdapter listFoodAdapter = new ListFoodAdapter(this);
        listFoodAdapter.setListFood(list);
        rvFood.setAdapter(listFoodAdapter);
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);
    }
}
