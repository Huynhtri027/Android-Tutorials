package recyclerview.recyclerview.Adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import recyclerview.recyclerview.Model.Model_ListItem;
import recyclerview.recyclerview.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Model_ListItem> listItems;
    private Context context;

    public MyAdapter(List<Model_ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Model_ListItem model_listItem = listItems.get(position);

        holder.textView_head.setText(model_listItem.getHead());
        holder.textView_desc.setText(model_listItem.getDesc());

        Picasso.with(context).load(model_listItem.getImageUrl()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked: "+model_listItem.getHead(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView_head;
        public TextView textView_desc;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_head = (TextView)itemView.findViewById(R.id.textView_head);
            textView_desc= (TextView)itemView.findViewById(R.id.textView_desc);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayout);
        }
    }
}
