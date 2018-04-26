import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keremoflu.anketlisteleme.Adapter.Page3Adapter;
import com.example.keremoflu.anketlisteleme.Fragment.Fragment_WebServices.FragmentViewPagerWebServices;
import com.example.keremoflu.anketlisteleme.Model.MedalModel;
import com.example.keremoflu.anketlisteleme.R;

import java.util.ArrayList;
import java.util.List;

public class Page3Fragment extends Fragment {

    List<MedalModel> medalList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page3, container, false);

       //THIRD FRAGMENT

        return v;
    }
}