package ua.com.webacademy.beginnerslection14;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class StudentViewModel extends AndroidViewModel {

    public Student student;

    public StudentViewModel(Application application) {
        super(application);
    }
}
