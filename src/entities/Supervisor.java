package entities;

public class Supervisor extends Colaborador{
    private String login;
    private String senha;
    private Integer idSupervisor;


    //construtores
    public Supervisor(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto);
        idSupervisor = 17000+getId();
        this.login = login;
        this.senha = senha;
    }

    //getters
    public String getLogin() {
        return login;
    }

    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    //setters
    public void setLogin(String login) {
        this.login = login;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //metodo que monta a apresentação dos dados de cada colaborador
    public void listarDados(){
        System.out.println("\n----- Supervisor ID: "+getIdSupervisor()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+ValidaCPF.montaCpfApresentacao(getCpf()));
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }
}
