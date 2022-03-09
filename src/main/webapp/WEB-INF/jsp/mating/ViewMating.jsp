<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="../common/IncludeTop.jsp"%>

<div id = "Tab">
    <div id = "Return">
        <stripes:link beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
                      event="listMating">
            Return to Mating List</stripes:link>
        <div id = "BackLink">
            <stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
                Return to Main Menu</stripes:link></div>
    </div>
</div>

<div id="Mating" style="text-align: center;">
    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <td>writer</td>
            <td>${actionBean.mating.username}</td>
        </tr>
        <tr>
            <td>title</td>
            <td width="500px" style="word-break:break-all">${actionBean.mating.title}</td>
        </tr>
        <tr>
            <td>Breed</td>
            <td width="500px" style="word-break:break-all">
                ${actionBean.mating.species}</td>
        </tr>
        <tr>
            <td>sex</td>
            <td width="500px" style="word-break:break-all">
                ${actionBean.mating.sex}</td>
        </tr>

        <tr>
            <td>age</td>
            <td width="500px" style="word-break:break-all">
                ${actionBean.mating.age}</td>
        </tr>

        <tr>
            <td>picture</td>
            <td><c:if test="${actionBean.mating.path != null}">
                <img src="${pageContext.request.contextPath}${actionBean.mating.path}" height="355" width="355"/>
            </c:if></td>
        </tr>

        <tr>
            <td>content</td>
            <td width="500px" style="word-break:break-all">${actionBean.mating.content}</td>
        </tr>
    </table>

    <c:if test="${sessionScope.accountBean.username != actionBean.mating.username}">
        <stripes:link class="Button"
                      beanclass="org.mybatis.jpetstore.web.actions.PostActionBean"
                      event="writePostForm">
            <stripes:param name="receiveUser" value="${actionBean.mating.username}"/>
            Post Message
        </stripes:link>
    </c:if>
    <c:if test="${sessionScope.accountBean.username == actionBean.mating.username}">
        <stripes:link class="Button"
                      beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
                      event="delMating">
            <stripes:param name="matingID" value="${mating.matingID}"/>
            Delete
        </stripes:link>
        <stripes:link class="Button"
                      beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
                      event="editMatingForm">
            Edit
        </stripes:link>
    </c:if>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>