package com.servlet;

import com.entities.Note;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Date;

public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            int id = Integer.parseInt(req.getParameter("noteId").trim());

            Session sess = FactoryProvider.getFactory().openSession();
            Transaction tx = sess.beginTransaction();

            Note note = sess.get(Note.class, id);
            note.setTitle(title);
            note.setContent(content);
            note.setAddedDate(new Date());
            tx.commit();
            sess.close();

            resp.sendRedirect("all_notes.jsp");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
