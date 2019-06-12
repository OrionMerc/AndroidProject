package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;
import interactivebook.conte.com.br.interactivebookapp.resource.LivroResource;

public class LobbyControl {

    private Activity activity;
    private Usuario usuario;
    private Livro livro;
    private LivroResource livroResource;

    private ArrayAdapter<Livro> livrosAdapter;
    private TextView userTextView;
    private TextView livroTextView;


    public LobbyControl(Activity activity){
        this.activity = activity;

        userTextView = this.activity.findViewById(R.id.lobby_user_text_view);
        livroTextView = this.activity.findViewById(R.id.lobby_livro_text_view);

        livroResource = new LivroResource();

        getUserData();
    }

    private void getUserData(){
        this.usuario = (Usuario) this.activity.getIntent().getSerializableExtra("user");

        this.userTextView.setText("Bem vindo " + usuario.getNome() + " " + usuario.getSobrenome());

        getLivroFromAPI();
    }

    private void getLivroFromAPI(){

        try {
            this.livro = livroResource.buscaLivroPorId(1L);

            if(livro != null){
                this.livroTextView.setText(livro.getNome());
            }

        } catch (Exception e){
            Toast.makeText(activity, "Falha ao buscar livro", Toast.LENGTH_SHORT).show();
        }
    }
}
