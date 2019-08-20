package ua.com.webacademy.beginnerslection14;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class Orientation3Activity extends AppCompatActivity {

    private StudentView mStudentView;
    private StudentViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);


        mStudentView = findViewById(R.id.studentView);


        ((MyButton) findViewById(R.id.buttonEdit)).setOnClickListener(
                new MyButton.ClickInterface() {
                    @Override
                    public void onClick() {
                        Student student = new Student("Ivanov", "Ivan", 22);
                        mViewModel.student = student;
                        mStudentView.setStudent(student);
                    }
                }
        );

        ((MyButton) findViewById(R.id.buttonSave)).setOnClickListener(
                new MyButton.ClickInterface() {
                    @Override
                    public void onClick() {
                        if (mStudentView.validate()) {
                            Student student = mStudentView.getStudent();
                            Toast.makeText(Orientation3Activity.this, student.FirstName, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        mViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        if (savedInstanceState != null) {
            if (mViewModel.student != null) {
                mStudentView.setStudent(mViewModel.student);
            }
        }
    }
}
