package DAO;

import DTO.UsuarioDTO;
import VIEW.TelaPrincipal;
import VIEW.UsuarioForm;
import com.sun.prism.paint.Color;
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

    public void logar(UsuarioDTO objUsuarioDTO) throws SQLException {
        String sql = "select * from tb_usuarios  where login = ? and senha = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objUsuarioDTO.getLogin_usuario());
            pst.setString(2, objUsuarioDTO.getSenha_usuario());

            rs = pst.executeQuery();
            if (rs.next()) {
                String perfil = rs.getString(5);
                System.out.println(perfil);

                if (perfil.equals("admin")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.MenuRel.SetEnabled(true);
                    TelaPrincipal.subMenuUsuarios.setEnabled(true);
                    TelaPrincipal.lblUsuarioPrincipal.setText(rs.getString(2));
                    TelaPrincipal.lblUsuarioPrincipal.setForeground(Color.RED);
                    conexao.close();;

                } else {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    principal.lblUsuarioPrincipal.setText(rs.getString(2));
                    TelaPrincipal.lblUsuarioPrincipal.setForeground(Color.BLUE);
                    conexao.close();
                }
            } else {
                JOptionPane.showConfirmDialog(null, "** Tela de Login***" + e);

            }
        } catch (Exception e) {

        }
    }

    public void inserirUsuario(UsuarioDTO objUsuarioDTO) throws SQLException {
        String sql = "insert into tb_usuarios (id_usuario, usuario, login, senha, perfil)"
                + " values (?, ?, ?, ?, ?)";
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
                pesquisaAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso! ");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Método inserir " + e);
        }

    }

    public void pesquisar(UsuarioDTO objUsuarioDTO) {
        String sql = "select * from tb_usuarios where id_usuario = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            rs = pst.executeQuery();
            if (rs.next()) {
                UsuarioForm.txtNomeUsu.setText(rs.getString(2));
                UsuarioForm.txtLoginUsu.setText(rs.getString(3));
                UsuarioForm.txtSenhaUsu.setText(rs.getString(4));
                UsuarioForm.cboPerfilUsu.setSelectedItem(rs.getString(5));
                conexao.close();

            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                limpaeCampos();

            }

        } catch (Exceptio e) {
            JOptionPane.showMessageDialog(null, "Método pesquisar " + e);
        }
    }

    public void pesquisaAuto() {
        String sql = "select from * tb_usuarios";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) UsuarioForm.TbUsuarios.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("usuario");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String perfil = rs.getString("perfil");
                model.addRow(new Object [] {id, nome, login, senha, perfil});
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método pesquisar automático " + e);
        }

    }

    public void editar(UsuarioDTO objUsuarioDTO) {
        String sql = "update tb_usuarios set usuario = ?, login = ?, senha = ?, "
                + "perfil = ? where id_usuario = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(5, objUsuarioDTO.getId_usuario());
            pst.setString(4, objUsuarioDTO.getPerfil_usuario());
            pst.setString(3, objUsuarioDTO.getSenha_usuario());
            pst.setString(2, objUsuarioDTO.getLogin_usuario());
            pst.setString(1, objUsuarioDTO.getNome_usuario());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Método deletar " + e);
          }
        }
    
    public void limparCampos() {
        UsuarioForm.txtIdUsu.setText(null);
        UsuarioForm.txtLoginUsu.setText(null);
        UsuarioForm.txtNomeUsu.setText(null);
        UsuarioForm.txtSenhaUsu.setText(null);
        UsuarioForm.cboPerfilUsu.setSelectedItem(1);
    }

}
