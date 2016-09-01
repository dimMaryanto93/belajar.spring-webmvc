<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springf" %>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<spring:url value="/webjars/materializecss/0.97.5/css/materialize.min.css" var="materializecss"/>
<spring:url value="/webjars/jquery/3.1.0/jquery.min.js" var="jquery"/>
<spring:url value="/webjars/materializecss/0.97.5/js/materialize.min.js" var="materializejs"/>

<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
<link type="text/css" rel="stylesheet" href="${materializecss}" media="screen,projection" />

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${materializejs}"></script>
