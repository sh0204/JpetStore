package org.mybatis.jpetstore.web.actions;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.mybatis.jpetstore.domain.Board;
import org.mybatis.jpetstore.domain.Post;
import org.mybatis.jpetstore.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.List;

@SessionScope
public class PostActionBean extends AbstractActionBean {

    // private static final long serialVersionUID = L;

    private static final String NEW_POST = "/WEB-INF/jsp/post/WritePostForm.jsp";
    private static final String LIST_POST = "/WEB-INF/jsp/post/listPostView.jsp"; // 보낸 쪽지함
    private static final String LIST_SEND = "/WEB-INF/jsp/post/listReceiveView.jsp"; // 받은 쪽지함
    private static final String VIEW_POST = "/WEB-INF/jsp/post/ViewPost.jsp";


    @SpringBean
    private transient PostService postService;

    private Post post = new Post();
    private int idx;
    private String sendUser;
    private String receiveUser;
    private String title;
    private String content;
    private char status;
    private String createdAt;
    private List<Post> postList;
    private int postSize;

    public Post getPost() { return post; }

    public void setPost(Post post) { this.post = post; }

    public int getIdx() {return idx;}

    public void setIdx(int idx) {this.idx = idx; }

    public String getSendUser() { return sendUser; }

    public void setSendUser(String sendUser) { this.sendUser = sendUser; }

    public String getReceiveUser() { return receiveUser; }

    public void setReceiveUser(String receiveUser) { this.receiveUser = receiveUser; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public char getStatus() { return status; }

    public void setStatus(char status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public List<Post> getPostList() { return postList; }

    public void setPostList(List<Post> postList) { this.postList = postList; }

    public int getPostSize() { return postSize; }

    public void setPostSize(int postSize) { this.postSize = postSize; }

    /**
     * List board.
     *
     * @return the resolution
     */

    @DefaultHandler
    public Resolution listReceive() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        if (accountBean == null || !accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        }

        postList = postService.getReceiveList(accountBean.getUsername());

        return new ForwardResolution(LIST_SEND);
    }

    public Resolution listPost() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        if (accountBean == null || !accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        }

        postList = postService.getPostList(accountBean.getUsername());

        return new ForwardResolution(LIST_POST);
    }

    /**
     * View board.
     *
     * @return the resolution
     */

    public Resolution viewPost() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        clear();

        if (accountBean == null ||!accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        } else {
            Integer val = idx;
            if (val != null) {
                post = postService.getPost(idx);
                if (!post.getSendUser().equals(accountBean.getUsername())&&post.getStatus() == 'N'){
                    postService.updateStatus(idx);
                }
                postSize = postService.getPostchk(accountBean.getUsername());
                if (postSize == 0){
                    accountBean.setHavePost(false);
                    session.setAttribute("accountBean",accountBean);
                }

            }
            return new ForwardResolution(VIEW_POST);
        }
    }

    /**
     * New write form.
     *
     * @return the resolution
     */

    public Resolution writePostForm() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        clear();

        post.setReceiveUser(receiveUser);

        if (accountBean == null ||!accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        } else {

            return new ForwardResolution(NEW_POST);
        }
    }

    /**
     * New board.
     *
     * @return the resolution
     */
    public Resolution newPost() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        if (post.getTitle() == null || post.getContent() == null){
            setMessage("You must write the content and title. Please post and try checking your text.");
            return new ForwardResolution(NEW_POST);
        }

        if (accountBean.getUsername().equals(post.getReceiveUser())){
            setMessage("You can't send post to yourself.");
            return new ForwardResolution(NEW_POST);
        }
        post.setSendUser(accountBean.getUsername());
        postService.insertPost(post);
        postList = postService.getReceiveList(post.getSendUser());
        return new ForwardResolution(LIST_SEND);
    }

    public void clear() {
        post = new Post();
        post = new Post();
        postList = null;
    }

    //보낸 쪽지 삭제 상태 변경
    public ForwardResolution updateSend() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        postService.updateSend(idx);
        postService.delPost(idx);

        postList = postService.getPostList(accountBean.getUsername());
        return new ForwardResolution(LIST_POST);
    }

    //받은 쪽지 삭제 상태 변경
    public ForwardResolution updateRecv() {
        postService.updateRecv(idx);
        postService.delPost(idx);
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        postSize = postService.getPostchk(accountBean.getUsername());
        if (postSize == 0){
            accountBean.setHavePost(false);
            session.setAttribute("accountBean",accountBean);
        }
        postList = postService.getReceiveList(accountBean.getUsername());
        return new ForwardResolution(LIST_SEND);
    }
}