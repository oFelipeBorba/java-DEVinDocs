package entities;

public class Gerente extends Pessoa{
    private Double id;
    private String login;
    private String senha;


    //construtores
    public Gerente(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto);
        Double id = Math.random();
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    //getters
    public String getLogin() {
        return login;
    }

    public Double getId() {
        return id;
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
        System.out.println("\n----- Gerente ID: "+getId()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+getCpf());
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }
}
