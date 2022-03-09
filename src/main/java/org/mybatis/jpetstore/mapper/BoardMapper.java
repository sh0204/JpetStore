package org.mybatis.jpetstore.mapper;

import org.mybatis.jpetstore.domain.Board;
import org.mybatis.jpetstore.domain.Mating;

import java.util.List;

public interface BoardMapper {

    Board getBoard(int boardId);

    List<Board> getBoardList();

    void insertBoard(Board board);

}