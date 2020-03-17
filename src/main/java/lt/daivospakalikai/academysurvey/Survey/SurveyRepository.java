package lt.daivospakalikai.academysurvey.Survey;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    @Query("select survey.* from survey join answer on answer.survey_id = survey.id join question on question.id = answer.question_id")
    List<Survey> findByIdarea();

}
