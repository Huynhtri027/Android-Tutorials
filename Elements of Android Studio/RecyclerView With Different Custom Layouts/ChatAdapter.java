import android.graphics.ColorSpace;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keremoflu.chatcustom.R;

import java.util.List;

import static com.example.keremoflu.chatcustom.Model.Mesaj.ADMIN_TYPE;
import static com.example.keremoflu.chatcustom.Model.Mesaj.USER_TYPE;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    RecyclerView.ViewHolder viewHolder;
    List<Mesaj> mesajList;


    public ChatAdapter(List<Mesaj> mesajList) {
        this.mesajList = mesajList;
    }

    @Override
    public int getItemViewType(int position) {
        Mesaj mesaj = mesajList.get(position);
        if(mesaj != null){
            mesaj.getType();
        }
        return mesaj.getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;


        switch (viewType){
            case ADMIN_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_polify, parent, false);
                return new OneViewHolder(view);

            case USER_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_user, parent, false);
                return new TwoViewHolder(view);
        }
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Mesaj mesaj = mesajList.get(position);
            switch (mesaj.getType()){
                case ADMIN_TYPE:
                    ((OneViewHolder)holder).first_layout_textView.setText(mesaj.getMessage());
                    break;

                case USER_TYPE:
                            ((TwoViewHolder)holder).second_layout_textView.setText(mesaj.getMessage());
                        break;
            }
    }

    @Override
    public int getItemCount() {
        return mesajList.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        ImageView chat_polify_image;
        TextView first_layout_textView;

        public OneViewHolder(View itemView) {
            super(itemView);
            chat_polify_image = (ImageView)itemView.findViewById(R.id.chat_polify_image);
            first_layout_textView = (TextView) itemView.findViewById(R.id.first_layout_textView);
        }
    }


    class TwoViewHolder extends RecyclerView.ViewHolder{
        TextView second_layout_textView;

        public TwoViewHolder(View itemView) {
            super(itemView);
            second_layout_textView = (TextView) itemView.findViewById(R.id.second_layout_textView);
        }
    }

}
