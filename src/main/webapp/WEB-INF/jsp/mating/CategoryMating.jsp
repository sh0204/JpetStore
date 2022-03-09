<%@ include file="../common/IncludeTop.jsp"%>

<div id = "BackLink">
    <stripes:link
            beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
        Return to Main Menu</stripes:link></div>

<div id="header" style="text-align: center;">
<h2>Choose the type of pet</h2>
</div>

<div id="Main" style="text-align: center;">
<stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
        event="listMating">
    <stripes:param name="type" value="DOGS" />
    <img src="../images/mmdog.gif" />
</stripes:link>

<stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
        event="listMating">
    <stripes:param name="type" value="REPTILES" />
    <img src="../images/mmreptile.gif" />
</stripes:link>

<stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
        event="listMating">
    <stripes:param name="type" value="CATS" />
    <img src="../images/mmcat.gif" />
</stripes:link>

<stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
        event="listMating">
    <stripes:param name="type" value="BIRDS" />
    <img src="../images/mmbird.gif" />
</stripes:link>

<stripes:link
        beanclass="org.mybatis.jpetstore.web.actions.MatingActionBean"
        event="listMating">
    <stripes:param name="type" value="FISH" />
    <img src="../images/mmfish.gif" />
</stripes:link>
</div>


<%@ include file="../common/IncludeBottom.jsp"%>