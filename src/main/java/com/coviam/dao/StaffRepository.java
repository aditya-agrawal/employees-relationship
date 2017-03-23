package com.coviam.dao;

import com.coviam.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aditya.
 */
@Repository
public interface StaffRepository extends CrudRepository<Staff, String> {
}
