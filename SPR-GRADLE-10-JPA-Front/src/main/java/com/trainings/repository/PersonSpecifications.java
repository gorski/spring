package com.trainings.repository;
import com.trainings.model.Person;
import com.trainings.model.Person_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonSpecifications {


    public static Specification<Person> lastNameIsLike(final String searchTerm) {

        return new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> personRoot,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                String likePattern = getLikePattern(searchTerm);

                return cb.or(
                        cb.like(cb.lower(personRoot.<String>get(Person_.lastName)), likePattern),
                        cb.like(cb.lower(personRoot.<String>get(Person_.firstName)), likePattern));
            }

            private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append("%");
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
            }
        };
    }
}