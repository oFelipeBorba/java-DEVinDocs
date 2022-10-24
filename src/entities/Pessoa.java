package entities;

public abstract class Pessoa {
    private String nome,sobrenome,dataNascimento, cpf,enderecoCompleto;

    //construtores
    public Pessoa(){
    }
    public Pessoa(String nome, String sobrenome, String dataNascimento, String cpf, String enderecoCompleto) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.enderecoCompleto = enderecoCompleto;
    }

    //getters
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getDataNascimento() {
        return dataNascimento ;}
    public String getCpf() {
        return cpf;
    }
    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public void setDiaNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }
}
