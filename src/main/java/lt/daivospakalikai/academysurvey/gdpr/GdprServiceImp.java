package lt.daivospakalikai.academysurvey.gdpr;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GdprServiceImp implements GdprService {

  @Autowired
  private GdprRepository gdprRepository;

  @Override
  public List<Gdpr> getAllGdrpAgreements() {
    return gdprRepository.getAllAgreements();
  }

  @Override
  public Gdpr getGdprById(Gdpr gdpr) {
    return gdprRepository.getGdprById(gdpr);
  }

  @Override
  public void createGdpr(Gdpr gdpr) {
    gdprRepository.createGdpr(gdpr);
  }
}
