package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class LobbyControl {

    private Activity activity;
    private Usuario usuario;
    private Livro livro;
    private ArrayAdapter<Livro> livrosAdapter;
    private TextView userTextView;
    private ListView livrosListView;

    public LobbyControl(Activity activity){
        this.activity = activity;

        userTextView = this.activity.findViewById(R.id.)

    }
}
