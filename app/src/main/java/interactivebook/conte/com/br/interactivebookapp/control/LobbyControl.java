package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
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
    private ListView livrosListView;
    private TextView headerUserTextView;
    private TextView headerEmailTextView;

    View rootViewHeader;
    public LobbyControl(Activity activity){
        this.activity = activity;

        userTextView = this.activity.findViewById(R.id.lobby_user_text_view);
        livrosListView = this.activity.findViewById(R.id.lobby_livro_listview);

        LayoutInflater inflater = LayoutInflater.from(this.activity);
        rootViewHeader = inflater.inflate(R.layout.activity_lobby_nav_header, null);
        try {
            NavigationView nv = activity.findViewById(R.id.navView);
            headerUserTextView = nv.getHeaderView(0).findViewById(R.id.nav_header_user_textView);
            headerEmailTextView = nv.getHeaderView(0).findViewById(R.id.nav_header_email_textView);
        }catch (Exception e){
            System.out.print("Erro: ");
            System.out.println(e.toString());
        }
        livroResource = new LivroResource(this.activity);

        getUserData();
    }

    private void getUserData(){
        this.usuario = (Usuario) this.activity.getIntent().getSerializableExtra("user");

        this.userTextView.setText("Bem vindo, " + usuario.getNome() + " " + usuario.getSobrenome());
        this.headerUserTextView.setText(usuario.getNome() + " " + usuario.getSobrenome());
        this.headerEmailTextView.setText(usuario.getEmail());

        getLivroFromAPI();
    }

    private void getLivroFromAPI(){

        try {
            livrosAdapter = new ArrayAdapter<>(
                    activity,
                    android.R.layout.simple_spinner_item,
                    new ArrayList<Livro>()
            );
            livrosListView.setAdapter(livrosAdapter);

            livroResource.buscaLivroPorId(1L, livrosAdapter);

        } catch (Exception e){
            Toast.makeText(activity, "Falha ao buscar livro", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Livro> testGetLivros(){
        List<Livro> livros = new ArrayList<>();

        Livro livro1 = new Livro();
        livro1.setNome("Livro 1");
        Livro livro2 = new Livro();
        livro2.setNome("Livro 2");
        Livro livro3 = new Livro();
        livro3.setNome("Livro 3");
        Livro livro4 = new Livro();
        livro4.setNome("Livro 4");
        Livro livro5 = new Livro();
        livro5.setNome("Livro 5");
        Livro livro6 = new Livro();
        livro6.setNome("Livro 6");
        Livro livro7 = new Livro();
        livro7.setNome("Livro 7");
        Livro livro8 = new Livro();
        livro8.setNome("Livro 8");
        Livro livro9 = new Livro();
        livro9.setNome("Livro 9");
        Livro livro10 = new Livro();
        livro10.setNome("Livro 10");
        Livro livro11 = new Livro();
        livro11.setNome("Livro 11");
        Livro livro12 = new Livro();
        livro12.setNome("Livro 12");
        Livro livro13 = new Livro();
        livro13.setNome("Livro 13");
        Livro livro14 = new Livro();
        livro14.setNome("Livro 14");
        Livro livro15 = new Livro();
        livro15.setNome("Livro 15");
        Livro livro16 = new Livro();
        livro16.setNome("Livro 16");
        Livro livro17 = new Livro();
        livro17.setNome("Livro 17");
        Livro livro18 = new Livro();
        livro18.setNome("Livro 18");
        Livro livro19 = new Livro();
        livro19.setNome("Livro 19");
        Livro livro20 = new Livro();
        livro20.setNome("Livro 20");
        Livro livro21 = new Livro();
        livro21.setNome("Livro 21");
        Livro livro22 = new Livro();
        livro22.setNome("Livro 22");
        Livro livro23 = new Livro();
        livro23.setNome("Livro 23");
        Livro livro24 = new Livro();
        livro24.setNome("Livro 24");
        Livro livro25 = new Livro();
        livro25.setNome("Livro 25");
        Livro livro26 = new Livro();
        livro26.setNome("Livro 26");
        Livro livro27 = new Livro();
        livro27.setNome("Livro 27");
        Livro livro28 = new Livro();
        livro28.setNome("Livro 28");
        Livro livro29 = new Livro();
        livro29.setNome("Livro 29");
        Livro livro30 = new Livro();
        livro30.setNome("Livro 30");
        Livro livro31 = new Livro();
        livro31.setNome("Livro 31");

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);
        livros.add(livro6);
        livros.add(livro7);
        livros.add(livro8);
        livros.add(livro9);
        livros.add(livro10);
        livros.add(livro11);
        livros.add(livro12);
        livros.add(livro13);
        livros.add(livro14);
        livros.add(livro15);
        livros.add(livro16);
        livros.add(livro17);
        livros.add(livro18);
        livros.add(livro19);
        livros.add(livro20);
        livros.add(livro21);
        livros.add(livro22);
        livros.add(livro23);
        livros.add(livro24);
        livros.add(livro25);
        livros.add(livro26);
        livros.add(livro27);
        livros.add(livro28);
        livros.add(livro29);
        livros.add(livro30);
        livros.add(livro31);

        return livros;
    }
}
