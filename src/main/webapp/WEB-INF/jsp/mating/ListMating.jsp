<%@ include file="../common/IncludeTop.jsp"%>

<div id = "Tab">
    <div id = "Return">
        <stripes:link beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
                      event="categoryMating">
            Return to Previous Page</stripes:link>
        <div id = "BackLink">
            <stripes:link
                beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
            Return to Main Menu</stripes:link></div>
    </div>
</div>


<div id="Mating" style="text-align: center;">
    <stripes:link class="Button"
                  beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
                  event="writeMatingForm">
        Post
    </stripes:link>
    <br>
    <table style="margin-left: auto; margin-right: auto;">
        <tr>
            <th>Writer</th>
            <th>Title</th>
            <th>Breed</th>
            <th>Sex</th>
            <th>Age</th>
        </tr>
        <c:forEach var="mating" items="${actionBean.matingList}">
            <tr>
                <td>${mating.username}</td>
                <td><stripes:link
                        beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
                        event="viewMating">
                    <stripes:param name="matingId" value="${mating.matingId}" />
                    ${mating.title}
                </stripes:link></td>
                <td>${mating.species}</td>
                <td>${mating.sex}</td>
                <td>${mating.age}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>