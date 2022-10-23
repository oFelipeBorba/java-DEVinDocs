package entities;

import java.util.ArrayList;

public class GestaoEquipe {
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Supervisor> listaSupervisores;
    private ArrayList<Gerente> listaGerentes;

    public GestaoEquipe(){
    this.listaFuncionarios = new ArrayList<>();
    this.listaSupervisores = new ArrayList<>();
    this.listaGerentes = new ArrayList<>();
    }

    public void adicionaColaborador(Pessoa pessoa){
        if(pessoa instanceof Funcionario){
            listaFuncionarios.add((Funcionario) pessoa);
        } else if (pessoa instanceof Supervisor) {
            listaSupervisores.add((Supervisor) pessoa);
        } else if (pessoa instanceof  Gerente) {
            listaGerentes.add((Gerente) pessoa);
        }
    }

    public void listarColaboradores(int tipoLista){
        switch (tipoLista){
            case 1:
                System.out.println("\nSegue abaixo a lista de funcionários: \n");
                for(Funcionario funcionario:listaFuncionarios){
                    funcionario.listarDados();
                }
                break;
            case 2:
                System.out.println("\nSegue abaixo a lista de supervisores: \n");
                for(Supervisor supervisor:listaSupervisores){
                    supervisor.listarDados();
                }
                break;
            case 3:
                System.out.println("\nSegue abaixo a lista de gerentes: \n");
                for(Gerente gerente:listaGerentes){
                }
                break;
            case 4:
                System.out.println("\nSegue abaixo a lista de todos os colaboradores: \n");
                for(Funcionario funcionario:listaFuncionarios){
                    funcionario.listarDados();
                }
                for(Supervisor supervisor:listaSupervisores){
                    supervisor.listarDados();
                }
                for(Gerente gerente:listaGerentes){
                }
                break;
        }
    }
}
