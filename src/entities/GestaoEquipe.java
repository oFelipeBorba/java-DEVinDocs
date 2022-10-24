package entities;

import java.util.ArrayList;

public class GestaoEquipe {
    //atributos do tipo ArrayList. reservado para montar as listas dos diferentes tipos de colaboradores
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Supervisor> listaSupervisores;
    private ArrayList<Gerente> listaGerentes;
    //construtor
    public GestaoEquipe(){
    this.listaFuncionarios = new ArrayList<>();
    this.listaSupervisores = new ArrayList<>();
    this.listaGerentes = new ArrayList<>();
    }
    //metodo que adiciona o novo colaborados na sua ArrayList de acordo com a instância que o obj foi criado
    public void adicionaColaborador(Pessoa pessoa){
        if(pessoa instanceof Funcionario){
            listaFuncionarios.add((Funcionario) pessoa);
        } else if (pessoa instanceof Supervisor) {
            listaSupervisores.add((Supervisor) pessoa);
        } else if (pessoa instanceof  Gerente) {
            listaGerentes.add((Gerente) pessoa);
        }
    }
    //metodo que realiza a apresentação da lista dos funcionarios, de acordo com o tipo de colaborador selecionado pelo usuario a partir do menu
    public void listarColaboradores(int tipoLista){
        switch (tipoLista){
            case 1:
                if(listaFuncionarios.size() == 0){
                    System.out.println("\nATENÇÃO: Não existem funcionários cadastrados. Realize o cadastro de novos colaboradores do tipo funcionário para visualizar o relatório.");
                }else{
                    System.out.println("\nSegue abaixo a lista de todos os funcionários: ");
                        for(Funcionario funcionario:listaFuncionarios){
                        funcionario.listarDados();
                    }
                }
                break;
            case 2:
                if(listaSupervisores.size() == 0){
                    System.out.println("\nATENÇÃO: Não existem supervisores cadastrados. Realize o cadastro de novos colaboradores do tipo supervisor para visualizar o relatório.");
                }else{
                    System.out.println("\nSegue abaixo a lista de todos os supervisores: ");
                        for(Supervisor supervisor:listaSupervisores){
                        supervisor.listarDados();
                    }
                }
                break;
            case 3:
                if(listaGerentes.size() == 0){
                    System.out.println("\nATENÇÃO: Não existem gerentes cadastrados. Realize o cadastro de novos colaboradores do tipo gerente para visualizar o relatório.");
                }else{
                    System.out.println("\nSegue abaixo a lista de todos os gerentes: ");
                        for(Gerente gerente:listaGerentes){
                        gerente.listarDados();
                    }
                }
                break;
            case 4:
                if(listaGerentes.size() == 0 && listaFuncionarios.size() == 0 && listaSupervisores.size() == 0){
                    System.out.println("\nATENÇÃO: Não existem colaboradores cadastrados no sistema. Realize o cadastro de novos colaboradores para visualizar o relatório.");
                }else{
                    System.out.println("\nSegue abaixo a lista de todos os colaboradores: ");
                for(Funcionario funcionario:listaFuncionarios){
                    funcionario.listarDados();
                }
                for(Supervisor supervisor:listaSupervisores){
                    supervisor.listarDados();
                }
                for(Gerente gerente:listaGerentes){
                    gerente.listarDados();
                }
                break;
        }}
    }
}
