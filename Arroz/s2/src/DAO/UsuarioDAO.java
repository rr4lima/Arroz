package DAO;

import DTO.UsuarioDTO;
import VIEW.UsuarioForm;
import VIEW.TelaPrincipal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar(UsuarioDTO objusuarioDTO) {
        String sql = "select * from tb_usuarios where login = ? and senha = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objusuarioDTO.getLogin_usuario());
            pst.setString(2, objusuarioDTO.getSenha_usuario());

            rs = pst.executeQuery();

            if (rs.next()) {
                String perfil = rs.getString(5);
                System.out.println(perfil);

                if (perfil.equals("admin")) {
                    TelaPrincipal pr = new TelaPrincipal();
                    pr.setVisible(true);
                    TelaPrincipal.MenuRel.setEnabled(true);
                    TelaPrincipal.subMenuUsuarios.setEnabled(true);
                    TelaPrincipal.lblUsuarioPrincipal.setText(rs.getString(2));
                    TelaPrincipal.lblUsuarioPrincipal.setForeground(Color.RED);
                    conexao.close();
                } else {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    principal.lblUsuarioPrincipal.setText(rs.getString(2));
                    TelaPrincipal.lblUsuarioPrincipal.setForeground(Color.BLUE);
                    conexao.close();

                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "** tela login ***" + e);
        }
    }

    public void inserirUsuario(UsuarioDTO objUsuarioDTO) {
        String sql = "insert into tb_usuario (id_usuario, usuario, login,senha, perfil)"
                + "values (?,?,?,?,?)";
        conexao = new ConexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            pst.setString(2, objUsuarioDTO.getNome_usuario());
            pst.setString(3, objUsuarioDTO.getLogin_usuario());
            pst.setString(4, objUsuarioDTO.getSenha_usuario());
            pst.setString(5, objUsuarioDTO.getPerfil_usuario());
            int add = pst.executeUpdate();
            if (add > 0) {

                PesquisaAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + e);
        }

    }

    public void pesquisar(UsuarioDTO objUsuarioDTO) {
        String sql = "SELECT * FROM tb_usuarios WHERE id_usuario = ?";
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Conecta ao banco
            conexao = ConexaoDAO.conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            rs = pst.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) UsuarioForm.TbUsuarios.getModel();
            modelo.setRowCount(0); 

            // Preenche a tabela
            if (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_usuario"),
                    rs.getString("nome_usuario"),
                    rs.getString("login_usuario"),
                    rs.getString("senha_usuario"),
                    rs.getString("perfil_usuario")
                });
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no método pesquisar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void PesquisaAuto() {
        String sql = "select * from tb_usuarioss";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) UsuarioForm.TbUsuarios.getModel();
            model.setNumRows(0);
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("usuario");
                String login = rs.getString("senha");
                String senha = rs.getString("senha");
                String perfil = rs.getString("perfil");
                model.addRow(new Object[]{id, nome, login, senha, perfil});

            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método Pesquisar Automático " + e);
        }
    }

    public void deletar(UsuarioDTO objUsuarioDTO) {
        String sql = "delete from tb_usuarios where id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                PesquisaAuto();
                conexao.close();
                limparCampos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);

        }
    }

    public void limparCampos() {
        DefaultTableModel modelo = (DefaultTableModel) UsuarioForm.TbUsuarios.getModel();
        modelo.setRowCount(0);
    }

}
