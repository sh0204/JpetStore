<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp"%>

<div id="Post" style="text-align: center;">
    <stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.PostActionBean"
        focus="">

    <h3>Post </h3>

    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <td>receiver</td>
            <td>${actionBean.post.receiveUser}</td>
        </tr>
        <tr>
            <td>title</td>
            <td><stripes:text name="post.title" /></td>
        </tr>
        <tr>
            <td>content</td>
            <td>
                <stripes:textarea rows="15" cols="65" name="post.content" />
            </td>
        </tr>
    </table>
    <stripes:submit name="newPost" value="submit" />

</stripes:form></div>

<%@ include file="../common/IncludeBottom.jsp"%>
