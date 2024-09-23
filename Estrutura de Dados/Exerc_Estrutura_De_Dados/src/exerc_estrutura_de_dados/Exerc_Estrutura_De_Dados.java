package exerc_estrutura_de_dados;

import java.util.ArrayList;
import java.util.Scanner;

public class Exerc_Estrutura_De_Dados {

    public static void main(String[] args) {

        ArrayList<Aluno> alunos = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        menu();
        int escolha = scanner.nextInt();
        while (escolha != 5) {
            if (escolha == 1) {
                Aluno a = new Aluno();
                scanner.nextLine();
                System.out.print("Digite o Nome completo: ");
                
                a.setNome(scanner.nextLine());
                
                System.out.print("\nDigite a data de nascimento: ");
                a.setNascimento(scanner.nextLine());
                
                System.out.print("\nDigite o RA: ");
                a.setRA(scanner.nextLine());
                alunos.add(a);
            } else if (escolha == 2) {
                for (Aluno aluno : alunos) {
                    System.out.println(aluno);
                }
            } else if (escolha == 3) {
                scanner.nextLine();
                System.out.print("\nDigite o nome do aluno: ");
                String nome = scanner.nextLine();
                for(Aluno aluno : alunos){
                    if(aluno.getNome().equals(nome)){
                        System.out.println(aluno);
                    }else{
                        System.out.println("Aluno nao encontrado");
                    }
                }
            
            }else if(escolha == 4){
                 scanner.nextLine();
                System.out.print("\nDigite o nome do aluno que deseja remover: ");
                String nome = scanner.nextLine();
                for(int i =alunos.size()-1; i>=0;i--){
                    if(alunos.get(i).getNome().equals(nome)){
                        alunos.remove(i);
                        System.out.println("Aluno removido com sucesso!");
                    }else{
                        System.out.println("Aluno nao encontrado");
                    }
                }
            }

            menu();
            escolha = scanner.nextInt();
        }
    }

    public static void menu() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("             Bem - vindo!");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Escolha uma das seguintes opções: ");
        System.out.println("");

        System.out.println("1.Cadastrar aluno \n2.Listar alunos\n3.Pesquisar aluno\n4.Remover aluno\n5.Sair\n");

        System.out.print("Digite sua opção: ");
    }

    

}
