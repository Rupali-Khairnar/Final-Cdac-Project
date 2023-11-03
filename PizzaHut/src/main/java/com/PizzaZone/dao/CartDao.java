package com.PizzaZone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.PizzaZone.entities.Cart;
import com.PizzaZone.entities.DeliveryStatus;
import com.PizzaZone.entities.Users;

public interface CartDao extends JpaRepository<Cart, Integer>{
	@Query(value = "select * from cart where userid=?1 and cartstatus=?2 order by cartid desc;", nativeQuery = true)
	List<Cart> findByUserStatus(Users user,Integer status);
	@Query(value = "select sum(price*quantity) as totalamount from cart where userid=?1", nativeQuery = true)
	Double findTotalAmount(Integer userid);
	@Query(value = "update cart set cartstatus=0 where userId =?1", nativeQuery = true)
	@Modifying
	void changeStatus(Integer userId);
	@Modifying
	@Query(value = "update cart set deliveryId=?1 where userId =?2 and deliveryId is null", nativeQuery = true)
	Integer addForeign(Integer delid,Integer userid);
//	@Query(value= "")
	Cart findByDeliveryId(DeliveryStatus del);
	
	@Query(value="DELETE from cart where deliveryId=?1",nativeQuery = true)
	@Modifying
	void deleteByDeliveryId(Integer deliveryid);
}
