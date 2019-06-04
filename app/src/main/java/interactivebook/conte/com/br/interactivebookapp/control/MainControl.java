package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;
import interactivebook.conte.com.br.interactivebookapp.resource.LoginResource;
import interactivebook.conte.com.br.interactivebookapp.view.LobbyActivity;

public class MainControl {

    private Activity activity;
    private LoginResource loginResource;
    private EditText email;
    private EditText senha;
    private Usuario usuario;

    public MainControl(Activity activity){
        this.activity = activity;
        this.loginResource = new LoginResource();

        this.email = activity.findViewById(R.id.edit_text_email);
        this.senha = activity.findViewById(R.id.edit_text_senha);
    }

    public void userValidator(){
        String e = email.getText().toString();
        String s = senha.getText().toString();

        usuario = loginResource.verificaUsuario(e,s);
        if(usuario != null){
            Intent it = new Intent(activity, LobbyActivity.class);
            it.putExtra("user", usuario);
            activity.startActivityForResult(it, 777);
        } else {
            Toast.makeText(activity, "Erro no login", Toast.LENGTH_SHORT).show();
        }
    }
}
