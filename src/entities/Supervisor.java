package entities;

import utilities.Documento;
import utilities.ValidaCPF;

import java.util.ArrayList;
import java.util.Date;

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
    public ArrayList<Integer> getListaIdsDocsTramitaveis() {
        return listaIdsDocsTramitaveis;
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
    @Override
    public void listarDocumentos(){
        novoDocumento = new Documento();
        if (novoDocumento.getListaDocumentos().size() > 0){
            System.out.println("\nSegue abaixo a lista de todos os documentos cadastrados no sistema por funcionarios e voce: ");
            for(Documento doc: novoDocumento.getListaDocumentos()){
                if (doc.getEstado().equals("Em aberto") && (doc.getIdCriador().toString().contains("15") || doc.getIdResponsavel().equals(getIdSupervisor()) || doc.getIdCriador().equals(getIdSupervisor()))){
                    System.out.println(doc);
                }
            }
        }else {
            System.out.println("Não existem documentos que você possa acessar cadastrados no sistema.");
        }
    }
    public void recusaDocumento(int idDoc, int idSupervisor){
        for (Documento doc:novoDocumento.getListaDocumentos()){
            if (doc.getIdDoc().equals(idDoc) && !doc.getIdCriador().equals(idSupervisor) ){
                doc.setIdResponsavel(doc.getIdCriador());
                System.out.println("O documento foi recusado com sucesso e retornou para o seu criador(ID: "+doc.getIdCriador()+")");
            } else if (doc.getIdDoc().equals(idDoc) && doc.getIdCriador().equals(idSupervisor) ) {
                System.out.println("\nATENÇÃO: Você não pode recusar um documento criado por você mesmo.");
            }
        }
    }
}
