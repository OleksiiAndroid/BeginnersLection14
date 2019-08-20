package ua.com.webacademy.beginnerslection14;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Orientation1Activity extends AppCompatActivity {

    private static final String EXTRA_STUDENT = "ua.com.webacademy.beginnerslection15.extra.STUDENT";

    private StudentView mStudentView;

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
                            Toast.makeText(Orientation1Activity.this, student.FirstName, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        if (savedInstanceState != null) {
            Student student = savedInstanceState.getParcelable(EXTRA_STUDENT);

            if (student != null) {
                mStudentView.setStudent(student);
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Student student = mStudentView.getStudent();

        if (student != null) {
            outState.putParcelable(EXTRA_STUDENT, student);
        }

        super.onSaveInstanceState(outState);
    }
}
