package com.busdmv.testjson.servlet;

import com.busdmv.testjson.beans.Messages;
import com.busdmv.testjson.db.Database;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class WriteServlet extends HttpServlet {

    public WriteServlet() {

    }

    private static final boolean gson = true;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<Messages> messages = new ArrayList<>();
        messages = Database.getAllMessageses();

        if (gson) {
            // gson
            Gson gson = new Gson();
            JsonElement element = gson.toJsonTree(messages, new TypeToken<List<Messages>>() {
            }.getType());

            JsonArray jsonArray = element.getAsJsonArray();
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(jsonArray);
        } else {
            //json

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
