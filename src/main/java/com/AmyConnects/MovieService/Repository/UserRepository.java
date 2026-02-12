package com.AmyConnects.MovieService.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByToken(String token);

    Optional<User> findByEmail(String email);
}
