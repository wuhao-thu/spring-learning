package my.test.spring.hibernate.dao.impl;

import my.test.spring.hibernate.dao.AccountDao;
import my.test.spring.hibernate.entities.Account;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertAccount(Account account) {
        hibernateTemplate.saveOrUpdate(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateAccount(Account account) {
        hibernateTemplate.saveOrUpdate(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteAccount(Integer id) {
        Account account = hibernateTemplate.get(Account.class, id);
        hibernateTemplate.delete(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteAccount(String username) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("DELETE FROM Account a WHERE a.username = :username").setParameter("username", username);
        query.executeUpdate();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Account getAccountById(Integer id) {
        return hibernateTemplate.get(Account.class, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Account getAccountByUsername(String username) {
        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("FROM Account where username= :name").setParameter("name", username);
        return (Account) query.getSingleResult();
    }


}
