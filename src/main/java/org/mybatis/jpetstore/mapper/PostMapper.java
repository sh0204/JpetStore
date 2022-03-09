package org.mybatis.jpetstore.mapper;

import org.mybatis.jpetstore.domain.Post;

import java.util.List;

public interface PostMapper {

    Post getPost(int idx);

    List<Post> getPostList(String sendUser);

    List<Post> getReceiveList(String receiver);

    int getPostchk(String receiver);

    void insertPost(Post post);

    void updateStatus(int idx);

    void delPost(int idx);

    void updateSend(int idx);

    void updateRecv(int idx);
}
