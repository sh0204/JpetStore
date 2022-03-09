package org.mybatis.jpetstore.web.actions;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;
import org.mybatis.jpetstore.domain.Board;
import org.mybatis.jpetstore.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@SessionScope
public class BoardActionBean extends AbstractActionBean {

    // private static final long serialVersionUID = L;

    private static final String NEW_BOARD = "/WEB-INF/jsp/board/WriteBoardForm.jsp";
    private static final String LIST_BOARD = "/WEB-INF/jsp/board/ListBoard.jsp";
    private static final String VIEW_BOARD = "/WEB-INF/jsp/board/ViewBoard.jsp";

    @SpringBean
    private transient BoardService boardService;

    private Board board = new Board();
    private int boardId;
    private String username;
    private String title;
    private String content;
    private List<Board> boardList;

    public Board getBoard() { return this.board; }

    public int getBoardId() { return board.getBoardId(); }

    public void setBoardId(int boardId) { this.boardId = boardId; }

    public String getTitle() { return board.getTitle();}

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return board.getContent();}

    public void setContent(String content) { this.content = content; }

    public List<Board> getBoardList() { return boardList; }

    public void setBoardList(List<Board> boardList) { this.boardList = boardList; }

    public String getUsername() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        return accountBean.getUsername();
    }

    public void setUsername() { board.setUsername(getUsername()); }

    /**
     * List board.
     *
     * @return the resolution
     */


    public Resolution listBoard() {
        boardList = boardService.getBoardList();

        return new ForwardResolution(LIST_BOARD);
    }

    /**
     * View board.
     *
     * @return the resolution
     */

    public Resolution viewBoard() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        clear();

        if (accountBean == null ||!accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        } else {
            Integer val = boardId;
            System.out.println(boardId);
            if (val != null) {
                board = boardService.getBoard(boardId);
            }
            System.out.println("after " + board.getBoardId() + " " +
                    board.getUsername() + " " + board.getTitle() + " " +
                    board.getContent());
            return new ForwardResolution(VIEW_BOARD);
        }
    }

    /**
     * New write form.
     *
     * @return the resolution
     */

    public Resolution writeBoardForm() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        clear();

        if (accountBean == null ||!accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        } else {
            return new ForwardResolution(NEW_BOARD);
        }
    }
    /**
     * New board.
     *
     * @return the resolution
     */
    public Resolution newBoard() {
        setUsername();
        if(board.getTitle()==null||board.getContent()==null){
            setMessage("You must write the content and title.\n" +
                    "Please post and try checking your text.");
            return new ForwardResolution(NEW_BOARD);
        }

        boardService.insertBoard(board);
        boardList = boardService.getBoardList();
        return new ForwardResolution(LIST_BOARD);
    }

    public void clear() {
        board = new Board();
        boardList = null;
    }


}