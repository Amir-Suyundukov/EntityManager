package ru.suyundukov.MyProject.others;

import org.hibernate.Session;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;
import ru.suyundukov.MyProject.entity.Person;
import ru.suyundukov.MyProject.entity.UniqueId;

public class UniqueIdGenerator implements IdentifierGenerator {

    @Override
    public String generateValue(Session session, Object owner) {
        Person person = (Person) owner;
        UniqueId type = person.getType();

        String prefix = type.getUnique();

        String queryStr = "SELECT COALESCE(MAX(CAST(SUBSTRING(p.uniqueId, LENGTH(:prefix) + 2) AS int)), 0) " +
                "FROM Person p WHERE p.type = :prefix";

        Query<Integer> query = session.createQuery(queryStr, Integer.class);
        query.setParameter("prefix", prefix);

        Integer maxId = query.getSingleResult();

        return prefix + "-" + (maxId + 1);
    }

}
