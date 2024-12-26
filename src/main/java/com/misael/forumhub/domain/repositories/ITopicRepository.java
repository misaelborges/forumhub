package com.misael.forumhub.domain.repositories;

import com.misael.forumhub.domain.models.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findTop10ByOrderByCreationDateAsc(Pageable pageable);

    @Query("""
                SELECT t FROM Topic t 
                JOIN t.course c
                WHERE c.name = :nameCourse AND YEAR(t.creationDate) = :year
            """)
    List<Topic> findByCourseNameAndYear(String nameCourse, Integer year);

    Optional<Topic> findByTitleIgnoreCaseAndMessageIgnoreCase(String title, String message);
}