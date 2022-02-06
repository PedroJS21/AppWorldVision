package pedro.salva.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pedro.salva.R;
import pedro.salva.network.ImageRequester;
import pedro.salva.network.TourEntity;


public class TourRecyclerAdapter extends RecyclerView.Adapter<TourCardViewHolder> {
    private List<TourEntity> tourList;
    private ImageRequester imageRequester;

    public TourRecyclerAdapter(List<TourEntity> tourList) {
        this.tourList = tourList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public TourCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tour_card, parent, false);
        return new TourCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull TourCardViewHolder holder, int position) {
        if(tourList != null & position < tourList.size()) {
            TourEntity announce = tourList.get(position);
            holder.tourTitulo.setText(announce.titulo);
            holder.tourPrecio.setText(announce.precio);
            holder.tourInformacion.setText(announce.informacion);
            imageRequester.setImageFromUrl(holder.tourImagen, announce.url);
        }
    }

    @Override
    public  int getItemCount() {
        return tourList.size();
    }
}
