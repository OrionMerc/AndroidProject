package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.widget.EditText;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;
import interactivebook.conte.com.br.interactivebookapp.resource.UsuarioResource;

public class CadastrarControl {

    private Activity activity;
    private UsuarioResource usuarioResource;
    private Usuario usuario;

    private EditText nome;
    private EditText sobrenome;
    private EditText email;
    private EditText passwd;
    private EditText repasswd;

    public CadastrarControl(Activity activity){
        this.activity = activity;
        this.usuarioResource = new UsuarioResource();

        this.nome = activity.findViewById(R.id.edit_text_nome);
        this.sobrenome = activity.findViewById(R.id.edit_text_sobrenome);
        this.email = activity.findViewById(R.id.edit_text_email);
        this.passwd = activity.findViewById(R.id.edit_text_senha);
        this.repasswd = activity.findViewById(R.id.edit_text_confirma_senha);
    }

    public void cadastrarAction(){
        Usuario user = new Usuario();

        if(this.passwd.getText().toString().equalsIgnoreCase(this.repasswd.getText().toString())){
            user.setSenha(passwd.getText().toString());

            if(email.getText().toString() != null || email.getText().toString() != ""){
                user.setEmail(email.getText().toString());

                if(nome.getText().toString() != null || nome.getText().toString() != "") {
                    user.setNome(nome.getText().toString());

                    if(sobrenome.getText().toString() != null || sobrenome.getText().toString() != ""){
                        user.setSobrenome(sobrenome.getText().toString());

                        usuario = usuarioResource.cadastrarUsuario(this.activity.getApplicationContext(), user);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        if(usuario != null){
            this.activity.finish();
        }
    }

    public void cancelarAction(){
        this.activity.finish();
    }
}
