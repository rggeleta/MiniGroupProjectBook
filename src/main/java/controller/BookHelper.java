package controller;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BookList;

/**
 *@author roman-rggeleta@dmacc.edu
 *CIS175-Spring 2022
 *Feb 27, 2022
 */
public class BookHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookList");
		public void InsertItem(Book li) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(li);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Book>showAllItems() {
			EntityManager em = emfactory.createEntityManager();
			List<Book>allItems = em.createQuery("SELECT i FROM Book i").getResultList();
			return allItems;
		}
		
		public void deleteAuthor(BookList toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Book> typedQuery = em.createQuery("select bl from BookList bl where bl.name = :selectedName and bl.author = :selectedItem", Book.class);
			
			typedQuery.setParameter("selectedName", toDelete.getTitle());
			typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
			
			typedQuery.setMaxResults(1);
			
			Book result = typedQuery.getSingleResult();
			
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}

		/**
		 * @param toEdit
		 */
		public void updateItem(Book toEdit) {
			// TODO Auto-generated method stub
			EntityManager em =emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
			
		}

		/**
		 * @param idToEdit
		 * @return
		 */
		public Book searchForItemById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			Book found = em.find(Book.class, idToEdit);
			em.close();
			return found;
		}

		/**
		 * @param storeName
		 * @return
		 */
		public List<Book> searchForItemByStore(String storeName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Book>typedQuery  = em.createQuery("select li from Book li where li.store = :selectedStore", Book.class);
			typedQuery.setParameter("selectedStore",storeName);
			
			List<Book>foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}

		/**
		 * @param itemName
		 * @return
		 */
		public List<Book> searchForItemByItem(String itemName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Book>typedQuery = em.createQuery("select li from Book li where li.item =:selectedItem",Book.class);
			typedQuery.setParameter("selectedItem",itemName);
			
			List<Book>foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public void cleanUp() {
			emfactory.close();
		}
		
		

	}

