package interactivebook.conte.com.br.interactivebookapp.resource;

import android.content.Context;
import android.preference.PreferenceActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class UsuarioResource {

    private static final String BASE_URL = "http://192.168.110.115:8080";
    private static final String URL = "/usuario";
    private AsyncHttpClient client;
    private Usuario usuario;

    public void getUsuario(final ArrayAdapter<Usuario> adapterCategoria){
        client = new AsyncHttpClient();
        client.get(BASE_URL + URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String resJSON = new String(bytes);
                Usuario usuario;
                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Usuario.class);

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }
        });
    }

    public Usuario cadastrarUsuario(Context c, Usuario u){
        StringEntity entity=null;
        try {
            Gson g = new Gson();
            entity = new StringEntity(g.toJson(u));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client = new AsyncHttpClient();
        client.post(c, BASE_URL + URL, entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String resJSON = new String(bytes);

                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Usuario.class);
                //Toast.makeText(c, ""+usuario.getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                usuario = null;
            }
        });

        return usuario;
    }
}
