<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="org.hibernate.*"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="com.entities.Note"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit</title>
    <%@include file = "all_js_css.jsp" %>
</head>
<body>
    <div class = "container">
            <%@include file = "navbar.jsp" %>
            <br>
            <h1>Edit your note</h1>
            <br>
            <%
                 int noteId = Integer.parseInt(request.getParameter("note_id").trim());
                 Session se = FactoryProvider.getFactory().openSession();
                 Note note = (Note) se.get(Note.class, noteId);


                se.close();

            %>
             <!-- This is add form -->
                    <form action="UpdateServlet" method="post">
                    <input value="<%= note.getId() %>" name="noteId" type="hidden" />
                      <div class="form-group">
                        <label for="title">Note title</label>
                        <input
                        name="title"
                        required
                         type="text"
                         class="form-control"
                         id="title"
                         aria-describedby="emailHelp"
                         placeholder="Enter title"
                         value="<%= note.getTitle() %>"
                         />

                      </div>
                      <div class="form-group">
                        <label for="content" >Note Content</label>
                        <textarea
                        name="content"
                        required id="note-content"
                            placeholder="Enter your content here"
                            class="form-control"
                            style="height:300px;"
                            <%= note.getContent() %>
                            >
                        </textarea>
                      </div>
                      <div class="container text-center" >
                        <button type="submit" class="btn btn-success">Save your note</button>
                      </div>
                    </form>

        </div>
</body>
</html>
