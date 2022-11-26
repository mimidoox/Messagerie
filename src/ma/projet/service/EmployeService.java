package ma.projet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ma.projet.beans.Employe;
import ma.projet.connexion.Connexion;
import ma.projet.idao.IDao;

public class EmployeService implements IDao<Employe>{

	@Override
	public boolean create(Employe o) {
		// TODO Auto-generated method stub
		try {
			String req="insert into employe(nom,prenom) values(?,?)";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
		
	}

	@Override
	public boolean update(Employe o) {
		// TODO Auto-generated method stub
		try {
			String req="update employe set nom = ? , prenom = ? where id = ? ";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setInt(3, o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public boolean delete(Employe o) {
		// TODO Auto-generated method stub
		try {
			String req="delete from employe where id = ? ";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ps.setInt(1, o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
	}

	@Override
	public Employe getById(int id) {
		// TODO Auto-generated method stub
		Employe emp=null;
		try {
			String req="select * from employe where id = ? ";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				emp = new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, e);
		}
		return emp;
	}

	@Override
	public List<Employe> getAll() {
		// TODO Auto-generated method stub
		List<Employe> employes = new ArrayList<Employe>();
		try {
			String req="select * from employe  ";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				employes.add(new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, e);
		}
		return employes;
	}

}
