package com.project.todoapp.data;

import android.database.Cursor;

import static com.project.todoapp.data.TaskContract.getColumnInt;
import static com.project.todoapp.data.TaskContract.getColumnLong;
import static com.project.todoapp.data.TaskContract.getColumnString;



public class Task {

    // Constante care reprezintă date lipsă
    public static final long NO_DATE = Long.MAX_VALUE;
    public static final long NO_ID = -1;

    //Identificator unic
    public long id;
    //Descrierea Task-ului
    public final String description;
    //Marcat daca task-ul e finalizat
    public final boolean isComplete;
    //Marcat daca task-ul e cu prioritate
    public final boolean isPriority;
    //Termen limita optional pentru Task
    public final long dueDateMillis;


    //Creaza task nou

    public Task(String description, boolean isComplete, boolean isPriority, long dueDateMillis) {
        this.id = NO_ID;
        this.description = description;
        this.isComplete = isComplete;
        this.isPriority = isPriority;
        this.dueDateMillis = dueDateMillis;
    }

     //Creaza task nou fara termen limita

    public Task(String description, boolean isComplete, boolean isPriority) {
        this(description, isComplete, isPriority, NO_DATE);
    }

    //Creaza task nou pentru cursorul bazei de date

    public Task(Cursor cursor) {
        this.id = getColumnLong(cursor, TaskContract.TaskColumns._ID);
        this.description = getColumnString(cursor, TaskContract.TaskColumns.DESCRIPTION);
        this.isComplete = getColumnInt(cursor, TaskContract.TaskColumns.IS_COMPLETE) == 1;
        this.isPriority = getColumnInt(cursor, TaskContract.TaskColumns.IS_PRIORITY) == 1;
        this.dueDateMillis = getColumnLong(cursor, TaskContract.TaskColumns.DUE_DATE);
    }

    //Returnează adevarat dacă a fost stabilit un termen limita pentru aceast task.

    public boolean hasDueDate() {
        return this.dueDateMillis != Long.MAX_VALUE;
    }

}

