<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="manageadminavatar" scope="session" class="fr.paris.lutece.plugins.adminavatar.web.AdminAvatarJspBean" />

<% manageadminavatar.init( request, manageadminavatar.RIGHT_MANAGEADMINAVATAR ); %>
<%= manageadminavatar.getAdminAvatar ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>
