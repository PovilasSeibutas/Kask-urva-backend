package lt.daivospakalikai.academysurvey.Survey;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

    @Query("select survey.* from survey JOIN answer ON answer.survey_id = survey.id JOIN question ON question.id = answer.question_id")
    Survey getAllSurveysWithQuestionsAndAnswers();

}
