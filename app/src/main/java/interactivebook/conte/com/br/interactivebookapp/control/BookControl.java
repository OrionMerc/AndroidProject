package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Pagina;
import interactivebook.conte.com.br.interactivebookapp.model.Resposta;
import interactivebook.conte.com.br.interactivebookapp.view.LobbyActivity;

public class BookControl {

    private Activity activity;
    private Livro livro;
    private Pagina paginaAtual;
    private Resposta resposta;
    private TextView textView;
    private RelativeLayout layoutProxima;
    private LinearLayout layoutBtn;
    private Button pEscolha;
    private Button sEscolha;

    public BookControl(Activity activity) {
        this.activity = activity;

        initcomponents();
    }

    private void initcomponents() {

        livro = (Livro) this.activity.getIntent().getSerializableExtra("livro");
        textView = (TextView) activity.findViewById(R.id.layoutResult);
        layoutProxima = activity.findViewById(R.id.layoutProxima);
        layoutBtn = activity.findViewById(R.id.layoutBtn);
        pEscolha = activity.findViewById(R.id.primeiraEscolha);
        sEscolha = activity.findViewById(R.id.segundaEscolha);

        paginaAtual = getPagina("1");
        textView.setText(paginaAtual.getConteudo());

    }

    private Pagina getPagina(String j) {
        for (int i = 0; i < livro.getPaginas().size(); i++) {
            if (livro.getPaginas().get(i).getNumPagina().equals(j)) {
                layoutProxima.setVisibility(View.VISIBLE);

                return livro.getPaginas().get(i);
            }
        }
        return null;
    }


    public void proximaAction() {

        if (paginaAtual == null) {
            activity.finish();
        } else {
            String pPagina = String.valueOf(Integer.parseInt(paginaAtual.getNumPagina()) + 1);
            paginaAtual = getPagina(pPagina);
            //se
            if (paginaAtual != null) {
                textView.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
                textView.setText(paginaAtual.getConteudo());
                if (paginaAtual.getPergunta() == null) {
                    layoutProxima.setVisibility(View.VISIBLE);
                } else {
                    layoutProxima.setVisibility(View.INVISIBLE);
                    layoutBtn.setVisibility(View.VISIBLE);
                }

            }

        }


    }

    public void buttonIAction() {
        visibilidade();
        String pPagina = paginaAtual.getPergunta().getRespostas().get(0).getNext().getNumPagina();
        //pEscolha.setText(paginaAtual.getPergunta().getRespostas().get(0).getConteudo());
        paginaAtual = getPagina(pPagina);
        textView.setText(paginaAtual.getConteudo());
    }

    public void buttonIIAction() {
        visibilidade();
        String pPagina = paginaAtual.getPergunta().getRespostas().get(1).getNext().getNumPagina();
        //sEscolha.setText(paginaAtual.getPergunta().getRespostas().get(1).getConteudo());
        paginaAtual = getPagina(pPagina);
        textView.setText(paginaAtual.getConteudo());

    }

    private void visibilidade() {
        layoutProxima.setVisibility(View.INVISIBLE);
        layoutBtn.setVisibility(View.INVISIBLE);
    }

}
