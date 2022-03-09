package org.mybatis.jpetstore.mapper;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Mating;

import java.util.List;

public interface MatingMapper {

    Mating getMating(int matingId);

    List<Mating> getMatingList(String type);

    void insertMating(Mating mating);

    void delMating(int matingId);

    void editMating(Mating mating);

    void insertPath(Mating mating);

    int matingLastInsert();
}
