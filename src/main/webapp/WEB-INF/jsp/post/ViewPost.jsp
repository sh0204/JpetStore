<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp"%>

<div id="Post" style="">
    <h3>Post</h3>

    <table>
        <tr>
            <td >receiveUser</td>
            <td>${actionBean.post.receiveUser}</td>

        </tr>
        <tr>
            <td >title</td>
            <td width="500px" style="word-break:break-all">${actionBean.post.title}</td>
        </tr>
        <tr>
            <td >content</td>
            <td width="500px" style="word-break:break-all">${actionBean.post.content}</td>
        </tr>
    </table>

    <stripes:link class="Button"
                  beanclass="org.mybatis.jpetstore.web.actions.PostActionBean"
                  event="listReceive">
        Back to ReceiveList
    </stripes:link>

    <stripes:link class="Button"
                  beanclass="org.mybatis.jpetstore.web.actions.PostActionBean"
                  event="listPost">
        Back to SendList
    </stripes:link>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>