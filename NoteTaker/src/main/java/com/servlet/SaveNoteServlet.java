package com.servlet;

import com.entities.Note;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // fetching title and content from form
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            Note note = new Note(title, content, new Date());

            Session session = FactoryProvider.getFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(note);
            tx.commit();
            session.close();
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<h2 style='text-align:center;'>Note added successfully!</h2>");
            writer.println("<h2 style='text-align:center;'><a href='all_notes.jsp'>View all notes</h2>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
