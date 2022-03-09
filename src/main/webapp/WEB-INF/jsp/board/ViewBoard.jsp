<%@ include file="../common/IncludeTop.jsp"%>
<div id = "Tab">
    <div id = "Return">
        <stripes:link beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean"
                      event="listBoard">
            Return to Board List</stripes:link>
        <div id = "BackLink">
            <stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
                Return to Main Menu</stripes:link></div>
    </div>
</div>
<div id="Board" style="text-align: center;">
    <h3>Board</h3>

    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <td >writer</td>
            <td>${actionBean.board.username}</td>

        </tr>
        <tr>
            <td >title</td>
            <td width="500px" style="word-break:break-all">${actionBean.board.title}</td>
        </tr>
        <tr>
            <td >content</td>
            <td width="500px" style="word-break:break-all">${actionBean.board.content}</td>
        </tr>
    </table>


</div>

<%@ include file="../common/IncludeBottom.jsp"%>