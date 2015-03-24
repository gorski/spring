package com.trainings.basic;

import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 *
 */
@Repository
public class FakeRepository {

    /**
     * Generates fake name (UUID)
     * @param id
     * @return
     */
    public String findUserById(Long id) {

        throw new NullPointerException("Fake null pointer");
    }

}
