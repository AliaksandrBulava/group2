package by.jmp.module16.dao;

import by.jmp.module16.domain.Personal;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public interface PersonalDao {
    Personal create(Personal personal);
    Personal get(Long id);
    void delete(Long id);
    Personal update(Personal personal);
    void close();
}
