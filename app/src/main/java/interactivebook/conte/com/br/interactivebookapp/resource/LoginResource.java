package interactivebook.conte.com.br.interactivebookapp.resource;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import cz.msebera.android.httpclient.Header;
import interactivebook.conte.com.br.interactivebookapp.config.ApiParams;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;
import interactivebook.conte.com.br.interactivebookapp.view.LobbyActivity;

public class LoginResource {

    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "login";
    private AsyncHttpClient client;
    private Usuario usuario;
    private Activity activity;

    public LoginResource(Activity activity){
        this.activity = activity;
    }

    public void verificaUsuario(String email, String senha){
        client = new AsyncHttpClient();
        // Inserir o header e testar na api
        client.get(BASE_URL + URL + "/" + email + "/" + senha, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                String resJSON = new String(bytes);
                //Usuario usuario;
                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Usuario.class);

                if(usuario != null){
                    Intent it = new Intent(activity, LobbyActivity.class);
                    it.putExtra("user", usuario);
                    activity.startActivity(it);
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Erro ao efetuar login", Toast.LENGTH_SHORT).show();
            }
        });

        //return usuario;
    }
}
