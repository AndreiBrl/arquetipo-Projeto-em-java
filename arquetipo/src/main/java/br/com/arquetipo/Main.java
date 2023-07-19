package br.com.arquetipo;

import br.com.arquetipo.model.u.Editora;
import br.com.arquetipo.model.u.Escritor;
import br.com.arquetipo.model.u.Leitor;
import br.com.arquetipo.model.u.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();


    }
    public static void menu(){
        Scanner le = new Scanner(System.in);
        System.out.println("Bem vindo a Arquétipo");
        System.out.println("Deseja se cadastrar?(S/N)");
        String novoUsuario = le.next();
       if(novoUsuario.equalsIgnoreCase("s")){
           cadastraUsuario();
       }
       else{
           System.out.println("Encerrado");
       }

    }
    public static void cadastraUsuario(){
        Scanner le = new Scanner(System.in);
        System.out.println("Escolha um tipo de conta:\n 1 - Escritor\n 2 - Leitor \n 3 - Editora");
        int opcao = le.nextInt();
        Usuario usu = null;

        switch (opcao){
            case 1:
                usu = new Escritor();
                break;

            case 2:
                usu = new Leitor();
                break;

            case 3:
                usu = new Editora();
                break;

            default:
                System.out.println("Escolha inexistente");
                cadastraUsuario();
        }
        criaLoginSenha(usu);

    }

    public static void criaLoginSenha(Usuario usu){
        Scanner le = new Scanner(System.in);
        System.out.println("Cadastro de login e senha");
        System.out.println("Digite seu login: ");
        String login;
        usu.setLogin(login= le.next());
        System.out.println("Digite sua senha: ");
        String senha;
        usu.setSenha(senha=le.next());


    }

}