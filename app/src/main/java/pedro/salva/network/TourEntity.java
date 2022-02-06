package pedro.salva.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import pedro.salva.R;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TourEntity {
    private static final String TAG = TourEntity.class.getSimpleName();

    public final String titulo;
    public final Uri dynamicUrl;
    public final String url;
    public final String precio;
    public final String informacion;

    public TourEntity(String titulo, String dynamicUrl, String url, String precio, String informacion) {
        this.titulo = titulo;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.precio = precio;
        this.informacion = informacion;
    }

    public static List<TourEntity> initTourEntryList (Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.tours);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0 , pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo JSON", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Hubo un error al cerrar el input stream", exception);
            }
        }

        String jsonToursString = writer.toString();
        Gson gson = new Gson();
        Type tourListType = new TypeToken<ArrayList<TourEntity>>(){
        }.getType();

        return gson.fromJson(jsonToursString, tourListType);
    }
}