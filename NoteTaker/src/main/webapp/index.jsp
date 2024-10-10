<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>TODO</title>
    <%@include file = "all_js_css.jsp" %>

  </head>
  <body>
    <div class = "container">
        <%@include file = "navbar.jsp" %>
        <br>
        <div class="card py-5">
            <img alt="" class="container mx-auto" style="width:500px;" src="Image/note.png" >
            <h1 class="text-primary text-uppercase text-center mt-3">Start Taking Your Notes</h1>
            <div class="container text-center">
               <a href="add_notes.jsp">
                   <button class="btn btn-outline-primary text-center">Start Here</button>
               </a>
            </div>
        </div>
    </div>


  </body>
</html>