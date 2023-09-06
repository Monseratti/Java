package com.booking.repo;

import com.booking.models.BookingUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<BookingUser, Long> {
}
