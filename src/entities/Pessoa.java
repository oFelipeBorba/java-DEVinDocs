package entities;

public abstract class Pessoa {
    private String nome,sobrenome,dataNascimento, cpf,enderecoCompleto;
    private Integer id;
    private static int contador = 0;

    //construtores
    public Pessoa(){
    }
    public Pessoa(String nome, String sobrenome, String dataNascimento, String cpf, String enderecoCompleto) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.enderecoCompleto = enderecoCompleto;
        this.id = contador++;
    }

    //getters
    public Integer getId() {
        return id;
    }
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

}
