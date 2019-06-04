package interactivebook.conte.com.br.interactivebookapp.resource;

import android.preference.PreferenceActivity;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class UsuarioResource {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String URL = "/livro";
    private AsyncHttpClient client;

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

    public void ler(Integer id){
        client = new AsyncHttpClient();
        client.get(BASE_URL + URL + "/" + id, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }
        });
    }

    public void removerCategoria(ArrayAdapter<Usuario> adapterCategoria, Integer id){

    }

    public void alterarCategoria(ArrayAdapter<Usuario> adapterCategoria, Integer id){

    }

    public void cadastrar(ArrayAdapter<Usuario> adapterCategoria, Usuario u){

    }
}
