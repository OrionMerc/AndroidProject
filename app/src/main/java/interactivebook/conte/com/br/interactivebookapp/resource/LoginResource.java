package interactivebook.conte.com.br.interactivebookapp.resource;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class LoginResource {

    private static final String BASE_URL = "http://192.168.2.150:8080/";
    private static final String URL = "login/";
    private AsyncHttpClient client;
    private Usuario usuario;

    public Usuario verificaUsuario(String email, String senha){
        client = new AsyncHttpClient();
        System.out.println(BASE_URL + URL + email + "/" + senha);

        client.get(BASE_URL + URL + email + "/" + senha, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                String resJSON = new String(bytes);
                //Usuario usuario;
                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Usuario.class);
                if(usuario != null) {
                    System.out.println(usuario.toString());
                } else {
                    System.out.println("Nada!");
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                usuario = null;
            }
        });

        return usuario;
    }
}
