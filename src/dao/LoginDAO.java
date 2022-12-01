package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Login;
import util.Conexao;


public class LoginDAO {

	public void salvar(Login login) {

		String sql = "INSERT INTO login(usuario, senha)" + " VALUES(?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL(); 
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, login.getUsuario());
			pstm.setString(2, login.getSenha());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deletar(String usuario, String senha) {

		String sql = "DELETE FROM login WHERE usuario LIKE ? AND senha LIKE ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL(); 
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, senha);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void alterar(Login login, String usuario, String senha) {

		String sql = "UPDATE login SET usuario = ?, senha = ?" + " WHERE usuario LIKE ? AND senha LIKE ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, login.getUsuario());
			pstm.setString(2, login.getSenha());
			
			pstm.setString(3, usuario);
			pstm.setString(4, senha);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Login> listarLogins() {

		String sql = "SELECT * FROM login ORDER BY usuario";

		List<Login> logins = new ArrayList<Login>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Login login = new Login();

				login.setUsuario(rset.getString("usuario"));
				login.setSenha(rset.getString("senha"));

				logins.add(login);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logins;
	}

	public Login selecionarPorUmUsuario(String usuario) {

		Login login = null;

		String sql = "SELECT * FROM login WHERE usuario LIKE ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL();
			pstm = conn.prepareStatement(sql);			
			pstm.setString(1, usuario);
			rset = pstm.executeQuery();

			if(rset.next()) {

				login = new Login();
				login.setUsuario(rset.getString("usuario"));
				login.setSenha(rset.getString("senha"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}				
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return login;
	}

	public List<Login> selecionarPorUsuario(String usuario) {

		List<Login> logins = new ArrayList<Login>();

		String sql = "SELECT * FROM login WHERE usuario LIKE ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + usuario + "%");			
			rset = pstm.executeQuery();

			while (rset.next()) {

				Login login = new Login();
				login.setUsuario(rset.getString("usuario"));
				login.setSenha(rset.getString("senha"));

				logins.add(login);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {			
				if (rset != null) {
					rset.close();
				}			
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logins;
	}

	public List<Login> selecionarDados() {

		Login login = null;
		List<Login> logines = new ArrayList<Login>();

		String sql = "SELECT * FROM login ORDER BY usuario";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL();
			pstm = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
			rset = pstm.executeQuery();

			while(rset.next()) {

				login = new Login();
				login.setUsuario(rset.getString("usuario"));
				login.setSenha(rset.getString("senha"));

				logines.add(login);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}				
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logines;
	}
	
	public Login acesso(Login login) {

		Login loginRetorno = null;
		
		String sql = "SELECT * FROM login WHERE usuario LIKE ? AND senha LIKE ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToPostgreSQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, login.getUsuario());
			pstm.setString(2, login.getSenha());
			
			rset = pstm.executeQuery();

			if(rset.next()) {

				loginRetorno = new Login();
				loginRetorno.setUsuario(rset.getString("usuario"));
				loginRetorno.setSenha(rset.getString("senha"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginRetorno;
	}

}
