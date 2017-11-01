package com.niit.CollaborationBackEnd.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.Dao.FriendDao;
import com.niit.CollaborationBackEnd.model.Friend;

@Transactional
@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {

	private SessionFactory sessionFactory;

	public FriendDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean insertFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Friend getFriend(int friendId, int userId) {
		return (Friend) sessionFactory.getCurrentSession()
				.createQuery("from Friend where friend.userId='" + userId + "' and user.userId='" + friendId + "'")
				.uniqueResult();
	}

	public List<Friend> getFriendsByUser_userId(int userId) {
		return (List<Friend>) sessionFactory.getCurrentSession()
				.createQuery("from Friend where friend.userId='" + userId + "' and Status='Confirm'")
				.list();
	}

	public List<Friend> getRequestByUser_friendRequest(int userId) {
		return (List<Friend>) sessionFactory.getCurrentSession()
				.createQuery("from Friend where user.userId='" + userId
						+ "' and Status='new' and initiator='0'")
				.list();
	}

	public List<Friend> getSentRequestByUser_userId(int userId) {
		return (List<Friend>) sessionFactory.getCurrentSession()
				.createQuery("from Friend where user.userId='" + userId
						+ "' and Status='new' and initiator='1'")
				.list();
	}

}
