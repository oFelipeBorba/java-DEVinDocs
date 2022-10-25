package entities;

public class Colaborador extends Pessoa{

    //construtores
    public Colaborador(){
        super();
    }
    public Colaborador(String nome, String sobrenome, String dataNascimento, String cpf, String enderecoCompleto) {
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto);
    }
}
