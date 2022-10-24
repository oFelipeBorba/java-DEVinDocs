import entities.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int selecaoMenu;
        String nome, sobrenome, cpf, enderecoCompleto,dataNascimento,login,senha;
        Pessoa novoColaborador;
        GestaoEquipe gerenciaEquipe = new GestaoEquipe();
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("\n------MENU------");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar novo colaborador");
            System.out.println("2 - Gerar relatório da lista de colaborador");
            System.out.println("0 - Sair");

            try{
                selecaoMenu = teclado.nextInt();
                teclado.nextLine();

                switch (selecaoMenu){
                    case 1:
                        System.out.println("\nInforme seu nome: ");
                        nome = teclado.nextLine();

                        System.out.println("\nInforme seu sobrenome: ");
                        sobrenome = teclado.nextLine();

                        System.out.println("\nInforme seu cpf: ");
                        cpf = teclado.nextLine();

                        System.out.println("\nInforme seu endereço completo: ");
                        enderecoCompleto = teclado.nextLine();

                        System.out.println("\nInforme sua data de nascimento: ");
                        dataNascimento = teclado.nextLine();

                        System.out.println("\nSelecione o cargo do novo colaborador:");
                        System.out.println("1 - Funcionário");
                        System.out.println("2 - Supervisor");
                        System.out.println("3 - Gerente");

                        int tipoColaborador;
                        try{
                            tipoColaborador = teclado.nextInt();
                            switch (tipoColaborador){
                                case 1:
                                    teclado.nextLine();
                                    System.out.println("\nInforme o login do novo funcionário: ");
                                    login = teclado.nextLine();
                                    System.out.println("\nInforme a senha do novo funcionário: ");
                                    senha = teclado.nextLine();
                                    novoColaborador = new Funcionario(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
                                    gerenciaEquipe.adicionaColaborador(novoColaborador);
                                    break;
                                case 2:
                                    teclado.nextLine();
                                    System.out.println("\nInforme o login do novo supervisor: ");
                                    login = teclado.nextLine();
                                    System.out.println("\nInforme a senha do novo supervisor: ");
                                    senha = teclado.nextLine();
                                    novoColaborador = new Supervisor(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
                                    gerenciaEquipe.adicionaColaborador(novoColaborador);
                                    break;
                                case 3:
                                    teclado.nextLine();
                                    System.out.println("\nInforme o login do novo gerente: ");
                                    login = teclado.nextLine();
                                    System.out.println("\nInforme a senha do novo gerente: ");
                                    senha = teclado.nextLine();
                                    novoColaborador = new Gerente(nome, sobrenome, dataNascimento, cpf, enderecoCompleto,login,senha);
                                    gerenciaEquipe.adicionaColaborador(novoColaborador);
                                    break;
                                default:
                                    System.out.println("\nATENÇÃO: Você não selecionou uma opção valida para o cargo do colaborador, tente novamente.");
                            }
                            break;
                        }catch (InputMismatchException err){
                            System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!");
                            teclado.next();
                            break;
                        }
                    case 2:
                        System.out.println("\nSelecione quais colaboradores irão compor o relatório:");
                        System.out.println("1 - Funcionários");
                        System.out.println("2 - Supervisores");
                        System.out.println("3 - Gerentes");
                        System.out.println("4 - Todos colaboradores");

                        int tipoLista;
                        try{
                            tipoLista = teclado.nextInt();
                            if(tipoLista != 1 && tipoLista != 2 && tipoLista != 3 && tipoLista != 4){
                                System.out.println("\nATENÇÃO: Você não selecionou uma opção valida, tente novamente.");
                            }else{
                                gerenciaEquipe.listarColaboradores(tipoLista);
                            }
                            break;
                        }catch (InputMismatchException err){
                            System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!");
                            teclado.next();
                            break;
                        }
                    case 3:
                        break;
                    case 0:
                        System.out.println("\nSaindo do sistema...");
                        break;
                    default:
                        System.out.println("\nPor favor, selecione uma opção valida do menu abaixo:");
                }
            }catch (InputMismatchException err){
                System.out.println("\nATENÇÃO: Você digitou caracteres, por favor informe apenas o número da opção que deseja!");
                teclado.next();
                selecaoMenu = 99;
            }
        } while (selecaoMenu != 0);
    }
    }
