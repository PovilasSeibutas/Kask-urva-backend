package lt.daivospakalikai.academysurvey.gdpr;

import java.util.List;

public interface GdprService {

  List<Gdpr> getAllGdrpAgreements();

  Gdpr getGdprById(Gdpr gdpr);

  void createGdpr(Gdpr gdpr);

}
