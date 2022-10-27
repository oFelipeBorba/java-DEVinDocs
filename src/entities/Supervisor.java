package entities;

import utilities.ValidaCPF;

public class Supervisor extends Colaborador{
    private Integer idSupervisor;
    private String dadosAcessoSupervisor;


    //construtores
    public Supervisor(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
        this.idSupervisor = 17000+getId();
        this.dadosAcessoSupervisor = getLogin()+getSenha();
    }

    public Supervisor(String nome, String sobrenome, Integer id) {
        super();
        this.idSupervisor = 17000+id;
    }

    //getters
    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    public String getDadosAcessoSupervisor() {
        return dadosAcessoSupervisor;
    }

    //metodo que monta a apresentação dos dados de cada colaborador
    public void listarDados(){
        System.out.println("\n----- Supervisor ID: "+getIdSupervisor()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+ ValidaCPF.montaCpfApresentacao(getCpf()));
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }

}
