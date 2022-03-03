package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookList;


/**
 *@author roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Feb 24, 2022
 */
public class BookListHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebShoppingListwithShoppers");
	
	public void insertAuthor(BookList li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<BookList> showAllAuthor(){
		EntityManager em = emfactory.createEntityManager();
		List<BookList> allAuthors = em.createQuery("SELECT i from ListAuthor i").getResultList();
		return showAllAuthor();
		
	}

	public void deleteAuthor(BookList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookList> typedQuery = em.createQuery("select bl from BookList bl where bl.name = :selectedName and bl.author = :selectedItem", BookList.class);
		
		typedQuery.setParameter("selectedName", toDelete.getTitle());
		typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
		
		typedQuery.setMaxResults(1);
		
		BookList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public BookList searchForAuthorById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		BookList found = em.find(BookList.class, idToEdit);
		em.close();
		return found;
	}

	public void updateAuthor(BookList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<BookList> searchForItemByName(String bookName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookList> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore", BookList.class);
		
		typedQuery.setParameter("selectedStore", bookName);
		
		List<BookList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<BookList> searchForItemByAuthor(String authorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<BookList> typedQuery = em.createQuery("select bl from BookList bl where bl.author = :selectedAuthor", BookList.class);
		
		typedQuery.setParameter("selectedAuthor", authorName);
		
		List<BookList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}

