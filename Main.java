/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import javax.swing.JOptionPane;

/**
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntradaDeDados entrada = new EntradaDeDados();

        String menu = "1- Salvar \n2 - Buscar Todos \n3 - Remover \n 0 - Sair";
               // + "\n3 - Remover Aluno\n4- Salvar Professor\n"
                //+ "5 - Exibir Professores\n6 - Remover Professores";

        String opt = "";
        do {
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    break;
                case "1":
                    entrada.entradaPessoa(opt);
                    break;
                case "2":
                    entrada.exibirTodos(opt);
                    break;
                case "3":
                    entrada.remover(opt);
                    break;
                case "4":
                    entrada.entradaPessoa(opt);
                    break;
                case "5":
                    entrada.exibirTodos(opt);
                    break;
                case "6":
                    entrada.remover(opt);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (!opt.equals("0"));
    }

}
