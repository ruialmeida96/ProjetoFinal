
import java.io.Serializable;
import java.sql.Time;

public class Mensagem implements Serializable {

    private String hora;
    private String nome;
    private String mensagem;

    public Mensagem(String aHora, String aNome, String aMensagem) {
        hora = aHora;
        nome = aNome;
        mensagem = aMensagem;
    }

    public String getHora() {
        return hora;
    }

    public String getNome() {
        return nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
