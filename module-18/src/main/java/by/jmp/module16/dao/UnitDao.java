package by.jmp.module16.dao;

import by.jmp.module16.domain.Unit;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public interface UnitDao {
    Unit create(Unit unit);
    Unit get(Long id);
    void delete(Long id);
    Unit update(Unit unit);
    void close();
}
