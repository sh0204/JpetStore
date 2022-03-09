<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp"%>

<div id = "Tab">
    <div id = "Receive">
        <stripes:link beanclass="org.mybatis.jpetstore.web.actions.PostActionBean" event="listReceive">
            Received Notes</stripes:link>
        <div id = "BackLink"><stripes:link
                beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
            Return to Main Menu</stripes:link></div>
    </div>
    <div id = "Send">
        <stripes:link beanclass="org.mybatis.jpetstore.web.actions.PostActionBean" event="listPost">
            Send Notes
        </stripes:link>
    </div>
</div>

<div id="Post" style="text-align: center;">
    <br>
    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <th>Writer</th>
            <th>Title</th>
            <th>Date</th>
            <th>IsRead</th>
            <th>sendPost</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="post" items="${actionBean.postList}">
            <tr>
                <td>${post.sendUser}</td>
                <td><stripes:link
                        beanclass="org.mybatis.jpetstore.web.actions.PostActionBean"
                        event="viewPost">
                    <stripes:param name="idx" value="${post.idx}" />
                    ${post.title}
                </stripes:link></td>
                <td>${post.createdAt}</td>
                <td>${post.status}</td>
                <td><stripes:link class="Button"
                                  beanclass="org.mybatis.jpetstore.web.actions.PostActionBean"
                                  event="writePostForm">
                    <stripes:param name="receiveUser" value="${post.sendUser}"/>
                    Post
                </stripes:link></td>
                <td>
                    <stripes:link class="Button"
                                  beanclass="org.mybatis.jpetstore.web.actions.PostActionBean"
                                  event="updateRecv">
                        <stripes:param name="idx" value="${post.idx}" />
                        DELETE
                    </stripes:link>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>

