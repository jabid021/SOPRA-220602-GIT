package dao;

import java.util.List;

public interface IDAO<T,K> {
	
	
	public T findById(K id);
	public List<T> findAll();
	public T insert(T o);
	public T save(T o);
	public void delete(K id);

}
