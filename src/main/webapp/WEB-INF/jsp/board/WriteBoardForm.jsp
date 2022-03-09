<%@ include file="../common/IncludeTop.jsp"%>

<div id="Board" style="text-align: center;">
    <stripes:form
        beanclass="org.mybatis.jpetstore.web.actions.BoardActionBean"
        focus="">

    <h3 style="text-align:center;"> Board </h3>

    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <td>writer</td>

            <td>${actionBean.username}</td>
        </tr>
        <tr>
            <td>title</td>
            <td><stripes:text name="board.title" /></td>
        </tr>
        <tr>
            <td>content</td>
            <td>
                <stripes:textarea rows="15" cols="65" name="board.content" />
            </td>
        </tr>
    </table>

    <stripes:submit name="newBoard" value="submit" />

</stripes:form></div>

<%@ include file="../common/IncludeBottom.jsp"%>