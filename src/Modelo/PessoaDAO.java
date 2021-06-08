package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import BancoDeDados.FabricaConexao;

import java.util.ArrayList;
import java.util.Collections;

public class PessoaDAO {

	//METODO PARA CRIAR PESSOA
    public void createPessoa(Pessoa criaPessoa) {
        String sqlcheckname = "SELECT * FROM tb_pessoa WHERE nome = ?";
        String sql = "INSERT INTO tb_pessoa (nome, idade, endereco, areadasaude) VALUES (?, ?, ?, ?)";

        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement pscheckname = conexao.prepareStatement(sqlcheckname);
            pscheckname.setString(1, criaPessoa.getNome());
            ResultSet rsname = pscheckname.executeQuery();
            if (rsname.next()) {
                JOptionPane.showMessageDialog(null, "Nome já existe na base!\nFavor escrever diferente do digitado anteriormente.", "Duplicidade", JOptionPane.INFORMATION_MESSAGE);
            } else {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, criaPessoa.getNome());
                ps.setInt(2, criaPessoa.getIdade());
                ps.setString(3, criaPessoa.getEndereco());
                ps.setBoolean(4, criaPessoa.isAreasaude());

                String x;
                if (criaPessoa.isAreasaude() == true) {
                    x = "Sim";
                } else {
                    x = "Não";
                }
                int y = JOptionPane.showConfirmDialog(null, "Confirma os dados da pessoa a ser vacinada?\n\n"
                        + "Nome: " + criaPessoa.getNome() + "\nIdade: " + criaPessoa.getIdade()
                        + "\nEndereço: " + criaPessoa.getEndereco() + "\nÁrea da saúde? " + x ,
                        "Confirmação", JOptionPane.YES_NO_OPTION);

                if (y == JOptionPane.YES_OPTION) {
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Pessoa registrada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

  //METODO PARA CRIAR UMA ARRAYLIST COM TODAS PESSOAS CADASTRADAS QUE NÃO FORAM VACINADAS
    public ArrayList<Pessoa> listPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        String sql = "SELECT * FROM tb_pessoa WHERE datavacinacao = '1111-11-11'";
        Pessoa x;

        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                x = new Pessoa(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("endereco"),
                        rs.getBoolean("areadasaude")
                );
                pessoas.add(x);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Collections.sort(pessoas);

        return pessoas;
    }

    //METODO PARA CRIAR UMA ARRAYLIST COM TODAS PESSOAS CADASTRADAS QUE FORAM VACINADAS
    public ArrayList<Pessoa> listVacinados() {
        ArrayList<Pessoa> vacinados = new ArrayList<>();

        String sql = "SELECT * FROM tb_pessoa WHERE datavacinacao != '1111-11-11'";
        Pessoa x;

        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                x = new Pessoa(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("endereco"),
                        rs.getBoolean("areadasaude"),
                        rs.getDate("datavacinacao")
                );
                vacinados.add(x);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
        return vacinados;
    }

    //METODO PARA REGISTRAR VACINACAO
    public void registraVacinacao(Pessoa regVacina) {
        String sql = "UPDATE tb_pessoa SET datavacinacao = ? WHERE nome = ?";

        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            Date data = new Date(System.currentTimeMillis());
            ps.setDate(1, data);
            ps.setString(2, regVacina.getNome());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Vacinação registrada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //METODO PARA CRIAR ARRAYLIST DE VACINADOS POR DATA
    public ArrayList<Pessoa> listVacinadosFiltro(String dataInicial, String dataFinal) {
        ArrayList<Pessoa> vacinados = new ArrayList<>();

        String sql = "SELECT * FROM tb_pessoa WHERE datavacinacao BETWEEN ? AND ?";
        Pessoa x;

        try (Connection conexao = FabricaConexao.getConexao()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                x = new Pessoa(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getBoolean("areadasaude"),
                        rs.getDate("datavacinacao")
                );
                vacinados.add(x);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vacinados;
    }
}