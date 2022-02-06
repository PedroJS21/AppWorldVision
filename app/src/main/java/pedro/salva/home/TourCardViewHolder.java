package pedro.salva.home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

import pedro.salva.R;

public class TourCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView tourImagen;
    public TextView tourTitulo;
    public TextView tourPrecio;
    public TextView tourInformacion;

    public TourCardViewHolder(@NonNull View itemView) {
        super(itemView);
        tourImagen = itemView.findViewById(R.id.tour_imagen);
        tourTitulo = itemView.findViewById(R.id.tour_titulo);
        tourPrecio = itemView.findViewById(R.id.tour_precio);
        tourInformacion = itemView.findViewById(R.id.tour_informacion);
    }
}

