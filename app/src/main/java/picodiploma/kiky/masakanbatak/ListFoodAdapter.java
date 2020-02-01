package picodiploma.kiky.masakanbatak;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListFoodAdapter extends RecyclerView.Adapter<ListFoodAdapter.ListViewHolder> {
    private ArrayList<Food> listFood = new ArrayList<Food>();
    private Context context;

    public ListFoodAdapter(Context context){
        this.context = context;
    }

    public ArrayList<Food> getListFood(){
        return listFood;
    }

    public  void setListFood(ArrayList<Food> listFood){
        this.listFood = listFood;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_food,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Food food = getListFood().get(position);

        Glide.with(holder.itemView.getContext())
                .load(food.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(food.getName());

        holder.tvName.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback(){

            @Override
            public void onItemClicked(View view, int Position) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("NAMA",food.getName());
                intent.putExtra("Photo",food.getPhoto());
                intent.putExtra("Tentang",food.getArti());
                intent.putExtra("Bahan", food.getBahan());
                intent.putExtra("Langkah", food.getLangkah());
                context.startActivity(intent);
            }
        }));

    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName =  itemView.findViewById(R.id.tv_item_name);
        }
    }

}

