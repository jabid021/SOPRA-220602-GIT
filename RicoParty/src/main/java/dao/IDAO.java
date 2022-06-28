package dao;

import java.util.List;

import model.Compte;

public interface IDAO<T,K> {
	
	String urlBdd="jdbc:mysql://localhost:3306/eric-party";
	String loginBdd="root";
	String passwordBdd="";
	
	
	public T findById(K id);
	public List<T> findAll();
	public T save(T o);
	public void delete(K id);

}
