package org.mybatis.jpetstore.service;

import org.mybatis.jpetstore.domain.Post;
import org.mybatis.jpetstore.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostMapper postMapper;

    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public Post getPost(int idx) {
        return postMapper.getPost(idx);
    }

    public List<Post> getPostList(String sendUser) {
        return postMapper.getPostList(sendUser);
    }

    public List<Post> getReceiveList(String receiver) { return postMapper.getReceiveList(receiver); }

    public int getPostchk(String receiver) { return postMapper.getPostchk(receiver); }

    @Transactional
    public void insertPost(Post post) {
        postMapper.insertPost(post);
    }

    @Transactional
    public void updateStatus(int idx){ postMapper.updateStatus(idx); }


    public void delPost(int idx) {
        postMapper.delPost(idx);
    }

    public void updateSend(int idx) {
        postMapper.updateSend(idx);
    }

    public void updateRecv(int idx) {
        postMapper.updateRecv(idx);
    }
}
