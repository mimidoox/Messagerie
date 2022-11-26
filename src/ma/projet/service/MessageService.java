package ma.projet.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.connexion.Connexion;
import ma.projet.idao.IDao;

public class MessageService implements IDao<Message>{
	private EmployeService es;
	
	
	public MessageService() {
		
		this.es = new EmployeService();
	}

	@Override
	public boolean create(Message o) {
		// TODO Auto-generated method stub
		try {
			String req="insert into message values(null,?,?,?,?,?)";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ps.setInt(1,o.getEmpEmetteur().getId());
			ps.setInt(2,o.getEmpRecepteur().getId());
			ps.setString(3, o.getObject());
			ps.setString(4, o.getSujet());
			ps.setDate(5, new Date(o.getDate().getTime()));
			
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
	public boolean update(Message o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Message o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Message getById(int id) {
		// TODO Auto-generated method stub
		Message msg=null;
		try {
			String req="select * from message where id = ? ";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				msg = new Message(rs.getInt("id"), rs.getString("object"), rs.getString("sujet"),rs.getDate("date"),es.getById(rs.getInt("empEmetteur")),es.getById(rs.getInt("empRecepteur")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, e);
		}
		return msg;
	}

	@Override
	public List<Message> getAll() {
		// TODO Auto-generated method stub
		List<Message> messages = new ArrayList<Message>(null);
		try {
			String req="select * from message ";
			PreparedStatement ps=Connexion.getConnexion().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				messages.add(new Message(rs.getInt("id"), rs.getString("object"), rs.getString("sujet"),rs.getDate("date"),es.getById(rs.getInt("empEmetteur")),es.getById(rs.getInt("empRecepteur"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmployeService.class.getName()).log(Level.SEVERE, null, e);
		}
		return messages;
	}

}
