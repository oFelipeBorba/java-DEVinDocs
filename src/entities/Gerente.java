package entities;

import utilities.ValidaCPF;

public class Gerente extends Colaborador{
    private Integer idGerente;
    private String dadosAcessoGerente;

    //construtores
    public Gerente(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
        this.idGerente = 21000+getId();
        this.dadosAcessoGerente = getLogin()+getSenha();
    }

    public Gerente(String nome, String sobrenome, Integer id) {
        super();
        this.idGerente=21000+id;
    }

    //getter
    public Integer getIdGerente() {
        return idGerente;
    }

    public String getDadosAcessoGerente() {
        return dadosAcessoGerente;
    }

    //metodo que monta a apresentação dos dados de cada colaborador
    public void listarDados(){
        System.out.println("\n----- Gerente ID: "+getIdGerente()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+ ValidaCPF.montaCpfApresentacao(getCpf()));
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }
}
