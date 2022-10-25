package entities;

public class Funcionario extends Colaborador{
    private String login;
    private String senha;
    private Integer idFuncionario;


    //construtores
    public Funcionario(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto);
        idFuncionario = 15000+getId();
        this.login = login;
        this.senha = senha;
    }

    //getters
    public String getLogin() {
        return login;
    }
    public Integer getIdFuncionario() {
        return idFuncionario;
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
        System.out.println("\n----- Funcionário ID: "+getIdFuncionario()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+ValidaCPF.montaCpfApresentacao(getCpf()));
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }
}
