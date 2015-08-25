package entidade;

public class Solicitante {

    private Integer id;
    private String nome;
    private String email;
    private String sexo;
    private String telefone;
    private String celular;

    public Solicitante() {
    }

    public Solicitante(int id, String nome, String email, String sexo, String telefone, String celular) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
