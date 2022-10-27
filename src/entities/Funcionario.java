package entities;

import utilities.Documento;
import utilities.ValidaCPF;

import java.util.ArrayList;
import java.util.Date;

public class Funcionario extends Colaborador{
    private Integer idFuncionario;
    private String dadosAcessoFuncionario;

    //construtores
    public Funcionario(String nome, String sobrenome,  String dataNascimento, String cpf, String enderecoCompleto, String login, String senha){
        super(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
        this.idFuncionario = 15000+getId();
        this.dadosAcessoFuncionario = getLogin()+getSenha();
    }
    public Funcionario(String nome, String sobrenome,Integer id){
        super();
        this.idFuncionario = 15000+id;
    }

    //getter
    public Integer getIdFuncionario() {
        return idFuncionario;
    }
    public String getDadosAcessoFuncionario() {
        return dadosAcessoFuncionario;
    }
    public ArrayList<Integer> getListaIdsDocsTramitaveis() {
        return listaIdsDocsTramitaveis;
    }

    //metodo que monta a apresentação dos dados de cada colaborador
    public void listarDados(){
        System.out.println("\n----- Funcionário ID: "+getIdFuncionario()+" -----");
        System.out.println("Nome completo: "+getNome()+" "+getSobrenome());
        System.out.println("Data de nascimento: "+getDataNascimento());
        System.out.println("CPF: "+ ValidaCPF.montaCpfApresentacao(getCpf()));
        System.out.println("Endereço completo: "+getEnderecoCompleto());
        System.out.println("Login de acesso: "+getLogin());
    }
    @Override
    public void listarDocumentos(){
        novoDocumento = new Documento();
            if (novoDocumento.getListaDocumentos().toString().contains(getIdFuncionario().toString())){
                System.out.println("\nSegue abaixo a lista de todos os documentos criados por voce: ");
                for(Documento doc: novoDocumento.getListaDocumentos()){
                    if (doc.getIdCriador().toString().equals(getIdFuncionario().toString())){
                        System.out.println(doc.toString());
                    }
                }
            }else {
                System.out.println("Você não tem acesso a nenhum dos documentos cadastrados no sistema.");
            }

    }
}
