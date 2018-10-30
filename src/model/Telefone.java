package model;

public abstract class Telefone {
    Long idTelefone;
    String telefone;

    public Telefone(Long idTelefone, String telefone) {
        this.idTelefone = idTelefone;
        this.telefone = telefone;
    }

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
