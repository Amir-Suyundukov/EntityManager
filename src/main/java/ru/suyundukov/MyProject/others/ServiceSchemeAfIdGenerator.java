package ru.suyundukov.MyProject.others;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.math.BigInteger;

@Component
public class ServiceSchemeAfIdGenerator {
    @PersistenceContext
    private EntityManager entityManager;

    public String generatedAfId() {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.setHibernateFlushMode(FlushMode.COMMIT);
            Long id = ((BigInteger) session
                    .createNativeQuery("select nextval('service_scheme_af_id_seq')")
                    .getSingleResult()).longValue();
            session.setHibernateFlushMode(FlushMode.AUTO);
            return String.format("S0-%d", id);
        }
    }
}

