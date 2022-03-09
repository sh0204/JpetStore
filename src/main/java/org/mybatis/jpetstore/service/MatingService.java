package org.mybatis.jpetstore.service;

import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Mating;
import org.mybatis.jpetstore.mapper.MatingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MatingService {

    private final MatingMapper matingMapper;

    public MatingService(MatingMapper matingMapper) {
        this.matingMapper=matingMapper;
    }

    public Mating getMating(int matingId) { return matingMapper.getMating(matingId);}

    public List<Mating> getMatingList(String type){
        return matingMapper.getMatingList(type);
    }

    public int matingLastInsert() { return matingMapper.matingLastInsert(); }

    @Transactional
    public void insertMating(Mating mating) { matingMapper.insertMating(mating); }

    public void delMating(int matingId) { matingMapper.delMating(matingId); }

    public void editMating(Mating mating) { matingMapper.editMating((mating)); }

    public void insertPath(Mating mating) { matingMapper.insertPath(mating); }

}
