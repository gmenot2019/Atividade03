/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 */
public class DAO {

    List<Pessoa> listaDePessoas = new ArrayList<>();

    public void salvar(Pessoa pessoa) {
        listaDePessoas.add(pessoa);
    }

    public void exibirTodos(String opcao) {
        String msg = "";
        if (opcao.equals("2")) {
            msg = listaDePessoas.stream().filter((listaDePessoa) -> (listaDePessoa instanceof Aluno)).map((listaDePessoa) -> (Aluno) listaDePessoa).map((aluno) -> aluno.getNome() + " - RA: " + aluno.getRa() + "\n").reduce(msg, String::concat);
        } else {
            for (Pessoa listaDePessoa : listaDePessoas) {
                if (listaDePessoa instanceof Professor) {
                    Professor professor = (Professor) listaDePessoa;
                    msg = professor.getNome() + " - SIAPE: " + professor.getSiape();
                }
            }
        }
        JOptionPane.showMessageDialog(null, msg);
    }

    public void remover(long cpf, String opcao) {
        boolean removido = false;

        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa.getCpf() == cpf) {
                if ((opcao.equals("3") && pessoa instanceof Aluno)
                        || (opcao.equals("6") && pessoa instanceof Professor)) {
                    listaDePessoas.remove(pessoa);
                    JOptionPane.showMessageDialog(null, pessoa.getClass().getSimpleName()
                            + " Removido com sucesso!");
                    removido = true;
                }
            }
        }

        if (!removido) {
            JOptionPane.showMessageDialog(null, "CPF não encontrado");
        }
    }
    
    public void salvarNoBD(Aluno aluno) throws SQLException{
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/academico", "root", "")) {
            String sql = "insert into aluno (nome, idade, sexo, cpf, ra) " +
                    "values(?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setString(3, aluno.getSexo());
            ps.setLong(4, aluno.getCpf());
            ps.setInt(5, aluno.getRa());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }


public void salvarNoBD(Professor professor) throws SQLException{
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/academico", "root", "")) {
            String sql = "insert into professor (nome, idade, sexo, cpf, siape) " +
                    "values(?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setInt(2, professor.getIdade());
            ps.setString(3, professor.getSexo());
            ps.setLong(4, professor.getCpf());
            ps.setLong(5, professor.getSiape());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
