<%-- 
    Document   : login
    Created on : 02/04/2017, 11:20:52
    Author     : Marcus Vinícius <vinimarcus02@gmail.com>
--%>

 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
   
  <html>
         <head>
               <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
               <title>Página de Login Customizado</title>
               
               <link href='<c:url value="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900"/>' rel='stylesheet prefetch' >
               <link href='<c:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700"/>' rel='stylesheet prefetch' >
               <link href='<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"/>' rel='stylesheet prefetch' >
               <link href='<c:url value="resources/css/style.css"/>' rel="stylesheet">
               
         </head>
         
         <body>
         
               <!-- HEADER -->
                             
               <div >
                      <ul class="nav">
                             
                             <sec:authorize access="authenticated" var="authenticated"/>
                             <c:choose>
                                          <c:when test="${authenticated}">
                                                 <li id="greeting">
                                                        <div>
                                                              Bem-vindo
                                                              <sec:authentication property="name" />
                                                        </div>
                                                 </li>
                                    
                                                 
                                          </c:when>
                                          
                             </c:choose>
                                    
                      </ul>
               </div>
                             
               
               
               <!-- FORMULÁRIO -->
               <div class="form">
                    <form class ="login-form" name="f" action="<c:url value='/fazerLogin'/>" method="post">
                            <div class="thumbnail"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg"/></div>
                           <c:if test="${param.error != null}">
                                  <div class="alert alert-error">
                                         Falha ao fazer Login.
                                         <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                                               Motivo: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                                         </c:if>
                                  </div>
                           </c:if>

                           <c:if test="${param.logout != null}">
                                  <div class="alert alert-success">
                                         Você efetuou log out.
                                  </div>
                           </c:if>

                           
                           <input type="text" id="j_username" name="j_username" placeholder="Usuário"/>
                           
                           <input type="password" id="j_password" name="j_password" placeholder="Senha"/>
                           <button>Login</button>
                           

                    </form>
               </div>
                
                <script src="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"/>"</script>
                <script src="resources/js/index.js"></script>

                             
         </body>
    </html>
