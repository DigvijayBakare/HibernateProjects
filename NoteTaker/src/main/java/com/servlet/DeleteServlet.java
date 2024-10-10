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

public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int noteId = Integer.parseInt(req.getParameter("note_id").trim());
            Session session = FactoryProvider.getFactory().openSession();
            Transaction tx = session.beginTransaction();
            Note note = (Note) session.get(Note.class, noteId);
            session.delete(note);
            tx.commit();
            session.close();
            resp.sendRedirect("all_notes.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
