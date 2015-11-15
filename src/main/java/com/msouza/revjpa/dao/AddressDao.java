package com.msouza.revjpa.dao;

import java.util.List;

import com.msouza.revjpa.entity.Address;

public class AddressDao extends GenericDao<Address> {

	public AddressDao() {
		super(Address.class);
	}

	public List<Address> findByCity(String city) {
		String jpql = "from Address a where a.city like ?";
		return find(jpql, city);
	}

}
