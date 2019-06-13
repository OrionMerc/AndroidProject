package interactivebook.conte.com.br.interactivebookapp.resource;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import interactivebook.conte.com.br.interactivebookapp.config.ApiParams;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class LivroResource {

    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "livro/";
    private AsyncHttpClient client;
    private Livro livro;

    public Livro buscaLivroPorId(Long id){
        client = new AsyncHttpClient();

        client.get(BASE_URL + URL + id, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                String resJSON = new String(bytes);
                //Usuario usuario;
                Gson gson = new Gson();
                livro = gson.fromJson(resJSON, Livro.class);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                livro = null;
            }
        });

        return livro;
    }
}
