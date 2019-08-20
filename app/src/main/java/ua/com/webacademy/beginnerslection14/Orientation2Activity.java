package ua.com.webacademy.beginnerslection14;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Orientation2Activity extends AppCompatActivity {

    private StudentView mStudentView;
    private StudentFragment mFragment;

    private static final String TAG_FRAGMENT = "FRAGMENT";

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
                        mFragment.student = student;
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
                            Toast.makeText(Orientation2Activity.this, student.FirstName, Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        android.app.FragmentManager manager = getFragmentManager();
        mFragment = (StudentFragment) manager.findFragmentByTag(TAG_FRAGMENT);

        if (mFragment != null) {
            Student student = mFragment.student;

            if (student != null) {
                mStudentView.setStudent(student);
            }
        } else {
            mFragment = new StudentFragment();

            manager.beginTransaction().add(mFragment, TAG_FRAGMENT).commit();
        }
    }
}
