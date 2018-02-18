import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import forwhatsapp.speechtotext.oop_series_getset.Model.Model_Movie;
import forwhatsapp.speechtotext.oop_series_getset.R;

public class Adapter_Movie extends BaseAdapter {

    private Context context;
    private List<Model_Movie> movieList;
    private LayoutInflater layoutInflater;

    public Adapter_Movie(Context context, List<Model_Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View myView = layoutInflater.inflate(R.layout.item_movie,null);

        TextView textview_item_movieName = (TextView)myView.findViewById(R.id.textview_item_movieName);
        TextView textview_item_movieYear = (TextView)myView.findViewById(R.id.textView_item_movieYear);

        textview_item_movieName.setText(movieList.get(i).getMovieName());
        textview_item_movieYear.setText(String.valueOf(movieList.get(i).getMovieYear()));

        return myView;
    }
}
