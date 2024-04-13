package com.timnjonjo.cards.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

    @Query("SELECT c FROM Card c WHERE c.id=:id AND c.createdBy.id=:userId and c.deleted=false")
    Optional<Card> findByIdAndUserId(String id, String userId);
}
