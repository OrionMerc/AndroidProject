package interactivebook.conte.com.br.interactivebookapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "livro")
public class Livro implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false, width = 45)
    private String nome;

    @DatabaseField(canBeNull = false, width = 45)
    private String autor;

    @ForeignCollectionField(eager = true)
    private Collection<Pagina> paginas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Collection<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(Collection<Pagina> paginas) {
        this.paginas = paginas;
    }

}
