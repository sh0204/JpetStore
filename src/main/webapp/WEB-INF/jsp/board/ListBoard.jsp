<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink"><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
    Return to Main Menu</stripes:link></div>

<div id="Board" style="text-align: center;">
    <stripes:link class="Button"
                  beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean"
                  event="writeBoardForm">
        Post
    </stripes:link>
    <br>
    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <th>NO</th>
            <th>Writer</th>
            <th>Title</th>
        </tr>
        <c:forEach var="board" items="${actionBean.boardList}">
            <tr>
                <td>${board.boardId}</td>
                <td>${board.username}</td>
                <td><stripes:link
                        beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean"
                        event="viewBoard">
                    <stripes:param name="boardId" value="${board.boardId}" />
                    ${board.title}
                </stripes:link></td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>