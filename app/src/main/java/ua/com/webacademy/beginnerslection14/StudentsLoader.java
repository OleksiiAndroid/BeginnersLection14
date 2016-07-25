package ua.com.webacademy.beginnerslection14;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class StudentsLoader extends AsyncTaskLoader<ArrayList<Student>> {

    private DataBaseHelper mDBHelper;

    public StudentsLoader(Context context) {
        super(context);

        this.mDBHelper = new DataBaseHelper(context);
    }

    @Override
    public ArrayList<Student> loadInBackground() {
        return mDBHelper.getStudents();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
