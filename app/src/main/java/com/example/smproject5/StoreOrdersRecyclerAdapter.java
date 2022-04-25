package com.example.smproject5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//TODO: Let the user remove an order by pressing an order
/**
 * This class is the recycler adapter for the store orders recycler view.
 * @author Aaron Browne
 */
public class StoreOrdersRecyclerAdapter extends RecyclerView.Adapter<StoreOrdersRecyclerAdapter.OrderHolder> {
    private ArrayList<Order> orderList;
    private ViewStoreOrders vso;

    /**
     * This constructor makes a new adapter with the information given.
     * @param list The list of orders in the recycler view.
     * @param main The main ViewStoreOrders object.
     */
    public StoreOrdersRecyclerAdapter(ArrayList<Order> list, ViewStoreOrders main) {
        orderList = list;
        vso = main;
    }

    /**
     * Sets up the format for list items using the xml file.
     * @param parent The parent.
     * @param viewType The view type.
     * @return The OrderHolder object.
     */
    @NonNull
    @Override
    public StoreOrdersRecyclerAdapter.OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ordersView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item,
                parent,false);
        return new OrderHolder(ordersView);
    }

    /**
     * Sets what will be in each list item.
     * @param holder The order holder.
     * @param position The index of the list item.
     */
    @Override
    public void onBindViewHolder(@NonNull StoreOrdersRecyclerAdapter.OrderHolder holder, int position) {
        String orderString = orderList.get(position).toString(position);
        holder.string.setText(orderString);
    }

    /**
     * Returns the amount of items in the list.
     * @return The amount of items in the list.
     */
    @Override
    public int getItemCount() {
        return orderList.size();
    }

    /**
     * This sub-class represents one item in the list.
     */
    public class OrderHolder extends RecyclerView.ViewHolder {
        private TextView string;
        private Button button;

        /**
         * Initializes the holder values.
         * @param itemView The view containing that list item.
         */
        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            string = itemView.findViewById(R.id.orderText);
            button = itemView.findViewById(R.id.removeOrderButton);
            setRemoveButtonOnClick(itemView); //register the onClicklistener for the button on each row.
        }

        /* set onClickListener for the row layout,
         * clicking on a row will navigate to another Activity
         *
        parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), ItemSelectedActivity.class);
                intent.putExtra("ITEM", name.getText());
                itemView.getContext().startActivity(intent);
            }
        }); */
        private void setRemoveButtonOnClick(View itemView) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),
                            "this order would be removed if I wrote the dang code already", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
