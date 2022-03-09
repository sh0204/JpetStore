<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink" ><stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
    Return to Main Menu</stripes:link></div>

<div id="Popular" style="text-align: center;">
<h2>Popular Pets</h2>
<table style="margin-left: auto; margin-right: auto;">
    <tr>
        <th>ItemId</th>
        <th>Description</th>
        <th>Quantity</th>
    </tr>

    <c:forEach var="popular" items="${actionBean.popularList}">
        <tr>
            <td><stripes:link
                    beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean"
                    event="viewItem">
                <stripes:param name="itemId" value="${popular.itemId}" />
                ${popular.itemId}
            </stripes:link></td>
            <td>
                ${popular.attr1}
                ${popular.attr2}
                ${popular.attr3}
                ${popular.attr4}
                ${popular.attr5}
                ${popular.name}
            </td>
            <td>${popular.num}</td>
        </tr>
    </c:forEach>
</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>