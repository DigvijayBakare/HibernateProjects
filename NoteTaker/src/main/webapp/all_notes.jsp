
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.Note"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Note taker: All notes</title>
    <%@include file = "all_js_css.jsp" %>

  </head>
  <body>

    <div class="container">
        <%@include file = "navbar.jsp" %>
        <br>
        <h1 class="text-uppercase">All Notes:</h1>
        <div class="row">
            <div class="col-12">
                <%
                            Session s = FactoryProvider.getFactory().openSession();
                            Query q = s.createQuery("from Note");
                            List<Note> list = q.list();
                            for (Note note : list) {
                            %>
                        <div class="card mt-3">
                          <img class="card-img-top m-4" style="max-width: 75px;" src="Image/notes.png" alt="Card image cap">
                          <div class="card-body px-5">
                            <h5 class="card-title"><%= note.getTitle() %></h5>
                            <p class="card-text">
                                <%= note.getContent()%>
                            </p>
                            <p><b class="text-primary">
                            <%
                                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("E, MMM dd yyyy");
                                java.time.LocalDate localDate = note.getAddedDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                                String formattedDate = localDate.format(formatter);
                            %>
                            <%= formattedDate %>
                            </b>
                            </p>
                            <a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
                            <a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">Update</a>
                          </div>
                        </div>

                    <%
                            }
                            s.close();
                        %>
            </div>
        </div>


    </div>




  </body>
  </html>