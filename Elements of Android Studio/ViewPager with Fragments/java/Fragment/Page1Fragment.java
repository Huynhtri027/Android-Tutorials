import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
public class Page1Fragment extends Fragment{

    FragmentViewPagerWebServices fragmentViewPagerWebServices;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page1, container, false);

        TextView textView_progress = (TextView)v.findViewById(R.id.textView_progressbar);
        ProgressBar progressbar = (ProgressBar)v.findViewById(R.id.progressbar_page1);

        fragmentViewPagerWebServices = new FragmentViewPagerWebServices();
        String progress_state = fragmentViewPagerWebServices.progress_start+" / "+fragmentViewPagerWebServices.progress_end;
        textView_progress.setText(progress_state);

        return v;
    }

}
