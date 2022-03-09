package org.mybatis.jpetstore.service;

import org.mybatis.jpetstore.domain.Board;
import org.mybatis.jpetstore.domain.Mating;
import org.mybatis.jpetstore.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public Board getBoard(int boardId) {
        return boardMapper.getBoard(boardId);
    }

    public List<Board> getBoardList() {
        return boardMapper.getBoardList();
    }

    @Transactional
    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

}