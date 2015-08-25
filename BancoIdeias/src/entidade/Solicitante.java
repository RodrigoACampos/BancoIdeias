package entidade;

public class Solicitante {
   private Integer Id; 
   private String Nome;
   private String Email;
   private String Fone;
   private Integer Celular;
   private String Sexo;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFone() {
        return Fone;
    }

    public void setFone(String Fone) {
        this.Fone = Fone;
    }

    public Integer getCelular() {
        return Celular;
    }

    public void setCelular(Integer Celular) {
        this.Celular = Celular;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
   
   
}
