package pedro.salva.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pedro.salva.R;
import pedro.salva.network.TourEntity;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        setUpToolbar(view);

        //Recycler
        RecyclerView recyclerView = view.findViewById(R.id.tour_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        TourRecyclerAdapter adapter = new TourRecyclerAdapter(
                TourEntity.initTourEntryList(getResources()));
        recyclerView.setAdapter(adapter);

        int largePadding = getResources().getDimensionPixelSize(R.dimen.tour_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.tour_grid_spacing_small);
        recyclerView.addItemDecoration(new TourGridItemDecoration(largePadding, smallPadding));

        return view;
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }


}
